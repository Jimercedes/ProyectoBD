/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import impl.PersonDAO;
import model.Person;



public class PersonService {
    
    private  PersonDAO personDAO;
    public void createPerson(Person person){
        personDAO.create(person);
    }
    public PersonService(PersonDAO personDAO){
        this.personDAO = personDAO;
        
    }
    public Person getByCedula(String cedula){
        return personDAO.getBycedula(cedula);
    }
    public void updatePerson(Person person){
        personDAO.update(person);
    }
    public void delete (String cedula){
        personDAO.delete(cedula);
    }
}
