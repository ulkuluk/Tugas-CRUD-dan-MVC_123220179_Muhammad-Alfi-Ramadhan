/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import java.util.List;
import DAOdataMovie.dataMovieDAO;
import DAOimplement.dataMovieimplement;
import Model.*;
import View.MainView;
/**
 *
 * @author alfi
 */
public class dataMovieController {
    MainView frame;
    dataMovieimplement impldatamovie;
    List<dataMovie> dm;
    
    public dataMovieController(MainView frame){
        this.frame = frame;
        impldatamovie = new dataMovieDAO();
        dm = impldatamovie.getAll();
    }
    public void isitabel(){
        dm = impldatamovie.getAll();
        modelTabelDataMovie mp = new modelTabelDataMovie(dm);
        frame.getTabelData().setModel(mp);
    }
    
    public void insert(){
        dataMovie dm = new dataMovie();
        dm.setJudul(frame.getjTextJudul().getText());
        dm.setAlur(Integer.parseInt(frame.getjTextAlur().getText()));
        dm.setPenokohan(Integer.parseInt(frame.getjTextPenokohan().getText()));
        dm.setAkting(Integer.parseInt(frame.getjTextAkting().getText()));
        impldatamovie.insert(dm);
        
    }
    
    public void update(){
        dataMovie dm = new dataMovie();
        dm.setJudul(frame.getjTextJudul().getText());
        dm.setAlur(Integer.parseInt(frame.getjTextAlur().getText()));
        dm.setPenokohan(Integer.parseInt(frame.getjTextPenokohan().getText()));
        dm.setAkting(Integer.parseInt(frame.getjTextAkting().getText()));
        impldatamovie.update(dm);
        
    }
    
    public void delete(){
        String Judul = (frame.getjTextJudul().getText());
        impldatamovie.delete(Judul);
    }
    
    
}
