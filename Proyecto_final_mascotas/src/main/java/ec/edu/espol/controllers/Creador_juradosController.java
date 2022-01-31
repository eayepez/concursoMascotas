/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controllers;

import ec.edu.espol.model.Contest;
import ec.edu.espol.model.Judge;
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
public class Creador_juradosController extends Concurso_mascotasController implements Initializable {

    @FXML
    private TextField tf_id;
    @FXML
    private TextField tf_nombre;
    @FXML
    private TextField tf_email;
    @FXML
    private TextField tf_id_concurso;
    @FXML
    private Button bt_crear_jurado;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void CrearNuevoJurado(ActionEvent event) {
        if (!(tf_id.getText().equals("")) && !(tf_nombre.getText().equals("")) && !(tf_email.getText().equals("")) && !(tf_id_concurso.getText().equals(""))) {
            try {
                Judge judge = new Judge(tf_id.getText(), tf_nombre.getText(), tf_email.getText(), Contest.getContestByID(tf_id_concurso.getText()));
                judge.saveToFile("miembroJurados.txt");
                tf_id.setText("");
                tf_nombre.setText("");
                tf_email.setText("");
                tf_id_concurso.setText("");
                Alert a = new Alert(Alert.AlertType.INFORMATION, "MIEMBRO DEL JURADO CREADO CON ÉXITO");
                a.show();
            }
            catch(NullPointerException npe) {
                Alert a = new Alert(Alert.AlertType.ERROR, "SE REFERENCIA A UN CONCURSO INEXISTENTE");
                a.show();                      
            }  
        }
        else {
            Alert a = new Alert(Alert.AlertType.ERROR, "HACE FALTA INFORMACIÓN");
            a.show();            
        }        
    }


}
