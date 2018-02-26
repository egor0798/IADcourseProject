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
@Table(name="players")
public class Players {
    @OneToMany
    @JoinColumn(name="player_id", referencedColumnName = "id")
    private List<Achievements> achievementsList = new ArrayList<>();

    @OneToMany
    @JoinColumn(name="creator_id", referencedColumnName = "id")
    private List<Achievements> modsList = new ArrayList<>();

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
    // TODO realize roles
    //@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    //private List<Role> role;
    private String role;

    public Players(int id, String nickname, String firstName, String lastName, String role, String password){
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.nickname=nickname;
        this.role=role;
        this.password = password;
    }
}
