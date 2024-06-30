package com.rafexanderson5.alAboutJPA.models;

import jakarta.persistence.*;
import org.hibernate.tool.schema.spi.SchemaTruncator;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name ="TB_PUBLISHER")
public class PublisherModel implements Serializable {
    private static final long serialVersionUID =1l;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, unique = true)
    private String name;

    public PublisherModel() {
    }

    public PublisherModel(String name) {
        this.name = name;
    }


    public UUID getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
