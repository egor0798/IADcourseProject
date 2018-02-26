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
@Table(name="nations")
public class Nations {
    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "state")
    private String state;

    @Column(name="ruler")
    private String ruler;

    @Column(name = "unique_building")
    private int unique_building;

    @Column(name = "unique_unit")
    private int unique_unit;

    @Column(name = "perk")
    private int perk;

    @OneToMany
    @JoinColumn(name="nation_id", referencedColumnName = "id")
    private List<Mods> modsList = new ArrayList<>();


    public Nations(int id, String state, String ruler, int unique_building, int unique_unit, int perk){
        this.id=id;
        this.state=state;
        this.ruler=ruler;
        this.unique_building=unique_building;
        this.unique_unit=unique_unit;
        this.perk=perk;
    }
}
