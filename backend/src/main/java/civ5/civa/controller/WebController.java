package civ5.civa.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import civ5.civa.repo.*;
import civ5.civa.model.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class WebController {
    @Autowired
    PlayerRepository playerRepository;
    @Autowired
    AchievementRepository achievementRepository;
    @Autowired
    ModRepository modRepository;
    @Autowired
    NationRepository nationRepository;
    @Autowired
    PerkForStateRepository perkForStateRepository;
    @Autowired
    UnitRepository unitRepository;
    @Autowired
    TechnologyRepository technologyRepository;
    @Autowired
    BuildingRepository buildingRepository;
    @Autowired
    BonusFromResourceRepository bonusFromResourceRepository;
    @Autowired
    ImprovementBuildingRepository improvementBuildingRepository;
    @Autowired
    ResourceRepository resourceRepository;
    @Autowired
    WonderRepository wonderRepository;
    @Autowired
    PerkForUnitRepository perkForUnitRepository;
    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

   // @RequestMapping("/save")
//    public String process(){
//        // save a single Player
//        achievementsRepository.deleteAll();
//        modsRepository.deleteAll();
//        playersRepository.deleteAll();
//        nationsRepository.deleteAll();
//        unitsRepository.deleteAll();
//        perksForUnitsRepository.deleteAll();
//        resourcesRepository.deleteAll();
//        bonusesFromResourcesRepository.deleteAll();
//        imprBuildRepository.deleteAll();
//        technologyRepository.deleteAll();
//        buildingsRepository.deleteAll();
//        wondersRepository.deleteAll();
//        perksForStatesRepository.deleteAll();
//        playersRepository.save(new Player(1,"jackSmith98","Jack", "Smith", "USER","jacksmith"));
//        playersRepository.save(new Player(2,"adamas","Adam", "Johnson", "USER","jacksmith"));
//        playersRepository.save(new Player(3,"kimchenir","Kim", "Smith", "USER", "jacksmith"));
//        playersRepository.save(new Player(4,"dawille","David", "Williams", "USER", "jacksmith"));
//        playersRepository.save(new Player(5,"petya","Peter", "Davis", "USER", "aaa"));
//        achievementsRepository.save(new Achievement(1,1,"sclkj", "pjlckds"));
//        achievementsRepository.save(new Achievement(2, 2,"lkss", "oiihc"));
//        achievementsRepository.save(new Achievement(3, 2, "skjbskjbdxs", "ksjbcxsx"));
//        wondersRepository.save(new Wonder(1,"sdsd", 212,12,"sdsd"));
//        wondersRepository.save(new Wonder(2, "aaaa",322,13,"aaas"));
//        technologyRepository.save(new Technology(1,"mapping", 12, "sdsd"));
//        Wonder EifelTower = new Wonder(3,"Eifel Tower", 222,19,"Located in Paris, +19 culture");
//        Technology Welding = new Technology(2,"Welding",110,"Opens Eifell Tower");
//        Technology Radio = new Technology(3,"Radio",222, "Opens Radio Station");
//        wondersRepository.save(EifelTower);
//        technologyRepository.save(Welding);
//        technologyRepository.save(Radio);
//        List<Technology> techs = new ArrayList<>();
//        techs.add(Welding);
//        EifelTower.setTechList(techs);
//        List<Wonder> wonders = new ArrayList<>();
//        wonders.add(EifelTower);
//        Welding.setWonderList(wonders);
//        wondersRepository.save(EifelTower);
//        technologyRepository.save(Welding);
//        perksForStatesRepository.save(new PerkForState(1,"startegic resources","+100%"));
//        perksForStatesRepository.save(new PerkForState(2,"culture points","+50%"));
//        perksForStatesRepository.save(new PerkForState(3,"jungles can be used as roads","1"));
//        buildingsRepository.save(new Building(1,"Krepost",232,"no","+5 defence"));
//        Building RadioStation = new Building(2,"Radio Station",2342,"no","+5 culture");
//        buildingsRepository.save(RadioStation);
//        List<Technology> techs2 = new ArrayList<>();
//        techs2.add(Radio);
//        RadioStation.setTechnologies(techs2);
//        List<Building> buildings = new ArrayList<>();
//        buildings.add(RadioStation);
//        Radio.setBuildings(buildings);
//        buildingsRepository.save(RadioStation);
//        technologyRepository.save(Radio);
//        bonusesFromResourcesRepository.save(new BonusFromResource(1,"no", "no"));
//        bonusesFromResourcesRepository.save(new BonusFromResource(2,"oil","+4"));
//        imprBuildRepository.save(new ImprovementBuildings(1,"field"));
//        resourcesRepository.save(new Resource(0,"oil","strategic",2,1,1));
//        Unit VezhlivyeLudi = new Unit(1,"Вежливые Люди",true,"field", 123, 2,90,0,3,null);
//        unitsRepository.save(VezhlivyeLudi);
//        nationsRepository.save(new Nation(1,"Russia","Putin",1,1,1));
//        PerkForUnit perk1 = new PerkForUnit(1,"move","+1");
//        PerkForUnit perk2 = new PerkForUnit(2,"sight","+1");
//        perksForUnitsRepository.save(perk1);
//        perksForUnitsRepository.save(perk2);
//        Unit LTank = new Unit(2,"Light Tank",false,"field", 23, 2,20,0,1,null);
//        unitsRepository.save(LTank);
//
//        List<PerkForUnit> perkForUnit1 = new ArrayList<>();
//        perkForUnit1.add(perk1);
//        perkForUnit1.add(perk2);
//
//        List<PerkForUnit> perkForUnit2 = new ArrayList<>();
//        perkForUnit2.add(perk1);
//
//        List<Unit> unitList1 = new ArrayList<>();
//        unitList1.add(LTank);
//        unitList1.add(VezhlivyeLudi);
//
//        List<Unit> unitList2 = new ArrayList<>();
//        unitList2.add(VezhlivyeLudi);
//
//        VezhlivyeLudi.setPerkForUnitList(perkForUnit1);
//        perk1.setUnitList(unitList1);
//
//        perk2.setUnitList(unitList2);
//
//        LTank.setPerkForUnitList(perkForUnit2);
//        perksForUnitsRepository.save(perk1);
//        perksForUnitsRepository.save(perk2);
//        unitsRepository.save(VezhlivyeLudi);
//        unitsRepository.save(LTank);
//
//        modsRepository.save(new Mod(1,1,1));
//        return "Done with insertions";
//    }

    //find all achievements of player


    @RequestMapping("/findplayersachievements")
    public List findPlayersAchievements(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String queryString = "SELECT players.nickname, achievements.name, achievements.achieving_date, achievements.conditions FROM players JOIN achievements ON players.id = achievements.players_id ORDER BY achievements.players_id;";
        Query query = entityManager.createNativeQuery(queryString);
        List<Object> list = query.getResultList();
        return list;
    }

    @RequestMapping("/findallwonders")
    public List<Optional<Wonder>> findWonders(){
//        Iterable<Wonder> iterable =  wondersRepository.findAll();
//        List<Wonder> wonders = new ArrayList();
//        iterable.forEach(wonders::add);
//        return wonders;
        return Arrays.asList(wonderRepository.findById(1L));
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

