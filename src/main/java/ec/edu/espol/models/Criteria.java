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

    
    static Scanner keyboard= new Scanner(System.in);
    
    public static Criteria nextCriteria (ArrayList<Contest> contests){
        System.out.println("Ingrese id");
        String ID= keyboard.next();
        System.out.println("Ingrese el id del concurso");
        String contest= keyboard.next();
        System.out.println("Ingrese reglas del criterio");
        keyboard.nextLine();
        String rule= keyboard.nextLine();
        
        Criteria criteria= new Criteria(ID, FileManagement.getContestByID(contests, contest), rule);
        return criteria;
        }    
}
