package org.example.programacionjorgecristobal.controller;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.programacionjorgecristobal.Model.Producto;
import util.Gestor;
import util.XMLUtil;



public class AdminController {
    @FXML private TableView<Producto> tablaAdmin;
    @FXML private TextField txtId, txtNombre, txtPrecio, txtStock, txtCategoria, txtDescripcion;

    @FXML
    public void initialize() {
        TableColumn<Producto, String> colId = new TableColumn<>("ID");
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Producto, String> colNom = new TableColumn<>("Nombre");
        colNom.setCellValueFactory(new PropertyValueFactory<>("nombre"));

        TableColumn<Producto, Double> colPre = new TableColumn<>("Precio");
        colPre.setCellValueFactory(new PropertyValueFactory<>("precio"));

        TableColumn<Producto, Integer> colStock = new TableColumn<>("Stock");
        colStock.setCellValueFactory(new PropertyValueFactory<>("cantidad"));

        tablaAdmin.getColumns().setAll(colId,colNom, colPre, colStock);;

        refrescarTabla();
    }

    private void refrescarTabla() {
        if (Gestor.productos != null) {
            tablaAdmin.setItems(FXCollections.observableArrayList(Gestor.productos));
        }
    }

    @FXML
    private void anadirProducto() {
        try {
            Producto p = new Producto();
            p.setId(txtId.getText());
            p.setNombre(txtNombre.getText());
            p.setPrecio(Double.parseDouble(txtPrecio.getText()));
            p.setCantidad(Integer.parseInt(txtStock.getText()));
            p.setCategoria(txtCategoria.getText());

            p.setEstado("Activo");
            p.setDescripcion(txtDescripcion.getText());
            Gestor.productos.add(p);
            XMLUtil.guardarTodo(Gestor.usuarios, Gestor.productos);

            refrescarTabla();
            limpiarCampos();
        } catch (Exception e) {
            System.out.println("Error al añadir.");
        }
    }


    @FXML
    private void eliminarProducto() {
        Producto seleccionado = tablaAdmin.getSelectionModel().getSelectedItem();

        if (seleccionado != null) {
            Gestor.productos.remove(seleccionado);

            XMLUtil.guardarTodo(Gestor.usuarios, Gestor.productos);

            refrescarTabla();

            System.out.println("Producto eliminado: " + seleccionado.getNombre());
        } else {
            System.out.println("Por favor, selecciona un producto de la tabla para eliminarlo.");
        }
    }

    private void limpiarCampos() {
        txtId.clear();
        txtNombre.clear();
        txtPrecio.clear();
        txtStock.clear();
        txtCategoria.clear();
        txtDescripcion.clear();
    }

}