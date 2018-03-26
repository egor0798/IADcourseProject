package civ5.civa.response;

import civ5.civa.model.Building;
import civ5.civa.model.PerkForState;
import civ5.civa.model.Unit;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class NationResponse implements Serializable{
    private String state;
    private String ruler;
    private Unit uniqueUnit;
    private Building uniqueBuilding;
    private PerkForState perk;
}
