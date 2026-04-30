package org.example.programacionjorgecristobal.Model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "usuario")
@XmlAccessorType(XmlAccessType.FIELD)
public class Usuario {
    @XmlAttribute(name = "id")
    private String id;

    @XmlAttribute(name = "rol")
    private String rol;

    @XmlAttribute(name = "activo")
    private String activo;

    @XmlElement(name = "nombre")
    private String nombre;

    @XmlElement(name = "email")
    private String email;
}
