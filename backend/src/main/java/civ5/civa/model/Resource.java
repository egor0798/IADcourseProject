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
public class Resource {
    @Id
    @Column(name = "id")
    private long id;
    @Column(name = "resource")
    private String resource;
    @Column(name = "typeOfResource")
    private String typeOfResource;

    //@OneToOne(cascade = CascadeType.ALL, mappedBy = "book")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bonus_without_improvement")
    private BonusFromResource bonusWithoutImprovement;
    //@OneToOne(cascade = CascadeType.ALL, mappedBy = "book")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bonus_with_improvement")
    private BonusFromResource bonusWithImprovement;
    //@OneToOne(cascade = CascadeType.ALL, mappedBy = "book")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_of_improvement")
    private ImprovementBuildings typeOfImprovement;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "resource")
    private List<Unit> unitList = new ArrayList<>();

    //TODO ask AJIEKCEN wtf it was one-to-one




//    public Resource(int id, String resource, String typeOfResource, int bonus_with_impr, int bonus_without_impr, int type_of_impr){
//        this.id=id;
//        this.bonusWithImprovement = bonus_with_impr;
//        this.resource = resource;
//        this.typeOfResource = typeOfResource;
//        this.bonusWithoutImprovement = bonus_without_impr;
//        this.typeOfImprovement = type_of_impr;
//    }
}

