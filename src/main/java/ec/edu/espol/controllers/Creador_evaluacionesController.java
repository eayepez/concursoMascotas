/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controllers;

import ec.edu.espol.model.Criteria;
import ec.edu.espol.model.Evaluation;
import ec.edu.espol.model.Inscription;
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
 * @author Paul
 */
public class Creador_evaluacionesController extends Concurso_mascotasController implements Initializable {

    @FXML
    private TextField tf_email_juez;
    @FXML
    private TextField tf_calificación;
    @FXML
    private TextField tf_id_inscripción;
    @FXML
    private TextField tf_id_criterio;
    @FXML
    private Button bt_crear_evaluación;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void CrearNuevaEvaluación(ActionEvent event) {
        if (!(tf_email_juez.getText().equals("")) && !(tf_calificación.getText().equals("")) && !(tf_id_inscripción.getText().equals("")) && !(tf_id_criterio.getText().equals(""))) {
            try {
                Evaluation evaluation = new Evaluation(Judge.getJudgeByEmail(tf_email_juez.getText()), Double.parseDouble(tf_calificación.getText()), Inscription.getInscriptionByID(tf_id_inscripción.getText()), Criteria.getCriteriaByID(tf_id_criterio.getText()));
                evaluation.saveToFile("evaluaciones.txt");
                tf_email_juez.setText("");
                tf_calificación.setText("");
                tf_id_inscripción.setText("");
                tf_id_criterio.setText("");
                Alert a = new Alert(Alert.AlertType.INFORMATION, "EVALUACIÓN CREADO CON ÉXITO");
                a.show();
            }
            catch(NullPointerException npe) {
                Alert a = new Alert(Alert.AlertType.ERROR, "SE REFERENCIA A INFORMACIÓN INEXISTENTE");
                a.show();                      
            } 
            catch(NumberFormatException nfe) {
                Alert a = new Alert(Alert.AlertType.ERROR, "LA PUNTUACIÓN NO ESTÁ EN EL FORMATO CORRECTO");
                a.show();                      
            } 
        }
        else {
            Alert a = new Alert(Alert.AlertType.ERROR, "HACE FALTA INFORMACIÓN");
            a.show();            
        }        
    }


}
