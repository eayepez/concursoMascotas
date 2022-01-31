/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controllers;

import ec.edu.espol.model.Contest;
import ec.edu.espol.model.Criteria;
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
public class Creador_criteriosController extends Concurso_mascotasController implements Initializable {

    @FXML
    private TextField tf_id;
    @FXML
    private TextField tf_id_concurso;
    @FXML
    private TextField tf_regla;
    @FXML
    private Button bt_crear_criterio;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void CrearNuevoCriterio(ActionEvent event) {
        if (!(tf_id.getText().equals("")) && !(tf_id_concurso.getText().equals("")) && !(tf_regla.getText().equals(""))) {
            try {
                Criteria criteria = new Criteria(tf_id.getText(), Contest.getContestByID(tf_id_concurso.getText()), tf_regla.getText());
                criteria.saveToFile("criterios.txt");
                tf_id.setText("");
                tf_id_concurso.setText("");
                tf_regla.setText("");
                Alert a = new Alert(Alert.AlertType.INFORMATION, "CRITERIO CREADO CON ÉXITO");
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
