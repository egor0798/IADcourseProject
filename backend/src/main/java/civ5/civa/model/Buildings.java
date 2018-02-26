package civ5.civa.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="buildings")
public class Buildings {
    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price_production")
    private int price_production;

    @Column(name = "price_resource")
    private int price_resource;

    @Column(name = "requirements")
    private String requirements;

    @Column(name = "properties")
    private String properties;

    @OneToMany
    @JoinColumn(name="unique_building", referencedColumnName = "id")
    private List<Nations> nationsList = new ArrayList<>();

    @ManyToMany(mappedBy = "buildings")
    private List<Technologies> technologies = new ArrayList<>();



    public Buildings(int id, String name, int price_production, int price_resource, String requirements, String properties){
        this.id=id;
        this.name=name;
        this.price_production=price_production;
        this.price_resource=price_resource;
        this.requirements=requirements;
        this.properties=properties;
    }

    public Buildings(int id, String name, int price_production, String requirements, String properties){
        this.id=id;
        this.name=name;
        this.price_production=price_production;
        this.requirements=requirements;
        this.properties=properties;
    }
}
