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
import ec.edu.espol.model.Evaluation;
import java.util.ArrayList;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Paul
 */
public class Consultar_evaluacionesController extends Concurso_mascotasController implements Initializable {

    @FXML
    private ScrollPane sp_consulta;
    @FXML
    private VBox vbox_consultas;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList<Evaluation> evaluations = Evaluation.readEvaluations("evaluaciones.txt");
        for (Evaluation evaluation : evaluations) {
            Label label_evaluation = new Label(evaluation.toString());
            vbox_consultas.getChildren().add(label_evaluation);
        }
        sp_consulta.setContent(vbox_consultas);
    }    

}
