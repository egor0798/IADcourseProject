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
@Table(name = "improvement_buildings")
public class ImprovementBuildings {
    @Id
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "typeOfImprovement")
    private List<Resource> resourceList = new ArrayList<>();

    public ImprovementBuildings(long id, String name){
        this.id = id;
        this.name = name;
    }
}
