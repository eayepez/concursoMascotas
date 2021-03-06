/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import javafx.scene.control.Alert;

/**
 *
 * @author Paul
 */
public class Owner {
    private String ID;
    private String name;
    private String email;
    private int age;

    public Owner(String ID, String name, String email, int age) {
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.email);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Owner other = (Owner) obj;
        return Objects.equals(this.email, other.email);
    }

    @Override
    public String toString() {
        return ID + "," + name + "," + email + "," + age;
    }
    
    public static Owner getOwnerByEmail(String email) {
        ArrayList<Owner> owners = readOwners("due??os.txt");
        for(Owner owner: owners){
            if(owner.getEmail().equals(email)){
                return owner;
            }
        }
        return null;
    }      
    
    public void saveToFile(String nombreArchivo) {
       
        try{          
    	    String contenido = this.toString();
   	
            BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo, true));        
            bw.write(contenido+"\n");   	
            bw.close();
        }

        catch(IOException ioe){
            Alert a = new Alert(Alert.AlertType.ERROR, "HA OCURRIDO UN ERROR");
            a.show();  
        }
    }    
    
    public static ArrayList<Owner> readOwners(String nombreArchivo){
        
        ArrayList<Owner> owners = new ArrayList<>();
        
        try{          
   	
            BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
            String l??nea;

            while ((l??nea = br.readLine()) != null) {
                try {
                    String[] contenido= l??nea.split(",");
                    Owner owner = new Owner(contenido[0], contenido[1], contenido[2], Integer.parseInt(contenido[3]));
                    owners.add(owner);                 
                }
                catch(NumberFormatException nfe) {
                    Alert a = new Alert(Alert.AlertType.ERROR, "LA EDAD NO EST?? EN EL FORMATO CORRECTO");
                    a.show();                      
                }
                catch(ArrayIndexOutOfBoundsException ae) {
                    Alert a = new Alert(Alert.AlertType.ERROR, "LA INFORMACI??N NO EST?? COMPLETA");
                    a.show();                    
                }
            }
        }

        catch(IOException ioe){
            Alert a = new Alert(Alert.AlertType.ERROR, "EL ARCHIVO CON LA INFORMACI??N NO EXISTE");
            a.show();  
        }
        return owners;
    }
    
}
