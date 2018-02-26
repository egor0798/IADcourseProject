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
@Table(name="technologies")
public class Technologies {

    @Id
    @Column(name="id")
    private long id;
    @Column(name = "tech_name")
    private String tech_name;
    @Column(name = "points")
    private int points;
    @Column(name = "features")
    private String features;

    @OneToMany
    @JoinColumn(name="technology_to_create", referencedColumnName = "id")
    private List<Units> technologiesList = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "building_tech",
            joinColumns = @JoinColumn(name = "tech_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "building_id", referencedColumnName = "id")
    )
    private List<Buildings> buildings = new ArrayList<>();

    //TODO read more about M-M and refactor it maybe
    @ManyToMany
    @JoinTable(
            name = "tech_wonder",
            joinColumns = @JoinColumn(name = "technology", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "wonder", referencedColumnName = "id")
    )
    private List<Wonders> wondersList = new ArrayList<>();


    public Technologies(int id, String tech_name, int points, String features){
        this.id=id;
        this.features = features;
        this.tech_name = tech_name;
        this.points = points;
    }
}
