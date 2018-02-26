package civ5.civa.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Calendar;
import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="mods")
public class Mods {
    public static int getCurrentYear()
    {
        Calendar calendar = Calendar.getInstance(java.util.TimeZone.getDefault(), java.util.Locale.getDefault());
        calendar.setTime(new Date());
        return calendar.get(Calendar.YEAR);
    }

    public static int getCurrentDay()
    {
        Calendar calendar = Calendar.getInstance(java.util.TimeZone.getDefault(), java.util.Locale.getDefault());
        calendar.setTime(new Date());
        return calendar.get(Calendar.DATE);
    }

    public static int getCurrentMonth()
    {
        Calendar calendar = Calendar.getInstance(java.util.TimeZone.getDefault(), java.util.Locale.getDefault());
        calendar.setTime(new Date());
        return calendar.get(Calendar.MONTH);
    }
    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "creator_id")
    private int creator_id;

    @Column(name = "nation_id")
    private int nation_id;

    @Column(name = "creation")
    private Date creation;

    @Column(name = "last_modification")
    private Date last_modification;
    public Mods(int id, int creator_id, int nation_id){
        this.id=id;
        this.creator_id=creator_id;
        this.nation_id=nation_id;
        java.sql.Date date = new java.sql.Date(getCurrentYear(), getCurrentMonth(), getCurrentDay());
        java.sql.Date date2 = new java.sql.Date(getCurrentYear()-1, getCurrentMonth()-2, getCurrentDay()-1);
        this.creation=date2;
        this.last_modification=date;
    }
}
