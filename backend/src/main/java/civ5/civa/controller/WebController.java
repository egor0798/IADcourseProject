package civ5.civa.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import civ5.civa.repo.*;
import civ5.civa.model.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@RestController
public class WebController {
    @Autowired
    PlayersRepository playersRepository;
    @Autowired
    AchievementsRepository achievementsRepository;
    @Autowired
    ModsRepository modsRepository;
    @Autowired
    NationsRepository nationsRepository;
    @Autowired
    PerksForStatesRepository perksForStatesRepository;
    @Autowired
    UnitsRepository unitsRepository;
    @Autowired
    TechnologiesRepository technologiesRepository;
    @Autowired
    BuildingsRepository buildingsRepository;
    @Autowired
    BonusesFromResourcesRepository bonusesFromResourcesRepository;
    @Autowired
    ImprBuildRepository imprBuildRepository;
    @Autowired
    ResourcesRepository resourcesRepository;
    @Autowired
    WondersRepository wondersRepository;
    @Autowired
    PerksForUnitsRepository perksForUnitsRepository;
    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @RequestMapping("/save")
    public String process(){
        // save a single Player
        achievementsRepository.deleteAll();
        modsRepository.deleteAll();
        playersRepository.deleteAll();
        nationsRepository.deleteAll();
        unitsRepository.deleteAll();
        perksForUnitsRepository.deleteAll();
        resourcesRepository.deleteAll();
        bonusesFromResourcesRepository.deleteAll();
        imprBuildRepository.deleteAll();
        technologiesRepository.deleteAll();
        buildingsRepository.deleteAll();
        wondersRepository.deleteAll();
        perksForStatesRepository.deleteAll();
        playersRepository.save(new Players(1,"jackSmith98","Jack", "Smith", "USER","jacksmith"));
        playersRepository.save(new Players(2,"adamas","Adam", "Johnson", "USER","jacksmith"));
        playersRepository.save(new Players(3,"kimchenir","Kim", "Smith", "USER", "jacksmith"));
        playersRepository.save(new Players(4,"dawille","David", "Williams", "USER", "jacksmith"));
        playersRepository.save(new Players(5,"petya","Peter", "Davis", "USER", "aaa"));
        achievementsRepository.save(new Achievements(1,1,"sclkj", "pjlckds"));
        achievementsRepository.save(new Achievements(2, 2,"lkss", "oiihc"));
        achievementsRepository.save(new Achievements(3, 2, "skjbskjbdxs", "ksjbcxsx"));
        wondersRepository.save(new Wonders(1,"sdsd", 212,12,"sdsd"));
        wondersRepository.save(new Wonders(2, "aaaa",322,13,"aaas"));
        technologiesRepository.save(new Technologies(1,"mapping", 12, "sdsd"));
        Wonders EifelTower = new Wonders(3,"Eifel Tower", 222,19,"Located in Paris, +19 culture");
        Technologies Welding = new Technologies(2,"Welding",110,"Opens Eifell Tower");
        Technologies Radio = new Technologies(3,"Radio",222, "Opens Radio Station");
        wondersRepository.save(EifelTower);
        technologiesRepository.save(Welding);
        technologiesRepository.save(Radio);
        List<Technologies> techs = new ArrayList<>();
        techs.add(Welding);
        EifelTower.setTechList(techs);
        List<Wonders> wonders = new ArrayList<>();
        wonders.add(EifelTower);
        Welding.setWondersList(wonders);
        wondersRepository.save(EifelTower);
        technologiesRepository.save(Welding);
        perksForStatesRepository.save(new PerksForStates(1,"startegic resources","+100%"));
        perksForStatesRepository.save(new PerksForStates(2,"culture points","+50%"));
        perksForStatesRepository.save(new PerksForStates(3,"jungles can be used as roads","1"));
        buildingsRepository.save(new Buildings(1,"Krepost",232,"no","+5 defence"));
        Buildings RadioStation = new Buildings(2,"Radio Station",2342,"no","+5 culture");
        buildingsRepository.save(RadioStation);
        List<Technologies> techs2 = new ArrayList<>();
        techs2.add(Radio);
        RadioStation.setTechnologies(techs2);
        List<Buildings> buildings = new ArrayList<>();
        buildings.add(RadioStation);
        Radio.setBuildings(buildings);
        buildingsRepository.save(RadioStation);
        technologiesRepository.save(Radio);
        bonusesFromResourcesRepository.save(new Bonuses_From_Resources(1,"no", "no"));
        bonusesFromResourcesRepository.save(new Bonuses_From_Resources(2,"oil","+4"));
        imprBuildRepository.save(new Improvement_Buildings(1,"field"));
        resourcesRepository.save(new Resources(0,"oil","strategic",2,1,1));
        Units VezhlivyeLudi = new Units(1,"Вежливые Люди",true,"field", 123, 2,90,0,3,null);
        unitsRepository.save(VezhlivyeLudi);
        nationsRepository.save(new Nations(1,"Russia","Putin",1,1,1));
        PerksForUnits perk1 = new PerksForUnits(1,"move","+1");
        PerksForUnits perk2 = new PerksForUnits(2,"sight","+1");
        perksForUnitsRepository.save(perk1);
        perksForUnitsRepository.save(perk2);
        Units LTank = new Units(2,"Light Tank",false,"field", 23, 2,20,0,1,null);
        unitsRepository.save(LTank);

        List<PerksForUnits> perksForUnits1 = new ArrayList<>();
        perksForUnits1.add(perk1);
        perksForUnits1.add(perk2);

        List<PerksForUnits> perksForUnits2 = new ArrayList<>();
        perksForUnits2.add(perk1);

        List<Units> unitsList1 = new ArrayList<>();
        unitsList1.add(LTank);
        unitsList1.add(VezhlivyeLudi);

        List<Units> unitsList2 = new ArrayList<>();
        unitsList2.add(VezhlivyeLudi);

        VezhlivyeLudi.setPerksForUnitsList(perksForUnits1);
        perk1.setUnitsList(unitsList1);

        perk2.setUnitsList(unitsList2);

        LTank.setPerksForUnitsList(perksForUnits2);
        perksForUnitsRepository.save(perk1);
        perksForUnitsRepository.save(perk2);
        unitsRepository.save(VezhlivyeLudi);
        unitsRepository.save(LTank);

        modsRepository.save(new Mods(1,1,1));
        return "Done with insertions";
    }

    //find all achievements of player


    @RequestMapping("/findplayersachievements")
    public List findPlayersAchievements(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String queryString = "SELECT players.nickname, achievements.name, achievements.achieving_date, achievements.conditions FROM players JOIN achievements ON players.id = achievements.players_id ORDER BY achievements.players_id;";
        Query query = entityManager.createNativeQuery(queryString);
        List<Object> list = query.getResultList();
        return list;
    }

    @RequestMapping("/current_unit_perks/{name}")
    @ResponseBody
    public List currentUnitPerks(@PathVariable("name") String name){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String queryString = "SELECT perks_for_units.parameter, perks_for_units.bonus FROM perks_for_units WHERE perks_for_units.id IN (SELECT unit_perks.perk_id FROM unit_perks JOIN units ON units.id = unit_perks.unit_id WHERE units.id = (SELECT units.id FROM units WHERE units.unit_name = ?1));";
        Query query = entityManager.createNativeQuery(queryString).setParameter(1,name);
        List<Object> list = query.getResultList();
        return list;
    }
    @RequestMapping("/")
    public String Hello(){
        return new String("Hello World! Это 2 часть курсача");
    }
}

