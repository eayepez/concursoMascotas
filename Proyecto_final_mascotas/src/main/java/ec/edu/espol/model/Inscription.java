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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Objects;
import javafx.scene.control.Alert;

/**
 *
 * @author Paul
 */
public class Inscription {
    private String ID;
    private Pet pet;
    private Contest contest;
    private double price;
    private LocalDate date;

    public Inscription(String ID, Pet pet, Contest contest, double price, LocalDate date) {
        this.ID = ID;
        this.pet = pet;
        this.contest = contest;
        this.price = price;
        this.date = date;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Contest getContest() {
        return contest;
    }

    public void setContest(Contest contest) {
        this.contest = contest;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.ID);
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
        final Inscription other = (Inscription) obj;
        if (!Objects.equals(this.ID, other.ID)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ID + "," + pet.getName() + "," + contest.getID() + "," + price + "," + date ;
    }

    public static Inscription getInscriptionByID(String ID) {
        ArrayList<Inscription> inscriptions = Inscription.readInscriptions("inscripciones.txt");
        for(Inscription inscription : inscriptions){
            if(inscription.getID().equals(ID)){
                return inscription;
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
    
    public static ArrayList<Inscription> readInscriptions(String nombreArchivo){
        
        ArrayList<Inscription> inscriptions = new ArrayList<>();
        
        try{          
   	
            BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
            String línea;

            while ((línea = br.readLine()) != null) {
                try {
                    String[] contenido= línea.split(",");

                    String date= contenido[4];
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate localDate = LocalDate.parse(date, formatter); 

                    Inscription inscription = new Inscription(contenido[0], Pet.getPetByName(contenido[1]), Contest.getContestByID(contenido[2]), Double.parseDouble(contenido[3]), localDate);
                    inscriptions.add(inscription);                    
                }
                catch(NullPointerException npe) {
                    Alert a = new Alert(Alert.AlertType.ERROR, "SE REFERENCIA A INFORMACIÓN INEXISTENTE");
                    a.show();                      
                } 
                catch(NumberFormatException nfe) {
                    Alert a = new Alert(Alert.AlertType.ERROR, "EL PRECIO NO ESTÁ EN EL FORMATO CORRECTO");
                    a.show();                      
                } 
                catch(DateTimeParseException dtps) {
                    Alert a = new Alert(Alert.AlertType.ERROR, "LA FECHA NO ESTÁ EN EL FORMATO CORRECTO");
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
        return inscriptions;
    } 
}
