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
public class Contest {
    private String name;
    private String ID;

    public Contest(String name, String ID) {
        this.name = name;
        this.ID = ID;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return name + "," + ID;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.ID);
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
        final Contest other = (Contest) obj;
        if (!Objects.equals(this.ID, other.ID)) {
            return false;
        }
        return true;
    }
    
    public static Contest getContestByID(String ID) {
        ArrayList<Contest> contests = readContests("concursos.txt");
        for(Contest contest: contests){
            if(contest.getID().equals(ID)){
                return contest;
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
    
    public static ArrayList<Contest> readContests(String nombreArchivo){
        
        ArrayList<Contest> contests = new ArrayList<>();
        
        try{          
   	
            BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
            String línea;

            while ((línea = br.readLine()) != null) {
                try {
                    String[] contenido= línea.split(",");
                    Contest contest = new Contest(contenido[0], contenido[1]);
                    contests.add(contest);                
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
        return contests;
    }  
}