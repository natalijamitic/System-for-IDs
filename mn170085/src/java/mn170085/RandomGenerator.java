/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mn170085;

/**
 *
 * @author naca
 */
public class RandomGenerator {
    private final static String imenaZ[] = {"Nikolina", "Tamara", "Andjela", "Dragana", "Mirjana", "Marija", "Kristina", "Danijela", "Maja", "Jovana"};
    private final static String imenaM[] = {"Nikola", "Milos", "Aleksandar", "Novica", "Vuk", "Marko", "Igor", "Ognjen", "Dusan", "Stefan"};
    private final static String prezimena[] = {"Jovanovic", "Popovic", "Petrovic", "Nikolic", "Markovic", "Stefanovic", "Stojanovic", "Krstic", "Cosic", "Pesic"};
    private final static String opstine[] = {"Kragujevac", "Arandjelovac", "Novi Sad", "Nis", "Subotica", "Novi Pazar", "Zemun", "Vracar", "Stari Grad", "Savski Venac"};
    private final static String ulice[] = {"Cara Dusana", "Jovana J. Zmaja", "Vuka Karadzica", "Kralja Petra", "Kralja Milana", "Desanke Maksimovic", "Vladike N. Velimirovica", "Bregovita", "Kneza Milosa", "Nade Petrovic"};
    private final static String nacionalnosti[] = {"neizjasnjen", "srpska", "nemacka", "engleska", "hrvatska", "turska", "francuska", "madjarska", "italijanska", "spanska"};
    private final static String profesije[] = {"student", "lekar", "veterinar", "stolar", "vodoinstalater", "mehanicar", "bez profesije", "policajac", "postar", "prodavac"};
    
    public String napraviIme(boolean musko) {
        int izaberi = randBetween(0, 9);
        if (musko)
            return imenaM[izaberi];
        return imenaZ[izaberi];
    }
    
    public String napraviPrezime() {
        int izaberi = randBetween(0, 9);
        return prezimena[izaberi];
    }
    
    public String napraviOpstinu() {
        int izaberi = randBetween(0, 9);
        return opstine[izaberi];
    }
    
    public String napraviUlicu() {
        int izaberi = randBetween(0, 9);
        return ulice[izaberi];
    }
    
    public String napraviNacionalnost() {
        int izaberi = randBetween(0, 9);
        return nacionalnosti[izaberi];
    }
    
    public String napraviProfesiju() {
        int izaberi = randBetween(0, 9);
        return profesije[izaberi];
    }
    
    public String napraviJMBG(boolean male){
        int[] jmbg = new int[13];
        int year = randBetween(1920, 2001);
        int month = randBetween(1, 12);
        int day = randBetween(1, 28);
        int region = randBetween(0, 99);
        int gender;
        if (male)
            gender = randBetween(0, 499);
        else
            gender = randBetween(500, 999);
        int control;

        if(day < 10)
            jmbg[0] = 0;
        else
            jmbg[0] = day / 10;
        jmbg[1] = day % 10;

        
        if(month < 10)
            jmbg[2] = 0;
        else
            jmbg[2] = month / 10;
        jmbg[3] = month % 10;

        
        if(year % 1000 < 100)
            jmbg[4] = 0;
        else
            jmbg[4] = (year % 1000) / 100;
        if(year % 100 < 10)
            jmbg[5] = 0;
        else
            jmbg[5] = (year % 100) / 10;
        jmbg[6] = day % 10;

        
        if(region < 10)
            jmbg[7] = 0;
        else
            jmbg[7] = region / 10;
        jmbg[8] = region % 10;

        
        if(gender % 1000 < 100)
            jmbg[9] = 0;
        else
            jmbg[9] = (gender % 1000) / 100;
        if(gender % 100 < 10)
            jmbg[10] = 0;
        else
            jmbg[10] = (gender % 100) / 10;
        jmbg[11] = gender % 10;

        control = 11 - ((7*jmbg[0] +6*jmbg[1] +5*jmbg[2] +4*jmbg[3] +3*jmbg[4] +2*jmbg[5] +7*jmbg[6] +6*jmbg[7] +5*jmbg[8] +4*jmbg[9] +3*jmbg[10] +2*jmbg[11])%11);

        if (control >= 10)
            control = 0;

        jmbg[12] = control;

        String JMBG = "";

        for (int digit:jmbg) {
            JMBG += Integer.toString(digit);
        }

        return JMBG;
    }


    private static int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }
    
}
