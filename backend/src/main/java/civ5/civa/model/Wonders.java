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
@Table(name="wonders")
public class Wonders {
    @Id
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "price_production")
    private int price_production;
    @Column(name = "culture_pts")
    private int culture_pts;
    @Column(name = "properties")
    private String properties;

    @ManyToMany(mappedBy = "wondersList")
    private List<Technologies> techList = new ArrayList<>();

    public Wonders(int id, String name, int pr_pr, int cul_pts, String prop){
        this.id=id;
        this.culture_pts = cul_pts;
        this.name = name;
        this.price_production = pr_pr;
        this.properties = prop;
    }
}
