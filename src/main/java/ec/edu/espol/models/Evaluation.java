/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.models;

import fileManagement.FileManagement;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

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

    
    static Scanner keyboard= new Scanner(System.in);
    
    public static Evaluation nextEvaluation (ArrayList<Judge> judges, ArrayList<Criteria> criterias, ArrayList<Inscription> inscriptions){
        System.out.println("Ingrese email del Juez");
        String judge= keyboard.next();
        System.out.println("Ingrese nota");
        double grade= keyboard.nextDouble();
        System.out.println("Ingrese el id de inscripci??n");
        String inscription= keyboard.next();
        System.out.println("Ingrese id del criterio");
        String criteria = keyboard.next();
        Evaluation evaluation= new Evaluation(FileManagement.getJudgeByemail(judges, judge), grade, FileManagement.getInscriptionByID(inscriptions, inscription), FileManagement.getCriteriaByID(criterias, criteria));
        return evaluation;
        }
}
