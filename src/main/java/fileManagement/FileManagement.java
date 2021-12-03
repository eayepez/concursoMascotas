/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileManagement;

import ec.edu.espol.models.Contest;
import ec.edu.espol.models.Criteria;
import ec.edu.espol.models.Evaluation;
import ec.edu.espol.models.Inscription;
import ec.edu.espol.models.Judge;
import ec.edu.espol.models.Owner;
import ec.edu.espol.models.Pet;
import ec.edu.espol.models.Prize;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author edu
 */
public class FileManagement {
    
    public static ArrayList<Owner> readOwners(String filename){
        ArrayList<Owner> owners = new ArrayList<>();
        File yourFile = new File(filename);
        try {
            yourFile.createNewFile() ;
        } catch (IOException ex) {
            Logger.getLogger(FileManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        try(BufferedReader br = new BufferedReader(new FileReader(yourFile))){
            while(br.ready()){
                String[] data = br.readLine().split(",");
                Owner owner = new Owner(data[0], data[1], data[2],Integer.parseInt(data[3]) );
                owners.add(owner);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileManagement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return owners;
    }
    
    public static void writeOwner(String filename, Owner owner){
        try(PrintWriter pw = new PrintWriter(new FileWriter(new File(filename),true))){
            pw.println(owner.toString());
        } catch (IOException ex) {
            Logger.getLogger(FileManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ArrayList<Contest> readContests(String filename){
        ArrayList<Contest> contests = new ArrayList<>();
        File yourFile = new File(filename);
        try {
            yourFile.createNewFile() ;
        } catch (IOException ex) {
            Logger.getLogger(FileManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        try(BufferedReader br = new BufferedReader(new FileReader(yourFile))){
            while(br.ready()){
                String[] data = br.readLine().split(",");
                Contest contest = new Contest(data[0], data[1]);
                contests.add(contest);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileManagement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contests;
    }
    
    public static void writeContest(String filename, Contest contest){
        try(PrintWriter pw = new PrintWriter(new FileWriter(new File(filename),true))){
            pw.println(contest.toString());
        } catch (IOException ex) {
            Logger.getLogger(FileManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Owner getOwnerByEmail(ArrayList<Owner> owners, String email){
        for(Owner o: owners){
            if(o.getEmail().equals(email)){
                return o;
            }
        }
        System.out.println("There is no owner with that email");
        return null;
    }
    
    public static ArrayList<Pet> readpets(String filename, ArrayList<Owner> owners){
        ArrayList<Pet> pets = new ArrayList<>();
        File yourFile = new File(filename);
        try {
            yourFile.createNewFile() ;
        } catch (IOException ex) {
            Logger.getLogger(FileManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        try(BufferedReader br = new BufferedReader(new FileReader(yourFile))){
            while(br.ready()){
                String[] data = br.readLine().split(",");
                Owner o = getOwnerByEmail(owners, data[1]);
                if(o!=null){
                    Pet pet = new Pet(data[0], o);
                    pets.add(pet);
                }else{
                    System.out.println("Could not add this pet");
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileManagement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pets;
    }
     public static void writepet(String filename, Pet pet){
        try(PrintWriter pw = new PrintWriter(new FileWriter(new File(filename),true))){
            pw.println(pet.toString());
        } catch (IOException ex) {
            Logger.getLogger(FileManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public static Contest getContestByID(ArrayList<Contest> contests, String ID){
        for(Contest c: contests){
            if(c.getID().equals(ID)){
                return c;
            }
        }
        System.out.println("There is no Contest with that ID");
        return null;
    }
    public static ArrayList<Prize> readPrize(String filename, ArrayList <Contest> contests){
        ArrayList<Prize> prizes = new ArrayList<>();
        File yourFile = new File(filename);
        try {
            yourFile.createNewFile() ;
        } catch (IOException ex) {
            Logger.getLogger(FileManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        try(BufferedReader br = new BufferedReader(new FileReader(yourFile))){
            while(br.ready()){
                String[] data = br.readLine().split(",");
                Contest c= getContestByID(contests, data[1]);
                if(c!=null){
                    Prize prize = new Prize(data[0], c, data[2]);
                prizes.add(prize);
                }else{
                    System.out.println("Could not add this prize");
                }
            
                
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileManagement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return prizes;
    } 
    public static void writePrize(String filename, Prize prize){
        try(PrintWriter pw = new PrintWriter(new FileWriter(new File(filename),true))){
            pw.println(prize.toString());
        } catch (IOException ex) {
            Logger.getLogger(FileManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static ArrayList<Criteria> readCriteria(String filename, ArrayList <Contest> contests){
        ArrayList<Criteria> criterias = new ArrayList<>();
        File yourFile = new File(filename);
        try {
            yourFile.createNewFile() ;
        } catch (IOException ex) {
            Logger.getLogger(FileManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        try(BufferedReader br = new BufferedReader(new FileReader(yourFile))){
            while(br.ready()){
                String[] data = br.readLine().split(",");
                Contest c= getContestByID(contests, data[1]);
                if(c!=null){
                    Criteria criteria = new Criteria(data[0], c, data[2]);
                criterias.add(criteria);
                }else{
                    System.out.println("Could not add this criteria");
                }
               
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileManagement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return criterias;
    }
    public static void writeCriteria(String filename, Criteria criteria){
        try(PrintWriter pw = new PrintWriter(new FileWriter(new File(filename),true))){
            pw.println(criteria.toString());
        } catch (IOException ex) {
            Logger.getLogger(FileManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Pet getPetByName(ArrayList<Pet> pets, String name){
        for(Pet p: pets){
            if(p.getName().equals(name)){
                return p;
            }
        }
        System.out.println("There is no Pet with that name");
        return null;
    }
    
    public static ArrayList<Inscription> readInscription(String filename, ArrayList <Pet> pets, ArrayList < Contest> contests){
        ArrayList<Inscription> inscriptions = new ArrayList<>();
        File yourFile = new File(filename);
        try {
            yourFile.createNewFile() ;
        } catch (IOException ex) {
            Logger.getLogger(FileManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        try(BufferedReader br = new BufferedReader(new FileReader(yourFile))){
            while(br.ready()){
                String[] data = br.readLine().split(",");
                Pet pet= getPetByName(pets, data[1]);
                Contest contest=getContestByID(contests, data[2]);
                if(contest!=null && pet!=null){
                  Inscription inscription = new Inscription(data[0],pet,contest,Double.parseDouble(data[3]),LocalDate.parse(data[4]));
                  inscriptions.add(inscription);
                }else{
                    System.out.println("Could not add this inscription");
                }
                
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileManagement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return inscriptions;
    }
    public static void writeInscription(String filename, Inscription inscription){
        try(PrintWriter pw = new PrintWriter(new FileWriter(new File(filename),true))){
            pw.println(inscription.toString());
        } catch (IOException ex) {
            Logger.getLogger(FileManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static ArrayList<Judge> readJudge(String filename, ArrayList <Contest> contests){
        ArrayList<Judge> judges = new ArrayList<>();
        File yourFile = new File(filename);
        try {
            yourFile.createNewFile() ;
        } catch (IOException ex) {
            Logger.getLogger(FileManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        try(BufferedReader br = new BufferedReader(new FileReader(yourFile))){
            while(br.ready()){
                String[] data = br.readLine().split(",");
                Contest contest=getContestByID(contests, data[3]);
                if(contest!=null){
                  Judge judge = new Judge(data[0], data[1],data[2], contest);
                judges.add(judge);
                }else{
                    System.out.println("Could not add this contest");
                }
                
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileManagement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return judges;
    }
    public static void writeJudge(String filename, Judge judge){
        try(PrintWriter pw = new PrintWriter(new FileWriter(new File(filename),true))){
            pw.println(judge.toString());
        } catch (IOException ex) {
            Logger.getLogger(FileManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static Judge getJudgeByemail(ArrayList<Judge> judges, String email){
        for(Judge j: judges){
            if(j.getEmail().equals(email)){
                return j;
            }
        }
        System.out.println("There is no Judge with that name");
        return null;
    }
    public static Inscription getInscriptionByID(ArrayList<Inscription> inscriptions, String ID){
        for(Inscription i: inscriptions){
            if(i.getID().equals(ID)){
                return i;
            }
        }
        System.out.println("There is no inscription with that ID");
        return null;
    }
    public static Criteria getCriteriaByID(ArrayList<Criteria> criterias, String ID){
        for(Criteria c: criterias){
            if(c.getID().equals(ID)){
                return c;
            }
        }
        System.out.println("There is no criteria with that ID");
        return null;
    }
    
    public static ArrayList<Evaluation> readEvaluation(String filename,ArrayList<Criteria> criterias,ArrayList<Inscription> inscriptions,ArrayList<Judge> judges){
        ArrayList<Evaluation> evaluations = new ArrayList<>();
        File yourFile = new File(filename);
        try {
            yourFile.createNewFile() ;
        } catch (IOException ex) {
            Logger.getLogger(FileManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        try(BufferedReader br = new BufferedReader(new FileReader(yourFile))){
            while(br.ready()){
                String[] data = br.readLine().split(",");
                Judge judge= getJudgeByemail(judges, data[0]);
                Inscription inscription= getInscriptionByID(inscriptions, data[2]);
                Criteria critiria = getCriteriaByID(criterias, data[3]);
                if(critiria!=null && judge!= null && inscription!= null){
                  Evaluation evaluation = new Evaluation(judge,Double.parseDouble(data[1]),inscription,critiria);
                evaluations.add(evaluation);
                }else{
                    System.out.println("Could not add this evaluation");
                }
                
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileManagement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return evaluations;
    
    }
    public static void writeEvaluation(String filename, Evaluation evaluation){
        try(PrintWriter pw = new PrintWriter(new FileWriter(new File(filename),true))){
            pw.println(evaluation.toString());
        } catch (IOException ex) {
            Logger.getLogger(FileManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
}
