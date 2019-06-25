package dao;
import modules.Hero;
import modules.Squad;

import java.util.List;

public interface HeroDao {
    void addHero(Hero hero);
    List<Hero> getAllHeroes();
    List<Squad> getAllSquads();
    Hero findById(int id);

}
