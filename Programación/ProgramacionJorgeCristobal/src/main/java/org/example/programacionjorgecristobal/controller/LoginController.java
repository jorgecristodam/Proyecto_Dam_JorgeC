package org.example.programacionjorgecristobal.controller;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.programacionjorgecristobal.Model.Usuario;
import util.DataHolder;

import java.io.IOException;

public class LoginController {
    @FXML
    private TextField txtUser;
    @FXML private TextField txtPass;


    @FXML
    private void hacerLogin() {
        String userIntroducido = txtUser.getText();
        String passIntroducida = txtPass.getText();


        Usuario usuarioEncontrado = null;
        for (Usuario u : DataHolder.usuarios) {
            if (u.getNombre().equals(userIntroducido) && u.getId().equals(passIntroducida)) {
                usuarioEncontrado = u;
                break;
            }
        }
        if (usuarioEncontrado != null) {
            DataHolder.usuarioLogueado = usuarioEncontrado;


            if (usuarioEncontrado.getRol().equalsIgnoreCase("admin")) {
                cambiarPantalla("/adminPanel.fxml");
            } else {
                cambiarPantalla("/UserPanel.fxml");
            }
        } else {
            System.out.println("Usuario no encontrado");
        }
    }


    private void cambiarPantalla(String fxml) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();
            Stage stage = (Stage) txtUser.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            System.err.println("Error: No se encuentra " + fxml);
            e.printStackTrace();
        }
    }
}