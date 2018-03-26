package civ5.civa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="perks_for_states")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PerkForState implements Serializable{
    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "parameter")
    private String parameter;

    @Column(name = "bonus")
    private String bonus;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "perk")
    @JsonIgnore
    private List<Nation> nationList;


    public PerkForState(int id, String parameter, String bonus){
        this.id=id;
        this.parameter=parameter;
        this.bonus=bonus;
    }
}
