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
@Table(name = "perks_for_units")
public class PerksForUnits {
    @Id
    @Column(name = "id")
    private long id;
    @Column(name = "parameter")
    private String parameter;
    @Column(name = "bonus")
    private String bonus;

    @ManyToMany(mappedBy = "perksForUnitsList")
    private List<Units> unitsList = new ArrayList<>();

    public PerksForUnits(long id, String parameter, String bonus){
        this.bonus = bonus;
        this.parameter = parameter;
        this.id = id;
    }
}
