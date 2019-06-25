package dao;
import modules.Hero;
import modules.Squad;
import org.sql2o.*;

import java.util.List;

public class Sql2oHeroDao implements HeroDao {
    private final Sql2o sql2o;


    public Sql2oHeroDao(Sql2o sql2o) {
        this.sql2o =  sql2o;

    }
        @Override
        public void addHero(Hero hero) {
            String sql = "INSERT INTO heroSquadDetails (strength,weakness,age,hero_name,cause_value,squad_name) VALUES (:strength,:weakness,:age,:hero_name,:cause_value,:squad_name)";
            try(Connection con = sql2o.open()){
                int id = (int) con.createQuery(sql, true)
                        .bind(hero)
                        .executeUpdate()
                        .getKey();
                hero.setId(id);
            } catch (Sql2oException ex) {
                System.out.println(ex);
            }
         }
        @Override
        public List<Hero> getAllHeroes(){
            try(Connection con = sql2o.open()){
                return con.createQuery("SELECT hero_name,strength,weakness,age FROM heroSquadDetails") //raw sql
                        .executeAndFetch(Hero.class);
            }
        }
        @Override
        public List<Squad> getAllSquads(){
            try(Connection con = sql2o.open()){
                return con.createQuery("SELECT cause_value,squad_name FROM heroSquadDetails") //raw sql
                        .executeAndFetch(Squad.class);
        }
        }




    @Override
        public Hero findById(int id){
            try (Connection con = sql2o.open()) {
                return con.createQuery("SELECT hero_name,strength,weakness,age FROM tasks WHERE id = :id")
                        .addParameter("id", id) //key/value pair, key must match above
                        .executeAndFetchFirst(Hero.class);
            }
        }


    }


