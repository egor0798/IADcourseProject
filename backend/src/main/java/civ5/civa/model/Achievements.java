package civ5.civa.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="achievements")
public class Achievements{

    Calendar calendar = Calendar.getInstance();

    int Date = calendar.get(Calendar.DAY_OF_MONTH);
    int Month = calendar.get(Calendar.MONTH);
    int Year = calendar.get(Calendar.YEAR)-1900;

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "players_id")
    private long players_id;

    @Column(name = "name")
    private String name;

    @Column(name = "achieving_date")
    private Date achieving_date;

    @Column(name = "conditions", length = 1_000)
    private String conditions;

    protected Achievements() {
    }

    public Achievements(int id, int players_id, String name, String conditions){
        this.id=id;
        this.players_id=players_id;
        this.name=name;
        this.conditions=conditions;
        Date date = new Date(Year,Month,Date);
        this.achieving_date=date;
    }
}
