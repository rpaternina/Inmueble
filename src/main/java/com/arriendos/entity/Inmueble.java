package com.arriendos.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "inmueble")
@Data
public class Inmueble {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String nombre;

    String titulo;
    Long precio;
}
