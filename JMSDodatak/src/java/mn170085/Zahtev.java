/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mn170085;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author naca
 */
@Entity
@Table(name = "zahtev")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zahtev.findAll", query = "SELECT z FROM Zahtev z"),
    @NamedQuery(name = "Zahtev.findByIdZahteva", query = "SELECT z FROM Zahtev z WHERE z.idZahteva = :idZahteva"),
    @NamedQuery(name = "Zahtev.findByJmbg", query = "SELECT z FROM Zahtev z WHERE z.jmbg = :jmbg"),
    @NamedQuery(name = "Zahtev.findByIme", query = "SELECT z FROM Zahtev z WHERE z.ime = :ime"),
    @NamedQuery(name = "Zahtev.findByPrezime", query = "SELECT z FROM Zahtev z WHERE z.prezime = :prezime"),
    @NamedQuery(name = "Zahtev.findByImeMajke", query = "SELECT z FROM Zahtev z WHERE z.imeMajke = :imeMajke"),
    @NamedQuery(name = "Zahtev.findByPrezimeMajke", query = "SELECT z FROM Zahtev z WHERE z.prezimeMajke = :prezimeMajke"),
    @NamedQuery(name = "Zahtev.findByImeOca", query = "SELECT z FROM Zahtev z WHERE z.imeOca = :imeOca"),
    @NamedQuery(name = "Zahtev.findByPrezimeOca", query = "SELECT z FROM Zahtev z WHERE z.prezimeOca = :prezimeOca"),
    @NamedQuery(name = "Zahtev.findByPol", query = "SELECT z FROM Zahtev z WHERE z.pol = :pol"),
    @NamedQuery(name = "Zahtev.findByDatumRodjenja", query = "SELECT z FROM Zahtev z WHERE z.datumRodjenja = :datumRodjenja"),
    @NamedQuery(name = "Zahtev.findByNacionalnost", query = "SELECT z FROM Zahtev z WHERE z.nacionalnost = :nacionalnost"),
    @NamedQuery(name = "Zahtev.findByProfesija", query = "SELECT z FROM Zahtev z WHERE z.profesija = :profesija"),
    @NamedQuery(name = "Zahtev.findByBracnoStanje", query = "SELECT z FROM Zahtev z WHERE z.bracnoStanje = :bracnoStanje"),
    @NamedQuery(name = "Zahtev.findByOpstina", query = "SELECT z FROM Zahtev z WHERE z.opstina = :opstina"),
    @NamedQuery(name = "Zahtev.findByUlica", query = "SELECT z FROM Zahtev z WHERE z.ulica = :ulica"),
    @NamedQuery(name = "Zahtev.findByBrojUlice", query = "SELECT z FROM Zahtev z WHERE z.brojUlice = :brojUlice"),
    @NamedQuery(name = "Zahtev.findByStatus", query = "SELECT z FROM Zahtev z WHERE z.status = :status"),
    @NamedQuery(name = "Zahtev.findByBrojZahteva", query = "SELECT z FROM Zahtev z WHERE z.brojZahteva = :brojZahteva")})
public class Zahtev implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idZahteva")
    private Integer idZahteva;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "jmbg")
    private String jmbg;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ime")
    private String ime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "prezime")
    private String prezime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "imeMajke")
    private String imeMajke;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "prezimeMajke")
    private String prezimeMajke;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "imeOca")
    private String imeOca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "prezimeOca")
    private String prezimeOca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "pol")
    private String pol;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "datumRodjenja")
    private String datumRodjenja;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nacionalnost")
    private String nacionalnost;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "profesija")
    private String profesija;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "bracnoStanje")
    private String bracnoStanje;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "opstina")
    private String opstina;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ulica")
    private String ulica;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "brojUlice")
    private String brojUlice;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "brojZahteva")
    private String brojZahteva;

    public Zahtev() {
    }

    public Zahtev(Integer idZahteva) {
        this.idZahteva = idZahteva;
    }

    public Zahtev(Integer idZahteva, String jmbg, String ime, String prezime, String imeMajke, String prezimeMajke, String imeOca, String prezimeOca, String pol, String datumRodjenja, String nacionalnost, String profesija, String bracnoStanje, String opstina, String ulica, String brojUlice, String status, String brojZahteva) {
        this.idZahteva = idZahteva;
        this.jmbg = jmbg;
        this.ime = ime;
        this.prezime = prezime;
        this.imeMajke = imeMajke;
        this.prezimeMajke = prezimeMajke;
        this.imeOca = imeOca;
        this.prezimeOca = prezimeOca;
        this.pol = pol;
        this.datumRodjenja = datumRodjenja;
        this.nacionalnost = nacionalnost;
        this.profesija = profesija;
        this.bracnoStanje = bracnoStanje;
        this.opstina = opstina;
        this.ulica = ulica;
        this.brojUlice = brojUlice;
        this.status = status;
        this.brojZahteva = brojZahteva;
    }

    public Integer getIdZahteva() {
        return idZahteva;
    }

    public void setIdZahteva(Integer idZahteva) {
        this.idZahteva = idZahteva;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getImeMajke() {
        return imeMajke;
    }

    public void setImeMajke(String imeMajke) {
        this.imeMajke = imeMajke;
    }

    public String getPrezimeMajke() {
        return prezimeMajke;
    }

    public void setPrezimeMajke(String prezimeMajke) {
        this.prezimeMajke = prezimeMajke;
    }

    public String getImeOca() {
        return imeOca;
    }

    public void setImeOca(String imeOca) {
        this.imeOca = imeOca;
    }

    public String getPrezimeOca() {
        return prezimeOca;
    }

    public void setPrezimeOca(String prezimeOca) {
        this.prezimeOca = prezimeOca;
    }

    public String getPol() {
        return pol;
    }

    public void setPol(String pol) {
        this.pol = pol;
    }

    public String getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(String datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public String getNacionalnost() {
        return nacionalnost;
    }

    public void setNacionalnost(String nacionalnost) {
        this.nacionalnost = nacionalnost;
    }

    public String getProfesija() {
        return profesija;
    }

    public void setProfesija(String profesija) {
        this.profesija = profesija;
    }

    public String getBracnoStanje() {
        return bracnoStanje;
    }

    public void setBracnoStanje(String bracnoStanje) {
        this.bracnoStanje = bracnoStanje;
    }

    public String getOpstina() {
        return opstina;
    }

    public void setOpstina(String opstina) {
        this.opstina = opstina;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getBrojUlice() {
        return brojUlice;
    }

    public void setBrojUlice(String brojUlice) {
        this.brojUlice = brojUlice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBrojZahteva() {
        return brojZahteva;
    }

    public void setBrojZahteva(String brojZahteva) {
        this.brojZahteva = brojZahteva;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idZahteva != null ? idZahteva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zahtev)) {
            return false;
        }
        Zahtev other = (Zahtev) object;
        if ((this.idZahteva == null && other.idZahteva != null) || (this.idZahteva != null && !this.idZahteva.equals(other.idZahteva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mn170085.Zahtev[ idZahteva=" + idZahteva + " ]";
    }
    
}
