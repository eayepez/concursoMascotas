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
 * @author edu
 */
public class Prize {
    
    private String ID;
    private Contest contest;
    private String description;

    public Prize(String ID, Contest contest, String description) {
        this.ID = ID;
        this.contest = contest;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        final Prize other = (Prize) obj;
        if (!Objects.equals(this.ID, other.ID)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ID + "," + contest.getID() + "," + description;
    }
    
    
    static Scanner keyboard= new Scanner(System.in);

    public static Prize nextPrize(ArrayList<Contest> contests){
        System.out.println("Ingrese el código del premio");
        String ID= keyboard.next();
        System.out.println("Ingrese el id del consurso");
        String idcont= keyboard.next();
        System.out.println("Ingrese descripción del premio");
        keyboard.nextLine();
        String description= keyboard.nextLine();
        Prize prize= new Prize(ID,FileManagement.getContestByID(contests, idcont),description);
        return prize;
    }    
}
