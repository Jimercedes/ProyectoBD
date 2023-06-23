package Service;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


import dao.PersonDAOImplementation;
import model.Person;

/**
 *
 * @author JUAN MERCEDES
 */
public class ProyectoDB2 {

    public static void main(String[] args) {
        //creando persona\
        PersonService personService = new PersonService(new PersonDAOImplementation() {});
        Person person = new Person();
       person.nombre = "Kaht";
       person.apellido ="Pontier";
       person.edad = "quesiyoqe";
       person.cedula= "1234562";
       personService.createPerson(person);
       
       //obtrener persona
       
       String cedula = "40222018810";
       Person personFromDB = personService.getByCedula(cedula);
        System.out.println("Person from DB");
        System.out.println("Persona nombre "+personFromDB.nombre);
        
        
        //update perosna
        personFromDB.nombre = "Katherine";
        personService.updatePerson(personFromDB);
        
        //Delete persona
        
        personService.delete(cedula);
       
    }
}
