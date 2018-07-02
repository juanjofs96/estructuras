/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.MenuModulo1;
import ui.MenuPrincipal;
import utils.Constants;

/**
 *
 * @author rxsh96
 */
public class Main extends Application {
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        MenuPrincipal menu = new MenuPrincipal(primaryStage);
        Scene scene = new Scene(menu.getRoot(), Constants.MENU_DEFAULT_WIDTH, Constants.MENU_DEFAULT_LENGTH);
        primaryStage.setTitle("Generacion de turnos");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    
    
}

