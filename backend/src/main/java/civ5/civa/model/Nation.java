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
public class Nation {
    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "state")
    private String state;

    @Column(name="ruler")
    private String ruler;



    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unique_building")
    private Building uniqueBuilding;

    //TODO think about splitting unit an unique unit. with common table hard to do 2 unique units for nation
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unique_unit")
    private Unit uniqueUnit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "perk")
    private PerkForState perk;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nation")
    private List<Mod> modList = new ArrayList<>();


    public Nation(int id, String state, String ruler, Building uniqueBuilding, Unit uniqueUnit, PerkForState perk){
        this.id=id;
        this.state=state;
        this.ruler=ruler;
        this.uniqueBuilding = uniqueBuilding;
        this.uniqueUnit = uniqueUnit;
        this.perk=perk;
    }
}
