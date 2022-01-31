/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controllers;

import ec.edu.espol.model.Contest;
import ec.edu.espol.model.Inscription;
import ec.edu.espol.model.Pet;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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
public class Creador_inscripcionesController extends Concurso_mascotasController implements Initializable {

    @FXML
    private TextField tf_id;
    @FXML
    private TextField tf_nombre_mascota;
    @FXML
    private TextField tf_id_concurso;
    @FXML
    private TextField tf_precio;
    @FXML
    private TextField tf_fecha;    
    @FXML
    private Button bt_crear_inscripción;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void CrearNuevaInscripción(ActionEvent event) {
        if (!(tf_id.getText().equals("")) && !(tf_nombre_mascota.getText().equals("")) && !(tf_id_concurso.getText().equals("")) && !(tf_precio.getText().equals("")) && !(tf_fecha.getText().equals(""))) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate localDate = LocalDate.parse(tf_fecha.getText(), formatter); 
                Inscription inscription = new Inscription(tf_id.getText(), Pet.getPetByName(tf_nombre_mascota.getText()), Contest.getContestByID(tf_id_concurso.getText()), Double.parseDouble(tf_precio.getText()), localDate);                
                inscription.saveToFile("inscripciones.txt");
                tf_id.setText("");
                tf_nombre_mascota.setText("");
                tf_id_concurso.setText("");
                tf_precio.setText("");
                tf_fecha.setText("");
                Alert a = new Alert(Alert.AlertType.INFORMATION, "INSCRIPCIÓN CREADA CON ÉXITO");
                a.show();
            }
            catch(NullPointerException npe) {
                Alert a = new Alert(Alert.AlertType.ERROR, "SE REFERENCIA A INFORMACIÓN INEXISTENTE");
                a.show();                      
            } 
            catch(NumberFormatException nfe) {
                Alert a = new Alert(Alert.AlertType.ERROR, "EL PRECIO NO ESTÁ EN EL FORMATO CORRECTO");
                a.show();                      
            } 
            catch(DateTimeParseException dtps) {
                Alert a = new Alert(Alert.AlertType.ERROR, "LA FECHA NO ESTÁ EN EL FORMATO CORRECTO");
                a.show();                      
            } 
        }
        else {
            Alert a = new Alert(Alert.AlertType.ERROR, "HACE FALTA INFORMACIÓN");
            a.show();            
        }        
    }


}
