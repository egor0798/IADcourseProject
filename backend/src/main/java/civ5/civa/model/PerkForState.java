package civ5.civa.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="perks_for_states")
public class PerkForState {
    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "parameter")
    private String parameter;

    @Column(name = "bonus")
    private String bonus;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "perk")
    private List<Nation> nationList;


    public PerkForState(int id, String parameter, String bonus){
        this.id=id;
        this.parameter=parameter;
        this.bonus=bonus;
    }
}
