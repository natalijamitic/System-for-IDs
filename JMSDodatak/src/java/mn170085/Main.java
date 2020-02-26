/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mn170085;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author naca
 */
public class Main {
    
    @Resource(lookup = "jms/__defaultConnectionFactory")
    public static ConnectionFactory conFac;
    
    @Resource(lookup = "zahtevi")
    public static Queue redZahteva;
    
    //private static final String sURL = "http://virtserver.swaggerhub.com/petar.noki0x60/ETFTask/1.0.0";
    private static final String sURL = "http://collabnet.netset.rs:8081/is"; 
    
    // ******** BAZA ********
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("JMSDodatakPU");
    private static EntityManager em = emf.createEntityManager();
    // **********************
    
    public static void main(String[] args) {
        JMSContext context = conFac.createContext();
        JMSConsumer consumer = context.createConsumer(redZahteva);
        JMSProducer producer = context.createProducer();
        
        System.out.println("START");
        
        while (true) {
            Message msg = consumer.receive();
            if (msg instanceof ObjectMessage) {
                
                try {
                
                    ObjectMessage objMsg = (ObjectMessage) msg;
                    Zahtev zahtev = (Zahtev) objMsg.getObject();
                   
                    URL url = new URL(sURL + "/persoCentar/submit");
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    con.setRequestMethod("POST");
                    con.setRequestProperty("Content-Type", "application/json");
                    
                    con.setDoOutput(true);
                    DataOutputStream out = new DataOutputStream(con.getOutputStream());
                    
                    String jsonString = createJSONStringFromZahtev(zahtev);
                    System.out.println(jsonString);
                    out.writeBytes(jsonString);
                    
                    out.flush();
                    out.close();
                    
                    int status = con.getResponseCode();

                    if (status == 201 || status == 200) {
                        zahtev.setStatus("uProdukciji");
                        mergeWrap(zahtev);
                        
                        JSONParser jsonParser = new JSONParser();
                        JSONObject jsonResponse = (JSONObject) jsonParser.parse(readResponseFromConnection(con));
                        
                        String brojZahteva = (String)jsonResponse.get("id");
                        System.out.println("Na server poslat zahtev " + zahtev.getBrojZahteva() + " server primio " + brojZahteva);
                    }
                    else {
                        try {
                            System.out.println(status + " Neuspesno slanje zahteva.");
                            ObjectMessage objMsgNew = context.createObjectMessage();
                            objMsgNew.setObject(zahtev);
                            producer.send(redZahteva, objMsgNew);
                        } catch (JMSException ex) {
                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                    }
                
                } catch (ParseException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException | JMSException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    private static String createJSONStringFromZahtev(Zahtev zahtev) {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("JMBG", zahtev.getJmbg());
        jsonObj.put("bracnoStanje", zahtev.getBracnoStanje());
        jsonObj.put("brojPrebivalista", zahtev.getBrojUlice());
        jsonObj.put("datumRodjenja", zahtev.getDatumRodjenja());
        jsonObj.put("id", zahtev.getBrojZahteva());
        jsonObj.put("ime", zahtev.getIme());
        jsonObj.put("imeMajke", zahtev.getImeMajke());
        jsonObj.put("imeOca", zahtev.getImeOca());
        jsonObj.put("nacionalnost", zahtev.getNacionalnost());
        jsonObj.put("opstinaPrebivalista", zahtev.getOpstina());
        jsonObj.put("pol", zahtev.getPol());
        jsonObj.put("prezime", zahtev.getPrezime());
        jsonObj.put("prezimeMajke", zahtev.getPrezimeMajke());
        jsonObj.put("prezimeOca", zahtev.getPrezimeOca());
        jsonObj.put("profesija", zahtev.getProfesija());
        jsonObj.put("ulicaPrebivalista", zahtev.getUlica());
        return jsonObj.toJSONString();
    }
    
    private static String readResponseFromConnection(HttpURLConnection con) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null)
            content.append(inputLine);
        
        in.close();
        return content.toString();
    }
    
    private static void mergeWrap(Zahtev zahtev) {
        em.getTransaction().begin();
        em.merge(zahtev);
        em.flush();
        em.getTransaction().commit();
    }
}
