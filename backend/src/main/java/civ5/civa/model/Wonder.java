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
@Table(name="wonders")
public class Wonder {
    @Id
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "price_production")
    private int priceProduction;
    @Column(name = "culture_pts")
    private int culturePts;
    @Column(name = "properties")
    private String properties;

    @ManyToMany(mappedBy = "wonderList")
    private List<Technology> techList = new ArrayList<>();

    public Wonder(int id, String name, int pr_pr, int cul_pts, String prop){
        this.id=id;
        this.culturePts = cul_pts;
        this.name = name;
        this.priceProduction = pr_pr;
        this.properties = prop;
    }
}
