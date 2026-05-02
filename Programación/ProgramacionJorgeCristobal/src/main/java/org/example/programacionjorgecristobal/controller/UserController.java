package org.example.programacionjorgecristobal.controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.programacionjorgecristobal.Model.Producto;
import util.Gestor;
import util.XMLUtil;

public class UserController {
    @FXML private TableView<Producto> tablaProductos;

    @FXML
    public void initialize() {
        TableColumn<Producto, String> colNom = new TableColumn<>("Producto");
        colNom.setCellValueFactory(new PropertyValueFactory<>("nombre"));

        TableColumn<Producto, Integer> colStock = new TableColumn<>("Stock");
        colStock.setCellValueFactory(new PropertyValueFactory<>("cantidad"));

        tablaProductos.getColumns().addAll(colNom, colStock);

        tablaProductos.setItems(FXCollections.observableArrayList(Gestor.productos));
    }

    @FXML
    private void comprarProducto() {
        Producto seleccionado = tablaProductos.getSelectionModel().getSelectedItem();

        if (seleccionado != null && seleccionado.getCantidad() > 0) {
            seleccionado.setCantidad(seleccionado.getCantidad() - 1);

            tablaProductos.refresh();
            XMLUtil.guardarTodo(Gestor.usuarios, Gestor.productos);
        }
    }
}
