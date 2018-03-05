package civ5.civa.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="mods")
public class Mod {
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creator_id")
    private Player creator;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nation_id")
    private Nation nation;

    @Column(name = "creation")
    private Date creation;

    @Column(name = "last_modification")
    private Date lastModification;

    public Mod(int id, Player creator, Nation nation){
        this.id=id;
        this.creator=creator;
        this.nation=nation;
        java.sql.Date date = new java.sql.Date(getCurrentYear(), getCurrentMonth(), getCurrentDay());
        java.sql.Date date2 = new java.sql.Date(getCurrentYear()-1, getCurrentMonth()-2, getCurrentDay()-1);
        this.creation=date2;
        this.lastModification =date;
    }
}
