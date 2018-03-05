package civ5.civa.model;

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
    private Set<Achievement> achievementList = new HashSet<>();

    //not unidirectional one-to-many
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "creator")
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
    @Column (name="role")
    // TODO do roles
    //@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    //private List<Role> role;
    private String role;

    public Player(int id, String nickname, String firstName, String lastName, String role, String password){
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.nickname=nickname;
        this.role=role;
        this.password = password;
    }
}
