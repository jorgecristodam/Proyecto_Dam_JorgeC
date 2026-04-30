package org.example.programacionjorgecristobal;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import util.DataHolder;
import util.XMLUtil;


import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {


        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/login.fxml"));


        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("TechStock - Inicio de Sesión");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }


    public static void main(String[] args) {
        System.out.println("Iniciando carga de datos...");


        DataHolder.usuarios = XMLUtil.leerUsuarios();
        DataHolder.productos = XMLUtil.leerProductos();


        System.out.println("Datos listos. Cargando interfaz...");


        launch();
    }


}