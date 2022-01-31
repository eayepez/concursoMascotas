/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import ec.edu.espol.model.Pet;
import java.util.ArrayList;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Edu
 */
public class Consultar_mascotasController extends Concurso_mascotasController implements Initializable {

    @FXML
    private ScrollPane sp_consulta;
    @FXML
    private VBox vbox_consultas;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList<Pet> pets = Pet.readPets("mascotas.txt");
        for (Pet pet : pets) {
            Label label_pet = new Label(pet.toString());
            ImageView image = new ImageView(new Image(pet.getImagePath(),true));
            image.setFitHeight(100);
            image.setFitWidth(100);
            HBox petContainer = new HBox(label_pet, image);
            vbox_consultas.getChildren().add(petContainer);
            sp_consulta.setContent(vbox_consultas);
        }
        
    }    

}
