/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JUAN MERCEDES
 */
public class ClienteRepositoryArchivo implements ClienteRepository{

    public List<Cliente> clientes = new ArrayList<>();
    
    public ClienteRepositoryArchivo (){
        clientes.add(new Cliente());
         clientes.add(new Cliente());
          clientes.add(new Cliente());
          clientes.get(0).nombre="Juan";
          clientes.get(1).nombre="Marcos";
          clientes.get(2).nombre="Evans";
    }

    @Override
    public Cliente obtenerClientePorNombre(String nombre) {
        for (int i=0;i<clientes.size();i++){
            if(clientes.get(i).nombre.equals(nombre)){
                return clientes.get(i);
            }
        }
        return null;
    }

}
