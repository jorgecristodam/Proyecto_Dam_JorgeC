package org.example.programacionjorgecristobal.Model;
import lombok.*;
import javax.xml.bind.annotation.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class Producto {
    @XmlAttribute(name = "id")
    private String id;

    @XmlElement(name = "nombre")
    private String nombre;

    @XmlAttribute(name = "estado")
    private String estado;

    @XmlElement(name = "descripcion")
    private String descripcion;

    @XmlAttribute(name = "categoria")
    private String categoria;

    @XmlElement(name = "precio")
    private Double precio;

    @XmlElement(name = "cantidad")
    private Integer cantidad;

}
