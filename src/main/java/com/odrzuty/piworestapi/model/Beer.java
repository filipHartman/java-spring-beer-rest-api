package com.odrzuty.piworestapi.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "beers")
@Setter
@Getter
public class Beer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "brewery_id")
    private Brewery brewery;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "cat_id")
    private Category category;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "style_id")
    private Style style;

    @Size(max = 255)
    private String name;

    private float abv;

    private float ibu;

    private float srm;

    private int upc;

    private String descript;

    @Column(nullable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean removed = false;


    public Beer() {
    }

}
