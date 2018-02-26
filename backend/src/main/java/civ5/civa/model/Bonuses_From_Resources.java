package civ5.civa.model;

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
public class Bonuses_From_Resources {
    @Id
    @Column(name = "id")
    private long id;
    @Column(name = "parameter")
    private String parameter;
    @Column(name = "bonus")
    private String bonus;

    @OneToMany
    @JoinColumn(name="bonus_without_improvement", referencedColumnName = "id")
    private List<Resources> resourcesList = new ArrayList<>();
    @OneToMany
    @JoinColumn(name="bonus_with_improvement", referencedColumnName = "id")
    private List<Resources> resourcesList1 = new ArrayList<>();

    public Bonuses_From_Resources(long id, String parameter, String bonus){
        this.id = id;
        this.parameter = parameter;
        this.bonus = bonus;
    }
}
