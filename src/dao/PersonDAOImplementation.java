/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import impl.PersonDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Person;

/**
 *
 * @author JUAN MERCEDES
 */
public class PersonDAOImplementation implements PersonDAO{
    
     String url = "jdbc:mysql://localhost:3306/PersonaPrueba*";
            String username = "root";
            String password ="Prueba01*";
            
          

    @Override
    public void create(Person person) {
        try (Connection connection = DriverManager.getConnection(url,username,password)){
            String sql = "INSERT INTO persona (nombre, apellido,edad,cedula)VALUES (?,?,?,?)";
            try(PreparedStatement statement = connection.prepareStatement(sql)){
                
                statement.setString(1, person.nombre);
                statement.setString(2, person.apellido);
                statement.setString(3, person.edad);
                statement.setString(4, person.cedula);
                
                statement.executeUpdate();
            }catch(SQLException e){
                e.printStackTrace();
                
        }
        
           }catch(SQLException e){
               e.printStackTrace();
           }
    }

    @Override
    public  Person getBycedula(String cedula) {
        try (Connection connection = DriverManager.getConnection(url, username, password)){
            String sqlQuery = "SELECT nombre, apellido, edad, cedula FROM person WHERE cedula=?"; 
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            //String telefono = null;
            //tengo que arreglar lo de cedula y telefono
            statement.setString(1,cedula );
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                String nombre = rs.getString(1);
                String apellido = rs.getString(2);
                String edad = rs.getString(3);
                
                Person person = new Person();
                
                person.nombre = nombre;
                person.apellido = apellido;
                person.edad = edad;
                person.cedula = cedula;
                return person;
            }
                
            }catch(SQLException e){
                e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Person person) {
        try (Connection connection  = DriverManager.getConnection(url, username,password)){
            String sql = "update persona set nombre=?, apellid=?, edad=?, cedula=? where cedula=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setString(1, person.nombre);
            statement.setString(2, person.apellido);
            statement.setString(3, person.edad);
            statement.setString(4, person.cedula);
            
            statement.executeUpdate();
            
        }catch (SQLException e){
            e.printStackTrace();
        }
        
    }

    @Override
    public void delete(String cedula) {
        try(Connection connection = DriverManager.getConnection(url,username, password)){
            String sql = "delete from persona where telefono=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setString(1, cedula);
            
            statement.executeUpdate();
            
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    
}
