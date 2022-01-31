/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controllers;

import ec.edu.espol.model.Owner;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Paul
 */
public class Creador_dueñosController extends Concurso_mascotasController implements Initializable {

    @FXML
    private TextField tf_id;
    @FXML
    private TextField tf_nombre;
    @FXML
    private TextField tf_email;
    @FXML
    private TextField tf_edad;
    @FXML
    private Button bt_crear_dueño;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void CrearNuevoDueño(ActionEvent event) {
        if (!(tf_id.getText().equals("")) && !(tf_nombre.getText().equals("")) && !(tf_email.getText().equals("")) && !(tf_edad.getText().equals(""))) {
            try {
                Owner owner = new Owner(tf_id.getText(), tf_nombre.getText(), tf_email.getText(), Integer.parseInt(tf_edad.getText()));
                owner.saveToFile("dueños.txt");
                tf_id.setText("");
                tf_nombre.setText("");
                tf_email.setText("");
                tf_edad.setText("");
                Alert a = new Alert(Alert.AlertType.INFORMATION, "DUEÑO CREADO CON ÉXITO");
                a.show();
            }
            catch(NumberFormatException nfe) {
                Alert a = new Alert(Alert.AlertType.ERROR, "LA EDAD NO ESTÁ EN EL FORMATO CORRECTO");
                a.show();                      
            }
        }
        else {
            Alert a = new Alert(Alert.AlertType.ERROR, "HACE FALTA INFORMACIÓN");
            a.show();            
        }
    }


}
