package com.rafexanderson5.alAboutJPA.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_BOOK")
public class BookModel implements Serializable {
    private static final long serialVersionUID =1l;


    @Id// indica que o atributo é um id
    @GeneratedValue(strategy = GenerationType.AUTO)//esse id será gerado automáticamante
    private UUID id;
    @Column(nullable = false, unique = true)//definimos caracteristicas ao atributo
    // não permite campos vazios, devem ser únicos
    private String title;

    public BookModel() {
    }

    public BookModel(String title) {
        this.title = title;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
