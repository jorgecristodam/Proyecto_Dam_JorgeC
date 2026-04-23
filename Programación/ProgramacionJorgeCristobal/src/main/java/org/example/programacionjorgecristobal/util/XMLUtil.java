package org.example.programacionjorgecristobal.util;

import org.example.programacionjorgecristobal.Model.Usuario;
import org.example.programacionjorgecristobal.Model.Producto;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XMLUtil {

    private static final String RUTA_XML = "src/main/resources/datos.xml";

    public static List<Usuario> leerUsuarios() {
        List<Usuario> lista = new ArrayList<>();
        try {
            File archivo = new File(RUTA_XML);
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(archivo);
            doc.getDocumentElement().normalize();


            NodeList nodos = doc.getElementsByTagName("usuario");
            for (int i = 0; i < nodos.getLength(); i++) {
                Element el = (Element) nodos.item(i);

                String id = el.getAttribute("id");
                String rol = el.getAttribute("rol");
                String activo = el.getAttribute("activo");
                String nombre = el.getElementsByTagName("nombre").item(0).getTextContent();
                String email = el.getElementsByTagName("email").item(0).getTextContent();
                lista.add(new Usuario(id, rol, activo, nombre, email));


            }
        } catch (Exception e) {
            System.err.println("Error al cargar usuarios: " + e.getMessage());
        }
        return lista;
    }

        public static List<Producto> leerProductos () {
            List<Producto> lista = new ArrayList<>();
            try {
                File archivo = new File(RUTA_XML);
                Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(archivo);
                doc.getDocumentElement().normalize();

                NodeList nodos = doc.getElementsByTagName("producto");

                for (int i = 0; i < nodos.getLength(); i++) {
                    Element el = (Element) nodos.item(i);

                    String id = el.getAttribute("id");
                    String cat = el.getAttribute("categoria");
                    String est = el.getAttribute("estado");
                    String nom = el.getElementsByTagName("nombre").item(0).getTextContent();
                    String des = el.getElementsByTagName("descripcion").item(0).getTextContent();
                    double pre = Double.parseDouble(el.getElementsByTagName("precio").item(0).getTextContent());
                    int cant = Integer.parseInt(el.getElementsByTagName("cantidad").item(0).getTextContent());

                    lista.add(new Producto(id, cat, est, nom, des, pre, cant));
                }
            } catch (Exception e) {
                System.err.println("Error al cargar productos: " + e.getMessage());
            }
            return lista;
        }
    }
