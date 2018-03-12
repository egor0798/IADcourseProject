package civ5.civa.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="buildings")
public class Building {
    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price_production")
    private int priceProduction;

    @Column(name = "price_resource")
    private int priceResource;

    @Column(name = "requirements")
    private String requirements;

    @Column(name = "properties")
    private String properties;


    @OneToOne(fetch = FetchType.LAZY, mappedBy = "uniqueBuilding")
    private Nation nation;

    @ManyToMany(mappedBy = "buildings")
    private List<Technology> technologies = new ArrayList<>();



    public Building(int id, String name, int priceProduction, int priceResource, String requirements, String properties){
        this.id=id;
        this.name=name;
        this.priceProduction = priceProduction;
        this.priceResource = priceResource;
        this.requirements=requirements;
        this.properties=properties;
    }

    public Building(int id, String name, int priceProduction, String requirements, String properties){
        this.id=id;
        this.name=name;
        this.priceProduction = priceProduction;
        this.requirements=requirements;
        this.properties=properties;
    }
}
