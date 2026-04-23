package org.example.programacionjorgecristobal.Model;
import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Producto {
    private String id;
    private String name;
    private int stock;
    private double price;
}
