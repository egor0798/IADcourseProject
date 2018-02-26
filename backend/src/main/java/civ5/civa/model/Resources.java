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
@Table(name = "resources")
public class Resources {
    @Id
    @Column(name = "id")
    private long id;
    @Column(name = "resource")
    private String resource;
    @Column(name = "type_of_resource")
    private String type_of_resource;

    //TODO refactor getter annotation to field annotation
    //@OneToOne(cascade = CascadeType.ALL, mappedBy = "book")
    @Column(name = "bonus_without_improvement")
    private int bonus_without_improvement;
    //@OneToOne(cascade = CascadeType.ALL, mappedBy = "book")
    @Column(name = "bonus_with_improvement")
    private int bonus_with_improvement;
    //@OneToOne(cascade = CascadeType.ALL, mappedBy = "book")
    @Column(name = "type_of_improvement")
    private int type_of_improvement;

    @OneToMany
    @JoinColumn(name="recource", referencedColumnName = "id")
    private List<Units> unitsList = new ArrayList<>();


        @OneToOne(cascade = CascadeType.ALL, mappedBy = "book")
    public int getBonus_without_improvement() {
        return bonus_without_improvement;
    }

    public void setBonus_without_improvement(int bonus_without_improvement) {
        this.bonus_without_improvement = bonus_without_improvement;
    }

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "book")
    public int getBonus_with_improvement() {
        return bonus_with_improvement;
    }

    public void setBonus_with_improvement(int bonus_with_improvement) {
        this.bonus_with_improvement = bonus_with_improvement;
    }
//
//    @OneToOne(cascade = CascadeType.ALL, mappedBy = "book")
//    public int getType_of_improvement() {
//        return type_of_improvement;
//    }



    public Resources(int id, String resource, String type_of_resource, int bonus_with_impr, int bonus_without_impr, int type_of_impr){
        this.id=id;
        this.bonus_with_improvement = bonus_with_impr;
        this.resource = resource;
        this.type_of_resource = type_of_resource;
        this.bonus_without_improvement = bonus_without_impr;
        this.type_of_improvement = type_of_impr;
    }
}

