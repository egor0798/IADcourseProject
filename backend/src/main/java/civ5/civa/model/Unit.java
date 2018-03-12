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
@Table(name="units")
public class Unit {

    @Id
    @Column(name = "id")
    private long id;
    @Column(name = "unit_name")
    private String name;
    @Column(name = "unique_unit")
    private boolean unique_unit;
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
    private Technology technologyToCreate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resource")
    private Resource resource;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "uniqueUnit")
    private Nation nation;

    @ManyToMany
    @JoinTable(
            name = "unit_perks",
            joinColumns = @JoinColumn(name = "unit_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "perk_id", referencedColumnName = "id")
    )
    private List<PerkForUnit> perkForUnitList = new ArrayList<>();


    public Unit(int id, String name, boolean unq_unit, String type, int pts_create, int pts_mov, int strength, int range_attack, Technology tech_create, Resource resource){
        this.id=id;
        this.name = name;
        this.points_of_mov = pts_mov;
        this.points_to_create = pts_create;
        this.unique_unit = unq_unit;
        this.type = type;
        this.strength=strength;
        this.range_attack = range_attack;
        this.resource = resource;
        this.technologyToCreate = tech_create;
    }


}
