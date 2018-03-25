package civ5.civa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "bonuses_from_resources")
public class BonusFromResource {
    @Id
    @Column(name = "id")
    private long id;
    @Column(name = "parameter")
    private String parameter;
    @Column(name = "bonus")
    private String bonus;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bonusWithoutImprovement")
    private List<Resource> resourceList = new ArrayList<>();
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bonusWithoutImprovement")
    private List<Resource> resourceWithImpList1 = new ArrayList<>();

    public BonusFromResource(long id, String parameter, String bonus){
        this.id = id;
        this.parameter = parameter;
        this.bonus = bonus;
    }
}
