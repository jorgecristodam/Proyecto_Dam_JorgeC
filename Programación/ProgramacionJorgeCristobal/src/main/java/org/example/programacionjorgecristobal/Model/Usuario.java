package org.example.programacionjorgecristobal.Model;

import lombok.*;
import javax.xml.bind.annotation.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
