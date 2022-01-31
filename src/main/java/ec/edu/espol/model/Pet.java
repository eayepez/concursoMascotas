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
public class Pet {
    private String name;
    private Owner owner;
    private String imagePath;

    public Pet(String name, Owner owner) {
        this.name = name;
        this.owner = owner;
    }
    
    public Pet(String name, Owner owner, String imagePath) {
        this.name = name;
        this.owner = owner;
        this.imagePath = imagePath;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return name + "," + owner.getEmail() + "," +imagePath;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.name);
        hash = 29 * hash + Objects.hashCode(this.owner);
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
        final Pet other = (Pet) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.owner, other.owner)) {
            return false;
        }
        return true;
    }
    
    public static Pet getPetByName(String name) {
        ArrayList<Pet> pets = readPets("mascotas.txt");
        for(Pet pet : pets){
            if(pet.getName().equals(name)){
                return pet;
            }
        }
        return null;
    }      
    
    public void saveToFile(String nombreArchivo) {
       
        try{          
    	    String contenido = this.toString();
   	
            BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo, true));  
            bw.newLine();
            bw.append(contenido);   	
            bw.close();
        }

        catch(IOException ioe){
            Alert a = new Alert(Alert.AlertType.ERROR, "HA OCURRIDO UN ERROR");
            a.show();  
        }
    }    
    
    public static ArrayList<Pet> readPets(String nombreArchivo){
        
        ArrayList<Pet> pets = new ArrayList<>();
        
        try{          
   	
            BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
            String línea;

            while ((línea = br.readLine()) != null) {
                try {
                    String[] contenido= línea.split(",");
                    Pet pet = new Pet(contenido[0], Owner.getOwnerByEmail(contenido[1]));
                    pet.setImagePath("file:"+contenido[2]);
                    pets.add(pet);                    
                }
                catch(NullPointerException npe) {
                    Alert a = new Alert(Alert.AlertType.ERROR, "SE REFERENCIA A UN DUEÑO INEXISTENTE");
                    a.show();                      
                }      
                catch(ArrayIndexOutOfBoundsException ae) {
                    Alert a = new Alert(Alert.AlertType.ERROR, "LA INFORMACIÓN NO ESTÁ COMPLETA");
                    a.show();                    
                }                
            }
        }

        catch(IOException ioe){
            Alert a = new Alert(Alert.AlertType.ERROR, "EL ARCHIVO CON LA INFORMACIÓN NO EXISTE");
            a.show();  
        }
        return pets;
    }    
}
