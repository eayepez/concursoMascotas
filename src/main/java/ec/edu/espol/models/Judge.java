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
    
    
    static Scanner keyboard= new Scanner(System.in);

    public static Judge nextJudge (ArrayList<Contest> contests){
        System.out.println("Ingrese cédula");
        String ID= keyboard.next();
        System.out.println("Ingrese nombre");
        String name= keyboard.next();
        System.out.println("Ingrese email");
        String email= keyboard.next();
        System.out.println("Ingrese el id del concuro");
        String contestID = keyboard.next();
        Judge judge= new Judge(ID, name, email, FileManagement.getContestByID(contests, contestID));
        return judge;
    }    
}
