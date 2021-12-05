/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.models;

import fileManagement.FileManagement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

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
    
    
    static Scanner keyboard= new Scanner(System.in);
    
    public static Inscription nextInscription(ArrayList<Contest> contests, ArrayList<Pet> pets){
        System.out.println("Ingrese id");
        String ID= keyboard.next();
        System.out.println("Ingrese el nombre de la mascota");
        String pet= keyboard.next();
        System.out.println("Ingrese el id de consurso");
        String contest= keyboard.next();
        System.out.println("Ingrese precio");
        double price = keyboard.nextDouble();
        System.out.println("Ingrese fecha (dd/MM/yyyy)");
        String date= keyboard.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        //convert String to LocalDate
        LocalDate localDate = LocalDate.parse(date, formatter);
        Inscription inscription = new Inscription(ID, FileManagement.getPetByName(pets, pet), FileManagement.getContestByID(contests, contest), price, localDate);
        return inscription;
    }    
}
