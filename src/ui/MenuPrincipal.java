/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import uiTurnos.MenuTurno;
import utils.Constants;


public class MenuPrincipal {

    private final Stage menuPrincipalStage;
    private Stage secundaryStage;
    
    private StackPane root;
    private VBox contenedor;
    
    private Button bTercera;
    private Button bEspecial;
    private Button bNormal;
    private Button bSalir;
    
    public MenuPrincipal(Stage stage){
        this.menuPrincipalStage = stage;
        contSetUp();
        backgroundSetup();
        setUpButtons();
    }
    
    private void initElements(){
        root = new StackPane();
        root.setId("rootPrincipal");
        contenedor = new VBox();
        bTercera = new Button("Tercera Edad");
        bEspecial = new Button("Capacidad Especial");
        bNormal = new Button("Normal");
        bSalir = new Button("Salir");
    }
    
    private void contSetUp(){
        initElements();
        root.getChildren().add(contenedor);
        contenedor.getChildren().addAll(bTercera, bEspecial, bNormal, bSalir);
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
    
    private void setUpButtons(){
        setActionTercera();
        setActionEspecial();
        setActionNormal();
        setActionSalir();
    }
    
    private void setActionTercera(){
        bTercera.setOnMouseClicked((MouseEvent e) -> {
            secundaryStage = new Stage();
            Scene scene = new Scene(new MenuTurno(secundaryStage).getRoot(), Constants.MENU_DEFAULT_WIDTH, Constants.MENU_DEFAULT_LENGTH);
            secundaryStage.setTitle("Espera de turno");
            secundaryStage.setResizable(false);
            secundaryStage.setScene(scene);
            this.menuPrincipalStage.close();
            secundaryStage.show();
        });
    }
    
    private void setActionEspecial(){
        bEspecial.setOnMouseClicked((MouseEvent e) -> {
            secundaryStage = new Stage();
            Scene scene = new Scene(new MenuTurno(secundaryStage).getRoot(), Constants.MENU_DEFAULT_WIDTH, Constants.MENU_DEFAULT_LENGTH);
            secundaryStage.setTitle("Espera de turno");
            secundaryStage.setResizable(false);
            secundaryStage.setScene(scene);
            this.menuPrincipalStage.close();
            secundaryStage.show();
        });
    }
      private void setActionNormal(){
        bNormal.setOnMouseClicked((MouseEvent e) -> {
            secundaryStage = new Stage();
            Scene scene = new Scene(new MenuTurno(secundaryStage).getRoot(), Constants.MENU_DEFAULT_WIDTH, Constants.MENU_DEFAULT_LENGTH);
            secundaryStage.setTitle("Espera de turno");
            secundaryStage.setResizable(false);
            secundaryStage.setScene(scene);
            this.menuPrincipalStage.close();
            secundaryStage.show();
        });
    }
    
    private void setActionSalir(){
        bSalir.setOnMouseClicked((MouseEvent e) -> {
            this.menuPrincipalStage.close();
        });
    
    }
    
}
