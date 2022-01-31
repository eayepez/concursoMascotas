/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controllers;

import ec.edu.espol.model.Contest;
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
 * @author Edu
 */
public class Creador_concursosController extends Concurso_mascotasController implements Initializable {

    @FXML
    private TextField tf_nombre;
    @FXML
    private TextField tf_id;
    @FXML
    private Button bt_crear_concurso;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void CrearNuevoConcurso(ActionEvent event) {
        if (!(tf_nombre.getText().equals("")) && !(tf_id.getText().equals(""))) {
            Contest contest = new Contest(tf_nombre.getText(), tf_id.getText());
            contest.saveToFile("concursos.txt");
            tf_nombre.setText("");
            tf_id.setText("");
            Alert a = new Alert(Alert.AlertType.INFORMATION, "CONCURSO CREADO CON ÉXITO");
            a.show();
        }
        else {
            Alert a = new Alert(Alert.AlertType.ERROR, "HACE FALTA INFORMACIÓN");
            a.show();            
        }        
    }


}
