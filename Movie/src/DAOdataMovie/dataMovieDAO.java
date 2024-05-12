/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOdataMovie;
import java.sql.*;
import java.util.*;
import Koneksi.connector;
import Model.*;
import DAOimplement.dataMovieimplement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author alfi
 */
public class dataMovieDAO implements dataMovieimplement{
    Connection connection;
    
    final String select = "SELECT * FROM movie;";
    final String insert = "INSERT INTO movie (Judul, Alur, Penokohan, Akting, Rating) VALUES (?, ?, ?, ?, ?);";
    final String update = "update movie set Alur=?, Penokohan=?, Akting=?, Rating=? where Judul=?";
    final String delete = "delete from movie where Judul=?";
    
    public dataMovieDAO(){
        connection = connector.connection();
    }

    @Override
    public void insert(dataMovie p) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, p.getJudul());
            statement.setInt(2,p.getAlur());
            statement.setInt(3,p.getPenokohan());
            statement.setInt(4,p.getAkting());
            statement.setInt(5,p.getRating());
            statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(dataMovie p) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(update);
            statement.setInt(1, p.getAlur());
            statement.setInt(2, p.getPenokohan());
            statement.setInt(3, p.getAkting());
            statement.setInt(4, p.getRating());
            statement.setString(5, p.getJudul());
            
            statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(String Judul) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(delete);
            statement.setString(1, Judul);
            statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex ){
                ex.printStackTrace();
            }
        }
    }
    
    

    @Override
    public List<dataMovie> getAll() {
        List<dataMovie> dm = null;
        try{
            dm = new ArrayList<dataMovie>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                dataMovie movie = new dataMovie();
                movie.setJudul(rs.getString("Judul"));
                movie.setAlur(rs.getInt("Alur"));
                movie.setPenokohan(rs.getInt("Penokohan"));
                movie.setAkting(rs.getInt("Akting"));
                movie.setRating(rs.getInt("Rating"));
                dm.add(movie);
                
            }
        }catch(SQLException ex){
            Logger.getLogger(dataMovieDAO.class.getName()).log(Level.SEVERE, null,ex);
        }
        
        return dm;
    }
}
