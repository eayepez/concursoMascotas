/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.models;

import java.util.Objects;
import java.util.Scanner;

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
    
    static Scanner keyboard= new Scanner(System.in);
    
    public static Contest nextContest (){
        System.out.println("Ingrese el nombre del concurso");
        keyboard.nextLine();
        String name= keyboard.nextLine();
        System.out.println("Ingrese id");
        String ID = keyboard.next();
        Contest contest= new Contest(name, ID);
        return contest;
    }    
}