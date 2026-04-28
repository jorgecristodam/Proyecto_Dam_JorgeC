package org.example.programacionjorgecristobal.Model;


import java.util.ArrayList;
import java.util.List;
import util.XMLUtil;
import lombok.*;
@Getter
@Setter

public class GestionStock {

    private static List<Usuario> listaUsuarios;
    private static List<Producto> listaProductos;


    public static void cargarDatosDesdeXML() {
        try {
            listaUsuarios = XMLUtil.leerUsuarios();
            listaProductos = XMLUtil.leerProductos();

            if (listaUsuarios == null) listaUsuarios = new ArrayList<>();
            if (listaProductos == null) listaProductos = new ArrayList<>();

            System.out.println("Datos cargados: " + listaUsuarios.size() + " usuarios y " + listaProductos.size() + " productos.");
        } catch (Exception e) {
            System.err.println("Error al cargar datos: " + e.getMessage());
        }
    }





    public static void guardarCambios() {
        try {
            XMLUtil.guardarTodo(listaUsuarios, listaProductos);
            System.out.println("Cambios guardados correctamente en el XML.");
        } catch (Exception e) {
            System.err.println("Error al guardar cambios: " + e.getMessage());
        }
    }
}
