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
public class Judge {
    private String ID;
    private String name;
    private String email;
    private Contest contest;

    public Judge(String ID, String name, String email, Contest contest) {
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.contest = contest;
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

    public Contest getContest() {
        return contest;
    }

    public void setContest(Contest contest) {
        this.contest = contest;
    }

    @Override
    public String toString() {
        return ID + "," + name + "," + email + "," + contest.getID();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.ID);
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
        final Judge other = (Judge) obj;
        if (!Objects.equals(this.ID, other.ID)) {
            return false;
        }
        return true;
    }
      
    public static Judge getJudgeByEmail(String email) {
        ArrayList<Judge> judges = Judge.readJudges("miembroJurados.txt");
        for(Judge judge : judges){
            if(judge.getEmail().equals(email)){
                return judge;
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
    
    public static ArrayList<Judge> readJudges(String nombreArchivo){
        
        ArrayList<Judge> judges = new ArrayList<>();
        
        try{          
            
            BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
            String línea;

            while ((línea = br.readLine()) != null) {
                try {
                    String[] contenido= línea.split(",");
                    Judge judge = new Judge(contenido[0], contenido[1], contenido[2], Contest.getContestByID(contenido[3]));
                    judges.add(judge);                      
                }
                catch(NullPointerException npe) {
                    Alert a = new Alert(Alert.AlertType.ERROR, "SE REFERENCIA A UN CONCURSO INEXISTENTE");
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
        return judges;
    }    
}
