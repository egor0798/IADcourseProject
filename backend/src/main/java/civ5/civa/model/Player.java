package civ5.civa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="players")
public class Player {

    //unidirectional one-to-many
    @OneToMany
    @JoinColumn(name="players_id", referencedColumnName = "id")
    @JsonIgnore
    private Set<Achievement> achievementList = new HashSet<>();

    //not unidirectional one-to-many
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "creator")
    @JsonIgnore
    private List<Mod> modList = new ArrayList<>();

    @Id
    @Column(name = "id")
    private long id;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "nickname")
    private String nickname;
    @Column(name = "rank")
    private int rank;
    @Column(name="password")
    private String password;

    public Player(int id, String nickname, String firstName, String lastName, String password){
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.nickname=nickname;
        this.password = password;
    }
}
