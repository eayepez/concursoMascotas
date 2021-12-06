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
 * @author edu
 */
public class Owner {
    private String ID;
    private String name;
    private String email;
    private int age;

    public Owner(String ID, String name, String email, int age) {
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.age = age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.email);
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
        final Owner other = (Owner) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ID + ","+name+","+email+","+age;
    }
    
    static Scanner keyboard= new Scanner(System.in);
    
    public static Owner nextOwner (){
    System.out.println("Ingrese cédula");
    String ID= keyboard.next();
    System.out.println("Ingrese nombre");
    String name= keyboard.next();
    System.out.println("Ingrese email");
    String email= keyboard.next();
    System.out.println("Ingrese edad");
    int age = keyboard.nextInt();
    Owner owner= new Owner(ID, name, email, age);
    return owner;
    }
    
}
