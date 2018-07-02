/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import uiTurnos.MenuTurno;
import utils.Constants;

/**
 *
 * @author JuanJose FS
 */
public class MenuPrincipal {

    private final Stage menuPrincipalStage;
    private Stage secundaryStage;

    private StackPane root;
    private VBox contenedor;

    private Button bModulo1;
    private Button bModulo2;
    private Button bModulo3;
    private Button bSalir;

    public MenuPrincipal(Stage stage) {
        this.menuPrincipalStage = stage;
        contSetUp();
        backgroundSetup();
        setUpButtons();
    }

    private void initElements() {
        root = new StackPane();
        root.setId("rootPrincipal");
        contenedor = new VBox();
        bModulo1 = new Button("Modulo de sistema de turnos");
        bModulo2 = new Button("Modulo de registro migratorio");
        bModulo3 = new Button("Modulo de procesamiento de migraciones");
        bSalir = new Button("Salir");
    }

    private void contSetUp() {
        initElements();
        root.getChildren().add(contenedor);
        contenedor.getChildren().addAll(bModulo1, bModulo2, bModulo3, bSalir);
        StackPane.setAlignment(contenedor, Pos.CENTER);
        contenedor.setSpacing(30);
        contenedor.setPadding(new Insets(200, 30, 200, 250));
    }

    private void backgroundSetup() {
        root.getStylesheets().add("style/Style.css");
    }

    public StackPane getRoot() {
        return root;
    }

    private void setUpButtons() {
        bModulo1.setOnAction(e -> primerModulo());
        bModulo2.setOnAction(e->segundoModulo());
        bModulo3.setOnAction(e->{
            try {
                tercerModulo();
            } catch (IOException ex) {
                Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        setActionSalir();
    }

    private void primerModulo() {
        secundaryStage = new Stage();
        Scene scene = new Scene(new MenuModulo1(secundaryStage).getRoot(), Constants.MENU_DEFAULT_WIDTH, Constants.MENU_DEFAULT_LENGTH);
        secundaryStage.setTitle("Generacion de turnos");
        secundaryStage.setResizable(false);
        secundaryStage.setScene(scene);
        this.menuPrincipalStage.close();
        secundaryStage.show();
    }

    private void segundoModulo() {
        
    }
    private void tercerModulo() throws IOException {
        secundaryStage = new Stage();
        Scene scene = new Scene(new MenuModulo3(secundaryStage).getRoot(), Constants.MENU_DEFAULT_WIDTH, Constants.MENU_DEFAULT_LENGTH);
        secundaryStage.setTitle("Procesamiento de migraciones");
        secundaryStage.setScene(scene);
        this.menuPrincipalStage.close();
        secundaryStage.show();
    }
    
//    private void setActionTercera() {
//        bTercera.setOnMouseClicked((MouseEvent e) -> {
//            secundaryStage = new Stage();
//            Scene scene = new Scene(new MenuTurno(secundaryStage).getRoot(), Constants.MENU_DEFAULT_WIDTH, Constants.MENU_DEFAULT_LENGTH);
//            secundaryStage.setTitle("Espera de turno");
//            secundaryStage.setResizable(false);
//            secundaryStage.setScene(scene);
//            this.menuPrincipalStage.close();
//            secundaryStage.show();
//        });
//    }

    private void setActionSalir() {
        bSalir.setOnMouseClicked((MouseEvent e) -> {
            this.menuPrincipalStage.close();
        });

    }
}
