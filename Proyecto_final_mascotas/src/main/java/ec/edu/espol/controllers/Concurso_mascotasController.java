/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controllers;

import ec.edu.espol.proyecto_final_mascotas.App;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Paul
 */
public class Concurso_mascotasController implements Initializable {
    
    @FXML
    private MenuBar menuBar;
    @FXML
    private MenuItem mi_menu_principal;
    @FXML
    private MenuItem mi_cerrar_app;
    @FXML
    private MenuItem mi_crear_dueño;
    @FXML
    private MenuItem mi_consultar_dueños;
    @FXML
    private MenuItem mi_crear_mascota;
    @FXML
    private MenuItem mi_consultar_mascotas;
    @FXML
    private MenuItem mi_crear_concurso;
    @FXML
    private MenuItem mi_consultar_concursos;
    @FXML
    private MenuItem mi_crear_premio;
    @FXML
    private MenuItem mi_consultar_premios;
    @FXML
    private MenuItem mi_crear_criterio;
    @FXML
    private MenuItem mi_consultar_criterios;
    @FXML
    private MenuItem mi_crear_inscripción;
    @FXML
    private MenuItem mi_consultar_inscripciones;
    @FXML
    private MenuItem mi_crear_miembroJurado;
    @FXML
    private MenuItem mi_consultar_miembroJurados;
    @FXML
    private MenuItem mi_crear_evaluación;
    @FXML
    private MenuItem mi_consultar_evaluaciones;
    @FXML
    private Pane panePrincipal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        panePrincipal.getChildren().clear();
        Image img = new Image("img/menu.jpg");
        ImageView imgview = new ImageView(img);
        imgview.setFitHeight(panePrincipal.getHeight());
        imgview.setFitWidth(panePrincipal.getWidth());
        panePrincipal.getChildren().add(imgview);
    }    

    @FXML
    private void AccederMenu(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Concurso_mascotas.fxml"));
            Parent root = fxmlLoader.load();
            Concurso_mascotasController controller = fxmlLoader.<Concurso_mascotasController>getController();
            System.out.println(controller);

            App.scene.setRoot(root);
            
        } catch (IOException ex) {
            ex.printStackTrace();
        } 
    }  
    
    @FXML
    private void CerrarAplicación(ActionEvent event) {
        Stage stage = (Stage) menuBar.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void CrearDueño(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Creador_dueños.fxml"));
            Parent root = fxmlLoader.load();
            Creador_dueñosController controller = fxmlLoader.<Creador_dueñosController>getController();
            System.out.println(controller);

            App.scene.setRoot(root);
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }    
    }

    @FXML
    private void ConsultarDueños(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Consultar_dueños.fxml"));
            Parent root = fxmlLoader.load();
            Consultar_dueñosController controller = fxmlLoader.<Consultar_dueñosController>getController();
            System.out.println(controller);

            App.scene.setRoot(root);
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }   
    }

    @FXML
    private void CrearMascota(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Creador_mascotas.fxml"));
            Parent root = fxmlLoader.load();
            Creador_mascotasController controller = fxmlLoader.<Creador_mascotasController>getController();
            System.out.println(controller);

            App.scene.setRoot(root);
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }  
    }

    @FXML
    private void ConsultarMascotas(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Consultar_mascotas.fxml"));
            Parent root = fxmlLoader.load();
            Consultar_mascotasController controller = fxmlLoader.<Consultar_mascotasController>getController();
            System.out.println(controller);

            App.scene.setRoot(root);
            
        } catch (IOException ex) {
            ex.printStackTrace();
        } 
    }

    @FXML
    private void CrearConcurso(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Creador_concursos.fxml"));
            Parent root = fxmlLoader.load();
            Creador_concursosController controller = fxmlLoader.<Creador_concursosController>getController();
            System.out.println(controller);

            App.scene.setRoot(root);
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }  
    }

    @FXML
    private void ConsultarConcursos(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Consultar_concursos.fxml"));
            Parent root = fxmlLoader.load();
            Consultar_concursosController controller = fxmlLoader.<Consultar_concursosController>getController();
            System.out.println(controller);

            App.scene.setRoot(root);
            
        } catch (IOException ex) {
            ex.printStackTrace();
        } 
    }

    @FXML
    private void CrearPremio(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Creador_premios.fxml"));
            Parent root = fxmlLoader.load();
            Creador_premiosController controller = fxmlLoader.<Creador_premiosController>getController();
            System.out.println(controller);

            App.scene.setRoot(root);
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }  
    }

    @FXML
    private void ConsultarPremios(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Consultar_premios.fxml"));
            Parent root = fxmlLoader.load();
            Consultar_premiosController controller = fxmlLoader.<Consultar_premiosController>getController();
            System.out.println(controller);

            App.scene.setRoot(root);
            
        } catch (IOException ex) {
            ex.printStackTrace();
        } 
    }

    @FXML
    private void CrearCriterio(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Creador_criterios.fxml"));
            Parent root = fxmlLoader.load();
            Creador_criteriosController controller = fxmlLoader.<Creador_criteriosController>getController();
            System.out.println(controller);

            App.scene.setRoot(root);
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }  
    }

    @FXML
    private void ConsultarCriterios(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Consultar_criterios.fxml"));
            Parent root = fxmlLoader.load();
            Consultar_criteriosController controller = fxmlLoader.<Consultar_criteriosController>getController();
            System.out.println(controller);

            App.scene.setRoot(root);
            
        } catch (IOException ex) {
            ex.printStackTrace();
        } 
    }

    @FXML
    private void CrearInscripción(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Creador_inscripciones.fxml"));
            Parent root = fxmlLoader.load();
            Creador_inscripcionesController controller = fxmlLoader.<Creador_inscripcionesController>getController();
            System.out.println(controller);

            App.scene.setRoot(root);
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }  
    }

    @FXML
    private void ConsultarInscripciones(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Consultar_inscripciones.fxml"));
            Parent root = fxmlLoader.load();
            Consultar_inscripcionesController controller = fxmlLoader.<Consultar_inscripcionesController>getController();
            System.out.println(controller);

            App.scene.setRoot(root);
            
        } catch (IOException ex) {
            ex.printStackTrace();
        } 
    }

    @FXML
    private void CrearMiembroJurado(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Creador_jurados.fxml"));
            Parent root = fxmlLoader.load();
            Creador_juradosController controller = fxmlLoader.<Creador_juradosController>getController();
            System.out.println(controller);

            App.scene.setRoot(root);
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }  
    }

    @FXML
    private void ConsultarMiembroJurados(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Consultar_jurados.fxml"));
            Parent root = fxmlLoader.load();
            Consultar_juradosController controller = fxmlLoader.<Consultar_juradosController>getController();
            System.out.println(controller);

            App.scene.setRoot(root);
            
        } catch (IOException ex) {
            ex.printStackTrace();
        } 
    }

    @FXML
    private void CrearEvaluación(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Creador_evaluaciones.fxml"));
            Parent root = fxmlLoader.load();
            Creador_evaluacionesController controller = fxmlLoader.<Creador_evaluacionesController>getController();
            System.out.println(controller);

            App.scene.setRoot(root);
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }  
    }

    @FXML
    private void ConsultarEvaluaciones(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Consultar_evaluaciones.fxml"));
            Parent root = fxmlLoader.load();
            Consultar_evaluacionesController controller = fxmlLoader.<Consultar_evaluacionesController>getController();
            System.out.println(controller);

            App.scene.setRoot(root);
            
        } catch (IOException ex) {
            ex.printStackTrace();
        } 
    }
    
}
