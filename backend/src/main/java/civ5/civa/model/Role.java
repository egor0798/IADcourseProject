package civ5.civa.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Getter
@Setter
@NoArgsConstructor
public class Role {
    //TODO think about roles
    @Id
    @GeneratedValue
    //@Column(name="id")
    private Long id;
    //@Column(name="name")
    private String name;
    public Role(String name){
        this.name=name;
    }
}
