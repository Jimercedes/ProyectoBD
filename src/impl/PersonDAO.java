/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package impl;

import model.Person;

/**
 *
 * @author JUAN MERCEDES
 */
public interface PersonDAO {
    void create(Person person);
    Person getBycedula(String cedula);
    
    void update(Person person);
    void delete(String cedula);
    
}
