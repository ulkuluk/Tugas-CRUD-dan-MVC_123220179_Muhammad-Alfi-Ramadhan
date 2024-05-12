/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOimplement;
import java.util.List;
import Model.*;
/**
 *
 * @author alfi
 */
public interface dataMovieimplement {
    public void insert(dataMovie p);
    public void update(dataMovie p);
    public void delete(String Judul);
    public List<dataMovie> getAll();
}
