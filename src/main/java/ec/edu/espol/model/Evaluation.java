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
public class Evaluation {
    private Judge judge;
    private double grade;
    private Inscription inscription;
    private Criteria criteria;

    public Evaluation(Judge judge, double grade, Inscription inscription, Criteria criteria) {
        this.judge = judge;
        this.grade = grade;
        this.inscription = inscription;
        this.criteria = criteria;
    }

    public Judge getJudge() {
        return judge;
    }

    public void setJudge(Judge judge) {
        this.judge = judge;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public Inscription getInscription() {
        return inscription;
    }

    public void setInscription(Inscription inscription) {
        this.inscription = inscription;
    }

    public Criteria getCriteria() {
        return criteria;
    }

    public void setCriteria(Criteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public String toString() {
        return judge.getEmail() + "," + grade + "," + inscription.getID() + "," + criteria.getID() ;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.judge);
        hash = 97 * hash + Objects.hashCode(this.inscription);
        hash = 97 * hash + Objects.hashCode(this.criteria);
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
        final Evaluation other = (Evaluation) obj;
        if (!Objects.equals(this.judge, other.judge)) {
            return false;
        }
        if (!Objects.equals(this.inscription, other.inscription)) {
            return false;
        }
        if (!Objects.equals(this.criteria, other.criteria)) {
            return false;
        }
        return true;
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
    
    public static ArrayList<Evaluation> readEvaluations(String nombreArchivo){
        
        ArrayList<Evaluation> evaluations = new ArrayList<>();
        
        try{          
   	
            BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
            String línea;

            while ((línea = br.readLine()) != null) {
                try {
                    String[] contenido= línea.split(",");
                    Evaluation evaluation = new Evaluation(Judge.getJudgeByEmail(contenido[0]), Double.parseDouble(contenido[1]), Inscription.getInscriptionByID(contenido[2]), Criteria.getCriteriaByID(contenido[3]));
                    evaluations.add(evaluation);                    
                }
                catch(NullPointerException npe) {
                    Alert a = new Alert(Alert.AlertType.ERROR, "SE REFERENCIA A INFORMACIÓN INEXISTENTE");
                    a.show();                      
                } 
                catch(NumberFormatException nfe) {
                    Alert a = new Alert(Alert.AlertType.ERROR, "LA PUNTUACIÓN NO ESTÁ EN EL FORMATO CORRECTO");
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
        return evaluations;
    } 
}
