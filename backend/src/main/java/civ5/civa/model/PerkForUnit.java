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
@Table(name = "perks_for_units")
public class PerkForUnit {
    @Id
    @Column(name = "id")
    private long id;
    @Column(name = "parameter")
    private String parameter;
    @Column(name = "bonus")
    private String bonus;

    @ManyToMany(mappedBy = "perkForUnitList")
    private List<Unit> unitList = new ArrayList<>();

    public PerkForUnit(long id, String parameter, String bonus){
        this.bonus = bonus;
        this.parameter = parameter;
        this.id = id;
    }
}
