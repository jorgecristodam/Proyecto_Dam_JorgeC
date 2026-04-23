package org.example.programacionjorgecristobal.Model;

import org.example.programacionjorgecristobal.util.XMLUtil;
import java.util.List;

import lombok.*;
@Getter
@Setter

public class GestionStock {

    private static List<Usuario> listaUsuarios;
    private static List<Producto> listaProductos;


    public static void cargarDatosDesdeXML() {
        listaUsuarios = XMLUtil.leerUsuarios();
        listaProductos = XMLUtil.leerProductos();
        System.out.println("Datos cargados: " + listaUsuarios.size() + " usuarios y " + listaProductos.size() + " productos.");
    }





    public static void guardarCambios() {

    }
}
