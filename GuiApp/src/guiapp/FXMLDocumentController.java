/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiapp;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
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

/**
 *
 * @author naca
 */
public class FXMLDocumentController implements Initializable {
    
    private RandomGenerator randomGenerator = new RandomGenerator();
    private Random random = new Random();
    
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
    @FXML public Label rezultatProvereTermina;
    @FXML public Label rezultatKreiranjaZahteva;
    ObservableList<String> bracnoStanjeLista = FXCollections.observableArrayList("Vencan/a", "Nije vencan/a", "Udovac/ica", "Razveden/a");
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
    @FXML public Label rezultatDohvatanjaZahteva;
    @FXML public Label rezultatOsvezavanjaStatusa;
    // ***********************************
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bracnoStanje.setItems(bracnoStanjeLista);
        bracnoStanje.setValue("Nije vencan/a");   
        System.out.println("Jmbg: " + jmbg);
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
            datumRodjenja.setText(jmbgString.charAt(0) + "" + jmbgString.charAt(1) + "." + jmbgString.charAt(2) + "" + jmbgString.charAt(3) + ".1" + jmbgString.charAt(4) + "" + jmbgString.charAt(5) + "" + jmbgString.charAt(6) + "." );
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
    }
    
    @FXML
    public void proveriTermin() {
        System.out.println("proveri");
    }
    
    @FXML
    public void kreirajZahtev() {
        System.out.println("kreiraj");
    }
    // ***********************************
    
    
    // ******** DOHVATANJE ZAHTEVA *******
    @FXML
    public void prikaziZahtev() {
        System.out.println("prikazi");
    }
    
    @FXML
    public void osveziStatus() {
        System.out.println("osvezi");
    }
    
    @FXML
    public void uruciZahtev() {
        System.out.println("uruci");
    }
    // ***********************************
    
}
