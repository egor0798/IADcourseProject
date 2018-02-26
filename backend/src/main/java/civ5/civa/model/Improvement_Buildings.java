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
public class Improvement_Buildings {
    @Id
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
    @OneToMany
    @JoinColumn(name="type_of_improvement", referencedColumnName = "id")
    private List<Resources> resourcesList = new ArrayList<>();

    public Improvement_Buildings(long id, String name){
        this.id = id;
        this.name = name;
    }
}
