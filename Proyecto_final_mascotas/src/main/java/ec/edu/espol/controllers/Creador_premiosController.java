/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controllers;

import ec.edu.espol.model.Contest;
import ec.edu.espol.model.Owner;
import ec.edu.espol.model.Prize;
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
public class Creador_premiosController extends Concurso_mascotasController implements Initializable {

    @FXML
    private TextField tf_id;
    @FXML
    private TextField tf_id_concurso;
    @FXML
    private TextField tf_descripción;
    @FXML
    private Button bt_crear_premio;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void CrearNuevoPremio(ActionEvent event) {
        if (!(tf_id.getText().equals("")) && !(tf_id_concurso.getText().equals("")) && !(tf_descripción.getText().equals(""))) {
            try {
                Prize prize = new Prize(tf_id.getText(), Contest.getContestByID(tf_id_concurso.getText()), tf_descripción.getText());
                prize.saveToFile("premios.txt");
                tf_id.setText("");
                tf_id_concurso.setText("");
                tf_descripción.setText("");
                Alert a = new Alert(Alert.AlertType.INFORMATION, "PREMIO CREADO CON ÉXITO");
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
