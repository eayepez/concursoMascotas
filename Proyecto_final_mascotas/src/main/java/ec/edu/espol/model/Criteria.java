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
public class Criteria {
    private String ID;
    private Contest contest;
    private String rule;

    public Criteria(String ID, Contest contest, String rule) {
        this.ID = ID;
        this.contest = contest;
        this.rule = rule;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Contest getContest() {
        return contest;
    }

    public void setContest(Contest contest) {
        this.contest = contest;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.ID);
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
        final Criteria other = (Criteria) obj;
        if (!Objects.equals(this.ID, other.ID)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ID + "," + contest.getID() + "," + rule;
    }

    public static Criteria getCriteriaByID(String ID) {
        ArrayList<Criteria> criteria_list = Criteria.readCriteria("criterios.txt");
        for(Criteria criteria : criteria_list){
            if(criteria.getID().equals(ID)){
                return criteria;
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
    
    public static ArrayList<Criteria> readCriteria(String nombreArchivo){
        
        ArrayList<Criteria> criteria_list = new ArrayList<>();
        
        try{          
            
            BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
            String línea;

            while ((línea = br.readLine()) != null) {
                try {
                    String[] contenido= línea.split(",");
                    Criteria criteria = new Criteria(contenido[0], Contest.getContestByID(contenido[1]), contenido[2]);
                    criteria_list.add(criteria);                     
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
        return criteria_list;
    }     
}
