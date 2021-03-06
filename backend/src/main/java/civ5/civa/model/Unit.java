package civ5.civa.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="units")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Unit implements Serializable{

    @Id
    @Column(name = "id")
    private long id;
    @Column(name = "unit_name")
    private String name;
    @JsonIgnore
    @Column(name = "unique_unit")
    private boolean unqUnit;
    @Column(name = "type")
    private String type;
    @Column(name = "points_to_create")
    private int points_to_create;
    @Column(name = "points_of_mov")
    private int points_of_mov;
    @Column(name = "strength")
    private int strength;
    @Column(name = "range_attack")
    private int range_attack;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "technology_to_create")
    @JsonIgnore
    private Technology technologyToCreate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resource")
    @JsonIgnore
    private Resource resource;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "uniqueUnit")
    @JsonIgnore
    private Nation nation;

    @ManyToMany
    @JoinTable(
            name = "unit_perks",
            joinColumns = @JoinColumn(name = "unit_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "perk_id", referencedColumnName = "id")
    )
    @JsonIgnore
    private List<PerkForUnit> perkForUnitList = new ArrayList<>();


    public Unit(int id, String name, boolean unqUnit, String type, int pts_create, int pts_mov, int strength, int range_attack, Technology tech_create, Resource resource){
        this.id=id;
        this.name = name;
        this.points_of_mov = pts_mov;
        this.points_to_create = pts_create;
        this.unqUnit = unqUnit;
        this.type = type;
        this.strength=strength;
        this.range_attack = range_attack;
        this.resource = resource;
        this.technologyToCreate = tech_create;
    }


}
