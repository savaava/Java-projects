/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contest1.gruppo77.interfaces;
import contest1.gruppo77.classes.Person;
import java.util.List;
/**
 *
 * @author solon
 */
public interface Filterable {
    public List<Person> filter(PersonFilter f);
}
