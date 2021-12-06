/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.concursomascotasproyecto;

import ec.edu.espol.models.Contest;
import ec.edu.espol.models.Criteria;
import ec.edu.espol.models.Evaluation;
import ec.edu.espol.models.Inscription;
import ec.edu.espol.models.Judge;
import ec.edu.espol.models.Owner;
import ec.edu.espol.models.Prize;
import ec.edu.espol.models.Pet;
import fileManagement.FileManagement;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author edu
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
            
            System.out.println("MENÚ DE OPCIONES");
            System.out.println("1. Dueno");
            System.out.println("2. Mascota");
            System.out.println("3. Concurso");
            System.out.println("4. Premio");
            System.out.println("5. Criterio");
            System.out.println("6. Inscripcion");
            System.out.println("7. Miembro jurado");
            System.out.println("8. Evaluacion");
            System.out.println("9. Salir");
            System.out.println("");
            System.out.println("Ingrese el número de la opción que desea: ");
            
            int opt = keyboard.nextInt(); 
            
            
            while(opt <1 || opt >9){
                System.out.println("Opción no disponible. Intente de nuevo por favor");
                System.out.println("");                
                System.out.println("MENÚ DE OPCIONES");
                System.out.println("1. Dueno");
                System.out.println("2. Mascota");
                System.out.println("3. Concurso");
                System.out.println("4. Premio");
                System.out.println("5. Criterio");
                System.out.println("6. Inscripcion");
                System.out.println("7. Miembro jurado");
                System.out.println("8. Evaluacion");
                System.out.println("9. Salir");
                System.out.println("");
                System.out.println("Ingrese el número de la opción que desea: ");
                opt = keyboard.nextInt(); 
            }
            
            switch(opt){
                case 1 -> {
                    Owner o =Owner.nextOwner(); 
                    owners.add(o);
                    FileManagement.writeOwner("owners.txt", o);
                }
                case 2 -> {
                    Pet p =Pet.nextPet(owners); 
                    pets.add(p);
                    FileManagement.writepet("pets.txt", p);
                }
                case 3 -> {
                    Contest c =Contest.nextContest(); 
                    contests.add(c);
                    FileManagement.writeContest("contests.txt", c);
                }
                case 4 -> {
                    Prize pr =Prize.nextPrize(contests); 
                    prizes.add(pr);
                    FileManagement.writePrize("prizes.txt", pr);
                }
                case 5 -> {
                    Criteria cr =Criteria.nextCriteria(contests); 
                    criterias.add(cr);
                    FileManagement.writeCriteria("criterias.txt", cr);
                }
                case 6 -> {
                    Inscription i =Inscription.nextInscription(contests, pets); 
                    inscriptions.add(i);
                    FileManagement.writeInscription("inscriptions.txt", i);
                }
                case 7 -> {
                    Judge j =Judge.nextJudge(contests); 
                    judges.add(j);
                    FileManagement.writeJudge("judges.txt", j);
                }
                case 8 -> {
                    Evaluation e =Evaluation.nextEvaluation(judges, criterias, inscriptions); 
                    evaluations.add(e);
                    FileManagement.writeEvaluation("evaluations.txt", e);
                }
                case 9 -> control = "N";
            }
            
            if(opt >0 && opt <9){
                System.out.println("Desea volver al menu? (S/N)");
                control = keyboard.next();
            }   
        }            
    }
}
