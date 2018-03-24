package civ5.civa.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Getter
@Setter
@NoArgsConstructor
@Entity(name = "user_")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;


    private String username;

    @Column(name = "facebook_id")
    private String facebook;
    private String token;

    public User(String username, String facebook_id, String tk){
        this.username = username;
        this.facebook = facebook_id;
        this.token = tk;
    }
}
