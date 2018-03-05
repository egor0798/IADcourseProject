package civ5.civa.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
import java.util.Calendar;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name="achievements")
public class Achievement {

    Calendar calendar = Calendar.getInstance();

    int Date = calendar.get(Calendar.DAY_OF_MONTH);
    int Month = calendar.get(Calendar.MONTH);
    int Year = calendar.get(Calendar.YEAR)-1900;

    @Id
    @Column(name = "id")
    private long id;
    //TODO rename to players_id to player_id in DB creating script bc this is illogically
    @Column(name = "players_id")
    private long playerId;

    @Column(name = "name")
    private String name;


    // TODO refactor date format. Date class is deprecated
    @Column(name = "achieving_date")
    private Date achievingDate;

    @Column(name = "conditions", length = 1_000)
    private String conditions;

    public Achievement(int id, int players_id, String name, String conditions){
        this.id=id;
        this.playerId =players_id;
        this.name=name;
        this.conditions=conditions;
        Date date = new Date(Year,Month,Date);
        this.achievingDate =date;
    }
}
