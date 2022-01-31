/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controllers;

import ec.edu.espol.model.Owner;
import ec.edu.espol.model.Pet;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author Paul
 */
public class Creador_mascotasController extends Concurso_mascotasController implements Initializable {

    private String imagePath = null;
    @FXML
    private TextField tf_nombre;
    @FXML
    private TextField tf_email;
    @FXML
    private Button bt_crear_mascota;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void CrearNuevaMascota(ActionEvent event) {
        //System.out.println("Image path:¨" +this.imagePath);
        if (!(tf_nombre.getText().equals("")) && !(tf_email.getText().equals("")) && !(this.imagePath == null)) {
            try {
                Pet pet = new Pet(tf_nombre.getText(), Owner.getOwnerByEmail(tf_email.getText()));
                pet.setImagePath(imagePath);
                pet.saveToFile("mascotas.txt");
                tf_nombre.setText("");
                tf_email.setText("");
                Alert a = new Alert(Alert.AlertType.INFORMATION, "MASCOTA CREADA CON ÉXITO");
                a.show();
            }
            catch(NullPointerException npe) {
                Alert a = new Alert(Alert.AlertType.ERROR, "SE REFERENCIA A UN DUEÑO INEXISTENTE");
                a.show();                      
            } 
        }
        else {
            Alert a = new Alert(Alert.AlertType.ERROR, "HACE FALTA INFORMACIÓN");
            a.show();            
        }        
    }
    
    @FXML
    private void openUploadFileDialog(){
        FileChooser fileChooser = new FileChooser();

        //Set extension filter
        FileChooser.ExtensionFilter extFilterJPG
                = new FileChooser.ExtensionFilter("JPG files (.JPG)", "*.JPG");
        FileChooser.ExtensionFilter extFilterjpg
                = new FileChooser.ExtensionFilter("jpg files (.jpg)", "*.jpg");
        FileChooser.ExtensionFilter extFilterPNG
                = new FileChooser.ExtensionFilter("PNG files (.PNG)", "*.PNG");
        FileChooser.ExtensionFilter extFilterpng
                = new FileChooser.ExtensionFilter("png files (.png)", "*.png");
        fileChooser.getExtensionFilters()
                .addAll(extFilterJPG, extFilterjpg, extFilterPNG, extFilterpng);
        //Show open file dialog
        File imageFile = fileChooser.showOpenDialog(null);
        this.imagePath = imageFile.getAbsolutePath();

    }
    


}
