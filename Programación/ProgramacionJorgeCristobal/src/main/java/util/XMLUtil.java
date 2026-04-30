package util;

import org.example.programacionjorgecristobal.Model.Usuario;
import org.example.programacionjorgecristobal.Model.Producto;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
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
                Usuario u = new Usuario();
                u.setId(id);
                u.setRol(rol);
                u.setActivo(activo);
                u.setNombre(nombre);
                u.setEmail(email);
                lista.add(u);


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
    public static void guardarTodo(List<Usuario> usuarios, List<Producto> productos) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            Document doc = dbf.newDocumentBuilder().newDocument();


            Element raiz = doc.createElement("gestionStock");
            doc.appendChild(raiz);


            Element wrapU = doc.createElement("usuarios");
            raiz.appendChild(wrapU);
            for (Usuario u : usuarios) {
                Element elU = doc.createElement("usuario");
                elU.setAttribute("id", u.getId());
                elU.setAttribute("rol", u.getRol());
                elU.setAttribute("activo", u.getActivo());

                Element n = doc.createElement("nombre"); n.setTextContent(u.getNombre());
                Element e = doc.createElement("email"); e.setTextContent(u.getEmail());
                elU.appendChild(n); elU.appendChild(e);
                wrapU.appendChild(elU);
            }

            Element wrapP = doc.createElement("catalogo");
            raiz.appendChild(wrapP);
            for (Producto p : productos) {
                Element elP = doc.createElement("producto");
                elP.setAttribute("id", p.getId());
                elP.setAttribute("categoria", p.getCategoria());
                elP.setAttribute("estado", p.getEstado());

                Element n = doc.createElement("nombre"); n.setTextContent(p.getNombre());
                Element d = doc.createElement("descripcion"); d.setTextContent(p.getDescripcion());
                Element pr = doc.createElement("precio"); pr.setTextContent(String.valueOf(p.getPrecio()));
                Element c = doc.createElement("cantidad"); c.setTextContent(String.valueOf(p.getCantidad()));

                elP.appendChild(n); elP.appendChild(d); elP.appendChild(pr); elP.appendChild(c);
                wrapP.appendChild(elP);
            }

            Transformer tf = TransformerFactory.newInstance().newTransformer();
            tf.setOutputProperty(OutputKeys.INDENT, "yes");
            tf.transform(new DOMSource(doc), new StreamResult(new File(RUTA_XML)));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
