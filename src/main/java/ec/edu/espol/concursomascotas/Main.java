/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.concursomascotas;

import ec.edu.espol.models.Contest;
import ec.edu.espol.models.Criteria;
import ec.edu.espol.models.Evaluation;
import ec.edu.espol.models.Inscription;
import ec.edu.espol.models.Judge;
import ec.edu.espol.models.Owner;
import ec.edu.espol.models.Prize;
import ec.edu.espol.models.Pet;
import fileManagement.FileManagement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author paula
 */
public class Main {
    
    static Scanner keyboard= new Scanner(System.in);
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Owner> owners = FileManagement.readOwners("owners.txt");
        ArrayList<Pet> pets = FileManagement.readpets("pets.txt", owners);
        ArrayList<Contest> contests = FileManagement.readContests("contests.txt");
        ArrayList<Prize> prizes = FileManagement.readPrize("prizes.txt", contests);
        ArrayList<Criteria> criterias = FileManagement.readCriteria("criterias.txt", contests);
        ArrayList<Inscription> inscriptions = FileManagement.readInscription("inscriptions.txt", pets, contests);
        ArrayList<Judge> judges = FileManagement.readJudge("judges.txt", contests);
        ArrayList<Evaluation> evaluations = FileManagement.readEvaluation("evaluations.txt", criterias, inscriptions, judges);
        
        String control = "S";
        
        while(control.toUpperCase().equals("S")){
            
            System.out.println("1. Ingresar dueno");
            System.out.println("2. Ingresar mascota");
            System.out.println("3. Ingresar concurso");
            System.out.println("4. Ingresar premio");
            System.out.println("5. Ingresar criterio");
            System.out.println("6. Ingresar inscripcion");
            System.out.println("7. Ingresar miembro jurado");
            System.out.println("8. Ingresar evaluacion");
            System.out.println("9. Salir");
            System.out.println("Ingrese la opcion: ");
            
            int opt = keyboard.nextInt(); 
            
            
            while(opt <1 || opt >8){
                System.out.println("Ingrese la opcion: ");
                opt = keyboard.nextInt(); 
            }
            
            switch(opt){
                case 1 -> {
                    Owner o =nextOwner(); 
                    owners.add(o);
                    FileManagement.writeOwner("owners.txt", o);
                }
                case 2 -> {
                    Pet p =nextPet(owners); 
                    pets.add(p);
                    FileManagement.writepet("pets.txt", p);
                }
                case 3 -> {
                    Contest c =nextContest(); 
                    contests.add(c);
                    FileManagement.writeContest("contests.txt", c);
                }
                case 4 -> {
                    Prize pr =nextPrize(contests); 
                    prizes.add(pr);
                    FileManagement.writePrize("prizes.txt", pr);
                }
                case 5 -> {
                    Criteria cr =nextCriteria(contests); 
                    criterias.add(cr);
                    FileManagement.writeCriteria("criterias.txt", cr);
                }
                case 6 -> {
                    Inscription i =nextInscription(contests, pets); 
                    inscriptions.add(i);
                    FileManagement.writeInscription("inscriptions.txt", i);
                }
                case 7 -> {
                    Judge j =nextJudge(contests); 
                    judges.add(j);
                    FileManagement.writeJudge("judges.txt", j);
                }
                case 8 -> {
                    Evaluation e =nextEvaluation(judges, criterias, inscriptions); 
                    evaluations.add(e);
                    FileManagement.writeEvaluation("evaluations.txt", e);
                }
                case 9 -> control = "N";
            }
            
            if(opt > 0 && opt<9){
                System.out.println("Desea volver al menu? (S/N)");
                control = keyboard.next();
            }
            
        }
                
         
    }
    
    
    public static Owner nextOwner (){
        System.out.println("Ingrese Cedula");
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
    public static Pet nextPet (ArrayList<Owner> owners){
        System.out.println("Ingrese nombre");
        String name= keyboard.next();
        System.out.println("Ingrese email del dueno");
        String email = keyboard.next();
        Pet pet= new Pet (name,FileManagement.getOwnerByEmail(owners, email));
        return pet;
        }
    public static Judge nextJudge (ArrayList<Contest> contests){
        System.out.println("Ingrese Cedula");
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
    public static Contest nextContest (){
        System.out.println("Ingrese Nombre de Competencia");
        keyboard.nextLine();
        String name= keyboard.nextLine();
        System.out.println("Ingrese id");
        String ID = keyboard.next();
        Contest contest= new Contest(name, ID);
        return contest;
        }
    public static Prize nextPrize(ArrayList<Contest> contests){
        System.out.println("Ingrese Codigo de premio");
        String ID= keyboard.next();
        System.out.println("Ingrese id de consurso");
        String idcont= keyboard.next();
        System.out.println("Ingrese Descripcion del premio");
        keyboard.nextLine();
        String description= keyboard.nextLine();
        Prize prize= new Prize(ID,FileManagement.getContestByID(contests, idcont),description);
        return prize;
        }
    public static Criteria nextCriteria (ArrayList<Contest> contests){
        System.out.println("Ingrese id");
        String ID= keyboard.next();
        System.out.println("Ingrese id concurso");
        String contest= keyboard.next();
        System.out.println("Ingrese Reglas del criterio");
        keyboard.nextLine();
        String rule= keyboard.nextLine();
        
        Criteria criteria= new Criteria(ID, FileManagement.getContestByID(contests, contest), rule);
        return criteria;
        }
    public static Inscription nextInscription(ArrayList<Contest> contests, ArrayList<Pet> pets){
        System.out.println("Ingrese id");
        String ID= keyboard.next();
        System.out.println("Ingrese nombre de mascota");
        String pet= keyboard.next();
        System.out.println("Ingrese id de consurso");
        String contest= keyboard.next();
        System.out.println("Ingrese precio");
        double price = keyboard.nextDouble();
        System.out.println("Ingrese Fecha (dd/MM/yyyy)");
        String date= keyboard.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        //convert String to LocalDate
        LocalDate localDate = LocalDate.parse(date, formatter);
        Inscription inscription = new Inscription(ID, FileManagement.getPetByName(pets, pet), FileManagement.getContestByID(contests, contest), price, localDate);
        return inscription;
        }
    public static Evaluation nextEvaluation (ArrayList<Judge> judges, ArrayList<Criteria> criterias, ArrayList<Inscription> inscriptions){
        System.out.println("Ingrese email del Juez");
        String judge= keyboard.next();
        System.out.println("Ingrese nota");
        double grade= keyboard.nextDouble();
        System.out.println("Ingrese id de inscripcion");
        String inscription= keyboard.next();
        System.out.println("Ingrese id de criterio");
        String criteria = keyboard.next();
        Evaluation evaluation= new Evaluation(FileManagement.getJudgeByemail(judges, judge), grade, FileManagement.getInscriptionByID(inscriptions, inscription), FileManagement.getCriteriaByID(criterias, criteria));
        return evaluation;
        }
}
