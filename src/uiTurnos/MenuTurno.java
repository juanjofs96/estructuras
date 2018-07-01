/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uiTurnos;

import Tdas.DoublyLinkedList;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.media.Player;
import javax.swing.JFrame;
import javax.swing.JPanel;
import ui.MenuPrincipal;
import utils.Constants;

/**
 *
 *
 */
public class MenuTurno extends JFrame implements KeyListener{
    
    private final Stage menuCompradorStage;
    private Stage secundaryStage;
    
    private StackPane root;
    private VBox contenedor;
    
    private JPanel panel;
    private Player mPlayer;
    private Component video;
    private DoublyLinkedList<String> lista;
    
    private Button bAtras;
    
    public MenuTurno(Stage stage){
        this.menuCompradorStage = stage;
        contSetUp();
        backgroundSetup();
        setUpButtons();
    }
    
    private void initElements(){
        root = new StackPane();
        root.setId("rootPrincipal");
        contenedor = new VBox();
        bAtras = new Button("Generar Turno");
    }
    
    private void contSetUp(){
        initElements();
        root.getChildren().add(contenedor);
        contenedor.getChildren().addAll( bAtras);
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
        setActionRegresar();
        
    }
   
    
    private void setActionRegresar(){
        bAtras.setOnMouseClicked((MouseEvent e) -> {
            secundaryStage = new Stage();
            Scene scene = new Scene(new MenuPrincipal(secundaryStage).getRoot(), Constants.MENU_DEFAULT_WIDTH, Constants.MENU_DEFAULT_LENGTH);
            secundaryStage.setTitle("Generacion de turnos");
            secundaryStage.setResizable(false);
            secundaryStage.setScene(scene);
            this.menuCompradorStage.close();
            secundaryStage.show();
        });
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
