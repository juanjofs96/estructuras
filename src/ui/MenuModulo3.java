/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import Tdas.Provincia;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author JuanJose FS
 */
public class MenuModulo3 {
    private Stage menuPrincipalStage;
    public BorderPane root;
    public VBox contenedor, vbox;
    public HBox hbox;
    public Label label;
    public Button obtenerocho;

    public MenuModulo3(Stage stage) throws IOException {
        this.menuPrincipalStage = stage;
        stage.setWidth(750);
        stage.setHeight(750);
        setUp();
        generarPilasProvincias();
    }
    

    public void setUp() {
        root = new BorderPane();
        contenedor = new VBox();
        contenedor.setSpacing(20);
//        obtenerocho= new Button();
//        obtenerocho.setOnAction(e->{
//            try {
//                generarPilasProvincias();
//            } catch (IOException ex) {
//                Logger.getLogger(MenuModulo3.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        });
//        lbl_titulo = new Label("BIENVENIDOS AL PROGRAMA DE MASCOTAS");
//        registrar = new Button("¿Eres nuevo? ¡Únete!");
//        ingresar = new Button("Iniciar sesión");
//        imagePrincipal = new ImageView("/Images/pantallaPrincipal.png");
//        
//        imagePrincipal.setFitHeight(500);
//        imagePrincipal.setFitWidth(500);
//        root.getChildren().add(imagePrincipal);
//        
//        lbl_titulo.setTextFill(Color.BLACK);
//        contenedor.setSpacing(10);
//        contenedor.getChildren().addAll(lbl_titulo, ingresar, registrar);
//        contenedor.setAlignment(Pos.CENTER);
//        root.setCenter(contenedor);
//        
//        registrar.setOnAction(e->manejaRegistrar());
//        ingresar.setOnAction(e->manejaIngresar());
        
    }

    public void leerArchivos(String ruta, Map<String, Integer> mapaentradas, Map<String, Integer> mapasalidas) throws FileNotFoundException, IOException {
        String cadena;
        FileReader file = new FileReader(ruta);
        BufferedReader buffer = new BufferedReader(file);

        while ((cadena = buffer.readLine()) != null) {     //recorre cada linea del archivo de migraciones
            String[] arr = cadena.split(";");
            if (arr[0].equals("Entrada")) {
                if (mapaentradas.get(arr[3]) == null) {
                    mapaentradas.put(arr[3], 0);
                }
                mapaentradas.put(arr[3], mapaentradas.get(arr[3]) + 1);
            } else if (arr[0].equals("Salida")) {
                if (mapasalidas.get(arr[3]) == null) {
                    mapasalidas.put(arr[3], 0);
                }
                mapasalidas.put(arr[3], mapasalidas.get(arr[3]) + 1);
            }
        }
        buffer.close();
    }

    public void generarPilasProvincias() throws IOException {
        Map<String, Integer> mapaentradas = new HashMap<>();  // crea mapa de entradas, clave provincia y valor total de entradas
        Map<String, Integer> mapasalidas = new HashMap<>();    // crea mapa de salidas, clave provincia y valor total de salidas
        leerArchivos("src/recursos/migraciones.csv", mapaentradas, mapasalidas);

//        
//        FileReader file2 = new FileReader("src/recursos/migraciones.csv");
//        BufferedReader buffer2 = new BufferedReader(file2);
//        while((cadena = buffer2.readLine())!=null) {     //recorre cada linea del archivo de migraciones
//            String[] arr=cadena.split(";");
//            if(arr[0].equals("Entrada")){
//                if(mapaentradas.get(arr[3])==null){
//                mapaentradas.put(arr[3],0);
//                }
//                mapaentradas.put(arr[3], mapaentradas.get(arr[3])+1);
//            }else if(arr[0].equals("Salida")){
//                if(mapasalidas.get(arr[3])==null){
//                mapasalidas.put(arr[3],0);
//                }
//                mapasalidas.put(arr[3], mapasalidas.get(arr[3])+1);
//            }
//        }
//        buffer2.close();
//        
//        FileReader file3 = new FileReader("src/recursos/migraciones.csv");
//        BufferedReader buffer3 = new BufferedReader(file3);
//        while((cadena = buffer3.readLine())!=null) {     //recorre cada linea del archivo de migraciones
//            String[] arr=cadena.split(";");
//            if(arr[0].equals("Entrada")){
//                if(mapaentradas.get(arr[3])==null){
//                mapaentradas.put(arr[3],0);
//                }
//                mapaentradas.put(arr[3], mapaentradas.get(arr[3])+1);
//            }else if(arr[0].equals("Salida")){
//                if(mapasalidas.get(arr[3])==null){
//                mapasalidas.put(arr[3],0);
//                }
//                mapasalidas.put(arr[3], mapasalidas.get(arr[3])+1);
//            }
//        }
//        buffer3.close();
//        
//        FileReader file4 = new FileReader("src/recursos/migraciones.csv");
//        BufferedReader buffer4 = new BufferedReader(file4);
//        while((cadena = buffer4.readLine())!=null) {     //recorre cada linea del archivo de migraciones
//            String[] arr=cadena.split(";");
//            if(arr[0].equals("Entrada")){
//                if(mapaentradas.get(arr[3])==null){
//                mapaentradas.put(arr[3],0);
//                }
//                mapaentradas.put(arr[3], mapaentradas.get(arr[3])+1);
//            }else if(arr[0].equals("Salida")){
//                if(mapasalidas.get(arr[3])==null){
//                mapasalidas.put(arr[3],0);
//                }
//                mapasalidas.put(arr[3], mapasalidas.get(arr[3])+1);
//            }
//        }
//        buffer4.close();
//        
//        FileReader file5 = new FileReader("src/recursos/migraciones.csv");
//        BufferedReader buffer5 = new BufferedReader(file5);
//        while((cadena = buffer5.readLine())!=null) {     //recorre cada linea del archivo de migraciones
//            String[] arr=cadena.split(";");
//            if(arr[0].equals("Entrada")){
//                if(mapaentradas.get(arr[3])==null){
//                mapaentradas.put(arr[3],0);
//                }
//                mapaentradas.put(arr[3], mapaentradas.get(arr[3])+1);
//            }else if(arr[0].equals("Salida")){
//                if(mapasalidas.get(arr[3])==null){
//                mapasalidas.put(arr[3],0);
//                }
//                mapasalidas.put(arr[3], mapasalidas.get(arr[3])+1);
//            }
//        }
//        buffer5.close();
//        
        List<Provincia> in = new ArrayList<>();         // crea lista de objetos provincia de entrada (nombre, tipo, total entradas)
        for (Map.Entry<String, Integer> a : mapaentradas.entrySet()) {
            Provincia p = new Provincia(a.getKey(), "Entrada", a.getValue());
            in.add(p);
        }
        Collections.sort(in, (Provincia p1, Provincia p2) -> p1.getCantidad() - p2.getCantidad());

        List<Provincia> out = new ArrayList<>();    // crea lista de objetos provincia de salida (nombre, tipo, total salidas)
        for (Map.Entry<String, Integer> b : mapasalidas.entrySet()) {
            Provincia p = new Provincia(b.getKey(), "Salida", b.getValue());
            out.add(p);
        }
        Collections.sort(out, (Provincia p1, Provincia p2) -> p1.getCantidad() - p2.getCantidad());

        Map<String, List<Provincia>> map = new HashMap<>();
        List<Provincia> lincosta = new ArrayList<>();        //crea lista de provincias de costa de entrada
        List<Provincia> linsierra = new ArrayList<>();      //sierra
        List<Provincia> linoriente = new ArrayList<>();     //oriente
        List<Provincia> lingal = new ArrayList<>();         //insular
        for (Provincia p : in) {
            String n = p.getNombre();
            if (n.equals("Guayas") || n.equals("Esmeraldas") || n.equals("Los Ríos") || n.equals("Manabí") || n.equals("El Oro") || n.equals("Santa Elena")) {
                if (map.get("Costa") == null) {
                    map.put("Costa", lincosta);
                }
                lincosta.add(p);
                map.put("Costa", lincosta);
            } else if (n.equals("Carchi") || n.equals("Imbabura") || n.equals("Santo Domingo") || n.equals("Pichincha") || n.equals("Cotopaxi") || n.equals("Chimborazo")
                    || n.equals("Tungurahua") || n.equals("Bolívar") || n.equals("Cañar") || n.equals("Azuay") || n.equals("Loja")) {
                if (map.get("Sierra") == null) {
                    map.put("Sierra", linsierra);
                }
                linsierra.add(p);
                map.put("Sierra", linsierra);
            } else if (n.equals("Sucumbíos") || n.equals("Napo") || n.equals("Orellana") || n.equals("Pastaza") || n.equals("Morona Santiago") || n.equals("Zamora Chinchipe")) {
                if (map.get("Oriente") == null) {
                    map.put("Oriente", linoriente);
                }
                linoriente.add(p);
                map.put("Oriente", linoriente);
            } else if (n.equals("Galápagos")) {
                if (map.get("Insular") == null) {
                    map.put("Insular", lingal);
                }
                lingal.add(p);
                map.put("Insular", lingal);
            }
        }
        Map<String, List<Provincia>> mapa = new HashMap<>();
        List<Provincia> loutcosta = new ArrayList<>();        //crea lista de provincias de costa de salida
        List<Provincia> loutsierra = new ArrayList<>();       //sierra 
        List<Provincia> loutoriente = new ArrayList<>();      //oriente
        List<Provincia> loutgal = new ArrayList<>();           //insular
        for (Provincia p : out) {
            String n = p.getNombre();
            if (n.equals("Guayas") || n.equals("Esmeraldas") || n.equals("Los Ríos") || n.equals("Manabí") || n.equals("El Oro") || n.equals("Santa Elena")) {
                if (mapa.get("Costa") == null) {
                    mapa.put("Costa", loutcosta);
                }
                loutcosta.add(p);
                mapa.put("Costa", loutcosta);
            } else if (n.equals("Carchi") || n.equals("Imbabura") || n.equals("Santo Domingo") || n.equals("Pichincha") || n.equals("Cotopaxi") || n.equals("Chimborazo")
                    || n.equals("Tungurahua") || n.equals("Bolívar") || n.equals("Cañar") || n.equals("Azuay") || n.equals("Loja")) {
                if (mapa.get("Sierra") == null) {
                    mapa.put("Sierra", loutsierra);
                }
                loutsierra.add(p);
                mapa.put("Sierra", loutsierra);
            } else if (n.equals("Sucumbíos") || n.equals("Napo") || n.equals("Orellana") || n.equals("Pastaza") || n.equals("Morona Santiago") || n.equals("Zamora Chinchipe")) {
                if (mapa.get("Oriente") == null) {
                    mapa.put("Oriente", loutoriente);
                }
                loutoriente.add(p);
                mapa.put("Oriente", loutoriente);
            } else if (n.equals("Galápagos")) {
                if (mapa.get("Insular") == null) {
                    mapa.put("Insular", loutgal);
                }
                loutgal.add(p);
                mapa.put("Insular", loutgal);
            }
        }
        
        hbox=new HBox();
        hbox.setSpacing(25);
        for (Map.Entry<String, List<Provincia>> m : map.entrySet()) {       //recorriendo claves de mapa de entrada
            vbox = new VBox();
//            vbox.setMaxSize(4000, 2000);
            Deque<Provincia> p = new LinkedList<>();
            for (Provincia pr : m.getValue()) {
                p.push(pr);

            }
            label = new Label();
            label.setText(p.getLast().getTipo()+"/"+m.getKey());
            vbox.getChildren().add(label);
            while (!p.isEmpty()) {                        //recorriendo cada pila de entrada
                label = new Label();
                label.setText(p.pop().toString());
                vbox.getChildren().add(label);
            }
            hbox.getChildren().add(vbox);
        }
        contenedor.getChildren().add(hbox);
        
        hbox=new HBox();
        hbox.setSpacing(25);
        for (Map.Entry<String, List<Provincia>> m : mapa.entrySet()) {          //recorriendo claves de mapa de salida
            vbox = new VBox();
            Deque<Provincia> p = new LinkedList<>();
            for (Provincia pr : m.getValue()) {
                p.push(pr);
            }
            label = new Label();
            label.setText(p.getLast().getTipo()+"/"+m.getKey());
            vbox.getChildren().add(label);
            while (!p.isEmpty()) {                        //recorriendo cada pila de salida
                label = new Label();
                label.setText(p.pop().toString());
                vbox.getChildren().add(label);
            }
            hbox.getChildren().add(vbox);
        }
        contenedor.getChildren().add(hbox);

        Deque<Provincia> pin = new LinkedList<>();      //creando pila provincias de entrada
        for (Provincia p : in) {
            pin.push(p);
        }

        Deque<Provincia> pout = new LinkedList<>();     //creando pila provincias de salida
        for (Provincia p : out) {
            pout.push(p);
        }
        
        
        hbox=new HBox();
        hbox.setSpacing(50);
        vbox = new VBox();
        label = new Label();
            label.setText("Migraciones de Entrada");
            vbox.getChildren().add(label);
        while (!pin.isEmpty()) {                      // recorriendo pila de entradas
            label = new Label();
            label.setText(pin.pop().toString());
            vbox.getChildren().add(label);
        }
        hbox.getChildren().add(vbox);
        
        vbox = new VBox();
        label = new Label();
            label.setText("Migraciones de Salida");
            vbox.getChildren().add(label);
        while (!pout.isEmpty()) {                     // recorriendo pila de salidas
            label = new Label();
            label.setText(pout.pop().toString());
            vbox.getChildren().add(label);
        }
        hbox.getChildren().add(vbox);

        contenedor.getChildren().add(hbox);

        root.setCenter(contenedor);
    }

    public BorderPane getRoot() {
        return root;
    }

}
