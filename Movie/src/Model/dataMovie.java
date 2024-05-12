/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author alfi
 */
public class dataMovie {
    private String Judul;
    private int Alur;
    private int Penokohan;
    private int Akting;
    private int Rating;

    public String getJudul() {
        return Judul;
    }

    public void setJudul(String Judul) {
        this.Judul = Judul;
    }

    public int getAlur() {
        return Alur;
    }

    public void setAlur(int Alur) {
        this.Alur = Alur;
    }

    public int getPenokohan() {
        return Penokohan;
    }

    public void setPenokohan(int Penokohan) {
        this.Penokohan = Penokohan;
    }

    public int getAkting() {
        return Akting;
    }

    public void setAkting(int Akting) {
        this.Akting = Akting;
    }

    public int getRating() {
        Rating = (Alur + Penokohan + Akting)/3;
        return Rating;
    }

    public void setRating(int Rating) {
        this.Rating = Rating;
    }
    
    
    
}
