package org.example.programacionjorgecristobal.Model;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@XmlRootElement(name = "producto")
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
