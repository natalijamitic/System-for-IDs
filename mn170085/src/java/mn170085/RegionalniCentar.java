/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mn170085;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import mn170085.RandomGenerator;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.ObjectMessage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author naca
 */
public class RegionalniCentar implements Initializable {
    
    private final int ID = 17085;
    //private final String sURL = "http://virtserver.swaggerhub.com/petar.noki0x60/ETFTask/1.0.0"; 
    private final String sURL = "http://collabnet.netset.rs:8081/is"; 
    
    private RandomGenerator randomGenerator = new RandomGenerator();
    private Random random = new Random();
    
    // ******** BAZA ********
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("mn170085PU");
    private EntityManager em = emf.createEntityManager();
    // **********************
    
    // ******** KREIRANJE ZAHTEVA ********
    @FXML public Button popuni;
    @FXML public Button isprazni;
    @FXML public TextField jmbg;
    @FXML public TextField datumRodjenja;
    @FXML public TextField ime;
    @FXML public TextField prezime;
    @FXML public TextField imeMajke;
    @FXML public TextField prezimeMajke;
    @FXML public TextField imeOca;
    @FXML public TextField prezimeOca;
    @FXML public ToggleGroup pol;
    @FXML public RadioButton muskiPol;
    @FXML public RadioButton zenskiPol;
    @FXML public ComboBox bracnoStanje;
    @FXML public TextField opstina;
    @FXML public TextField ulica;
    @FXML public TextField broj;
    @FXML public TextField nacionalnost;
    @FXML public TextField profesija;
    @FXML public Button proveriTermin;
    @FXML public Button kreirajZahtev;
    @FXML public Label rezultat;
    ObservableList<String> bracnoStanjeLista = FXCollections.observableArrayList("neozenjen/a", "ozenjen/udata", "razveden/a", "udovac/udovica");
    // ***********************************
    
    // ******** DOHVATANJE ZAHTEVA *******
    @FXML public TextField brojZahteva;
    @FXML public Button dohvatiZahtev;
    @FXML public TextField jmbgDohvati;
    @FXML public TextField datumRodjenjaDohvati;
    @FXML public TextField imeDohvati;
    @FXML public TextField prezimeDohvati;
    @FXML public TextField imeMajkeDohvati;
    @FXML public TextField prezimeMajkeDohvati;
    @FXML public TextField imeOcaDohvati;
    @FXML public TextField prezimeOcaDohvati;
    @FXML public TextField polDohvati;
    @FXML public TextField bracnoStanjeDohvati;
    @FXML public TextField opstinaDohvati;
    @FXML public TextField ulicaDohvati;
    @FXML public TextField brojDohvati;
    @FXML public TextField nacionalnostDohvati;
    @FXML public TextField profesijaDohvati;
    @FXML public TextField statusDohvati;
    @FXML public Button uruciZahtev;
    @FXML public Button osveziStatus;
    @FXML public Label rezultat2;
    // ***********************************
 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bracnoStanje.setItems(bracnoStanjeLista);
        bracnoStanje.setValue(bracnoStanjeLista.get(0));
    }    
    
    
    // ******** KREIRANJE ZAHTEVA ********
    @FXML
    public void popuni() {
      //  Platform.runLater(() -> {
            int randPol = random.nextInt(2);
            boolean musko = false;
            if (randPol == 0) {
                pol.selectToggle(muskiPol);
                musko = true;
            }
            else
                pol.selectToggle(zenskiPol);
            
            String jmbgString = randomGenerator.napraviJMBG(musko);
            jmbg.setText(jmbgString);
            datumRodjenja.setText("1" + jmbgString.charAt(4) + "" + jmbgString.charAt(5) + "" + jmbgString.charAt(6) + "-" + jmbgString.charAt(2) + "" + jmbgString.charAt(3) + "-" + jmbgString.charAt(0) + "" + jmbgString.charAt(1));
            ime.setText(randomGenerator.napraviIme(musko));
            prezime.setText(randomGenerator.napraviPrezime());
            imeMajke.setText(randomGenerator.napraviIme(false));
            prezimeMajke.setText(randomGenerator.napraviPrezime());
            imeOca.setText(randomGenerator.napraviIme(true));
            prezimeOca.setText(randomGenerator.napraviPrezime());
            
            
            opstina.setText(randomGenerator.napraviOpstinu());
            ulica.setText(randomGenerator.napraviUlicu());
            broj.setText(random.nextInt(30) + "");
            nacionalnost.setText(randomGenerator.napraviNacionalnost());
            profesija.setText(randomGenerator.napraviProfesiju());
            
            bracnoStanje.setValue(bracnoStanjeLista.get(random.nextInt(4)));
            
            
            rezultat.setText("");
            
      //  });
    }
    
    @FXML
    public void isprazni() {
        jmbg.clear();
        datumRodjenja.clear();
        ime.clear();
        prezime.clear();
        imeMajke.clear();
        prezimeMajke.clear();
        imeOca.clear();
        prezimeOca.clear();
        pol.selectToggle(muskiPol);
        bracnoStanje.setValue(bracnoStanjeLista.get(1));
        opstina.clear();
        ulica.clear();
        broj.clear();
        nacionalnost.clear();
        profesija.clear();
        rezultat.setText("");
    }
    

    @FXML
    public boolean proveriTermin() {
        try {
            //pravi link
            //URL url = new URL(sURL + "/terminCentar/checkTimeslotAvailability?regionalniCentarId=" + ID + "&termin=" + java.time.LocalDateTime.now().toString());
            //link koji radi
            URL url = new URL(sURL + "/terminCentar/checkTimeslotAvailability?regionalniCentarId=" + ID + "&termin=2020-02-04T09:00:00");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            
            int status = con.getResponseCode();
            
            if (status == 400) {
                rezultat.setText("Nevalidan parametar provere termina.");
                return false;
            }
            else if (status != 200) {
                rezultat.setText("Greska kod provere termina.");
                return false;
            }
            
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonResponse = (JSONObject) jsonParser.parse(readResponseFromConnection(con));
            
            String poruka = (String) jsonResponse.get("poruka");
            boolean dostupnost = (boolean) jsonResponse.get("dostupnost");
            
            //Platform.runLater(()-> { 
                rezultat.setText(poruka);
            //});
            
            return dostupnost;
            
        } catch (Exception ex) {
            Logger.getLogger(RegionalniCentar.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    @FXML
    public void kreirajZahtev() {
        String unetJMBG = jmbg.getText();
        String unetoIme = ime.getText();
        String unetoPrezime = prezime.getText();
        String unetoImeMajke = imeMajke.getText();
        String unetoPrezimeMajke = prezimeMajke.getText();
        String unetoImeOca = imeOca.getText();
        String unetoPrezimeOca = prezimeOca.getText();
        String unetPol = zenskiPol.isSelected() ? "zenski" : "muski";
        String unetDatumRodjenja = datumRodjenja.getText();
        String unetaNacionalnost = nacionalnost.getText();
        String unetaProfesija = profesija.getText();
        String unetoBracnoStanje = bracnoStanje.getValue().toString();
        String unetaOpstina = opstina.getText();
        String unetaUlica = ulica.getText();
        String unetBroj = broj.getText();
        
        if (unetJMBG.length() != 13 || unetoIme.length() == 0 || unetoPrezime.length() == 0 || unetoImeMajke.length() == 0 || unetoImeOca.length() == 0 || unetoPrezimeOca.length() == 0
                || unetPol.length() == 0 || unetDatumRodjenja.length() != 10 || unetaNacionalnost.length() == 0 || unetaProfesija.length() == 0 || unetoBracnoStanje.length() == 0
                || unetaOpstina.length() == 0 || unetaUlica.length() == 0 || unetBroj.length() == 0) {
            rezultat.setText("Nisu ispravno uneti svi podaci.");
            return;
        }
        
        if (proveriTermin()) {
            
            Zahtev zahtev = new Zahtev();
            zahtev.setSve(unetJMBG, unetoIme, unetoPrezime, unetoImeMajke, unetoPrezimeMajke, unetoImeOca, unetoPrezimeOca, unetPol, unetDatumRodjenja, unetaNacionalnost, unetaProfesija, unetoBracnoStanje, unetaOpstina, unetaUlica, unetBroj, "kreiran");
            persistWrap(zahtev);
            zahtev.postaviBrojZahteva();
            mergeWrap(zahtev);

            JMSContext context = Main.conFac.createContext();
            JMSProducer producer = context.createProducer();
                
            try {    
                ObjectMessage objMsg = context.createObjectMessage();
                objMsg.setObject(zahtev);
                producer.send(Main.redZahteva, objMsg);
            } catch (JMSException ex) {
                Logger.getLogger(RegionalniCentar.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        else {
            rezultat.setText("Nedostupan termin.");
        }
        
    }
    // ***********************************
    
    
    // ******** DOHVATANJE ZAHTEVA *******
    @FXML
    public void prikaziZahtev() {
        dohvatiZahtev(false);
    }

    @FXML
    public void uruciZahtev() {
        boolean postoji = dohvatiZahtev(true);
        
        if (!postoji) {
            rezultat2.setText("Nije pronadjen zahtev.");
            return;
        }
        
        Zahtev zahtev = em.createNamedQuery("Zahtev.findByBrojZahteva", Zahtev.class).setParameter("brojZahteva", brojZahteva.getText()).getSingleResult();
        
        if (zahtev.getStatus().equals("cekaNaIzvrsenje") || zahtev.getStatus().equals("proizveden")) {
            zahtev.setStatus("urucen");
            mergeWrap(zahtev);
            statusDohvati.setText("urucen");
            rezultat2.setText("Zahtev urucen.");
            return;
        }
        
        rezultat2.setText("Zahtev nije urucen jer je u statusu " + zahtev.getStatus());
    }
    
    @FXML
    public void osveziStatus() {
        dohvatiZahtev(true);
    }
    // ***********************************
    
    
    private void persistWrap(Zahtev zahtev) {
        em.getTransaction().begin();
        em.persist(zahtev);
        em.flush();
        em.getTransaction().commit();
        rezultat.setText("Kreiran zahtev.");
    }
    
    private void mergeWrap(Zahtev zahtev) {
        em.getTransaction().begin();
        em.merge(zahtev);
        em.flush();
        em.getTransaction().commit();
    }
    
    private String readResponseFromConnection(HttpURLConnection con) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        
        while ((inputLine = in.readLine()) != null)
            content.append(inputLine);
      
        in.close();
        return content.toString();
    }
    
    
        //dodatna funkcija
    public boolean dohvatiTermine() {
        try {
            URL url = new URL(sURL + "/terminCentar/getAvailableTimeslots?regionalniCentarId=" + ID + "&dan=" + java.time.LocalDate.now().toString());
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            
            int status = con.getResponseCode();
            
            if (status != 200)
                return false;
            
            String content = readResponseFromConnection(con);
            
            //System.out.println(content);
            
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonResponse = (JSONObject) jsonParser.parse(content);
            JSONArray termini = (JSONArray) jsonResponse.get("Termins");
            
            //System.out.println(termini.toJSONString());
            
            return true;
        } catch (Exception ex) {
            Logger.getLogger(RegionalniCentar.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    private boolean dohvatiZahtev(boolean samoStatus) {
        try {
            String brZahteva = brojZahteva.getText();
            URL url = new URL(sURL + "/persoCentar/" + brZahteva);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            int status = con.getResponseCode();

            switch (status) {
                case 400:
                    rezultat2.setText("Nevalidan id dokumenta.");
                    reset();
                    return false;
                case 404:
                    rezultat2.setText("Dokument nije nadjen");
                    reset();
                    return false;
                case 200:
                    JSONParser parser = new JSONParser();
                    JSONObject jsonResponse = (JSONObject) parser.parse(readResponseFromConnection(con));
                    
                    if (!samoStatus) {
                        jmbgDohvati.setText((String)jsonResponse.get("JMBG"));
                        datumRodjenjaDohvati.setText((String)jsonResponse.get("datumRodjenja"));
                        imeDohvati.setText((String)jsonResponse.get("ime"));
                        prezimeDohvati.setText((String)jsonResponse.get("prezime"));
                        imeMajkeDohvati.setText((String)jsonResponse.get("imeMajke"));
                        prezimeMajkeDohvati.setText((String)jsonResponse.get("prezimeMajke"));
                        imeOcaDohvati.setText((String)jsonResponse.get("imeOca"));
                        prezimeOcaDohvati.setText((String)jsonResponse.get("prezimeOca"));
                        polDohvati.setText((String)jsonResponse.get("pol"));
                        bracnoStanjeDohvati.setText((String)jsonResponse.get("bracnoStanje"));
                        opstinaDohvati.setText((String)jsonResponse.get("opstinaPrebivalista"));
                        ulicaDohvati.setText((String)jsonResponse.get("ulicaPrebivalista"));
                        brojDohvati.setText((String)jsonResponse.get("brojPrebivalista"));
                        nacionalnostDohvati.setText((String)jsonResponse.get("nacionalnost"));
                        profesijaDohvati.setText((String)jsonResponse.get("profesija"));
                        
                        rezultat2.setText("Zahtev dohvacen");
                    }
                    else 
                        rezultat2.setText("Status osvezen.");
                    
                    Zahtev zahtev = em.createNamedQuery("Zahtev.findByBrojZahteva", Zahtev.class).setParameter("brojZahteva", brojZahteva.getText()).getSingleResult();
                    if (zahtev == null) 
                        System.out.println("Zahtev null u bazi ali nadjen na serveru?!");
                    else if (!((zahtev.getStatus().equals("urucen")) || zahtev.getStatus().equals("cekaNaIzvrsenje")) && !((zahtev.getStatus()).equals((String)jsonResponse.get("status")))) {
                        zahtev.setStatus((String)jsonResponse.get("status"));
                        mergeWrap(zahtev);
                        statusDohvati.setText((String)jsonResponse.get("status"));
                    }
                    else 
                        statusDohvati.setText(zahtev.getStatus());
                    
                    return true;
                default:
                    rezultat2.setText("Greska");
                    return false;
            }
        
        } catch (Exception ex) { rezultat2.setText("Greska"); return false; }
    }
    
    private void reset() {
        jmbgDohvati.clear();
        datumRodjenjaDohvati.clear();
        imeDohvati.clear();
        prezimeDohvati.clear();
        imeMajkeDohvati.clear();
        prezimeMajkeDohvati.clear();
        imeOcaDohvati.clear();
        prezimeOcaDohvati.clear();
        polDohvati.clear();
        bracnoStanjeDohvati.clear();
        opstinaDohvati.clear();
        ulicaDohvati.clear();
        brojDohvati.clear();
        nacionalnostDohvati.clear();
        profesijaDohvati.clear();
        statusDohvati.clear();
    }
}
