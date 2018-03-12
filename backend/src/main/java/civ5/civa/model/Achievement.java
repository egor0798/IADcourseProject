package civ5.civa.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name="achievements")
public class Achievement {

    @Id
    @Column(name = "id")
    private long id;
    //TODO rename to players_id to player_id in DB creating script bc this is illogically
    @Column(name = "players_id")
    private long playerId;

    @Column(name = "name")
    private String name;


    @Column(name = "achieving_date")
    @Temporal(TemporalType.DATE)
    private Date achievingDate;

    @Column(name = "conditions", length = 1_000)
    private String conditions;

    public Achievement(int id, int players_id, String name, String conditions){
        this.id=id;
        this.playerId =players_id;
        this.name=name;
        this.conditions=conditions;
        this.achievingDate = new Date(System.currentTimeMillis());
    }
}
