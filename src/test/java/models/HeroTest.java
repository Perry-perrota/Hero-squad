package models;

import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeroTest {

    @After
    public void tearDown() {
        Hero.clearAllHeroes(); //clear out all the posts before each test.
    }

    @Test
    public void NewHeroObjectGetsCreated_true() throws Exception {
        Hero hero = setupHero();
        assertEquals(true, hero instanceof Hero);
    }

    @Test
    public void getmHero_name() {
        Hero hero = setupHero();
        assertEquals("perry", hero.getmHero_name());

    }

    @Test
    public void getmStrength() {


    Hero hero = setupHero();

    assertEquals("flying",hero.getmStrength());
}

    @Test
    public void getmWeakness() {

        Hero hero = setupHero();
        assertEquals("kryptonite", hero.getmWeakness());
    }
    @Test
    public void getmAge() {
    Hero hero=setupHero();
    assertEquals(1,hero.getmAge());
    }

    public Hero setupHero(){

        return new Hero("perry","flying","kryptonite",1);


    }
    @Test
    public void AllHeroesAreCorrrectlyreturned(){
        Hero hero=new Hero("perry","flying","kryptonite",1);
        Hero otherHero=new Hero ("perr","flyin","kryptonit",5);
        assertEquals(2,Hero.getAll().size());

    }
    @Test
    public void AllHeroesContainAllHeros_true(){
        Hero hero=new Hero("perry","flying","kryptonite",1);
        Hero otherHero=new Hero("perry","flyingw","kryptonit",2);
        assertTrue(Hero.getAll().contains(hero));
        assertTrue(Hero.getAll().contains(otherHero));

    }
    @Test
    public void getId_heroesInstantiateWithAnID_1() throws Exception {
        Hero.clearAllHeroes();
        Hero myHero = new Hero("Day 1: Intro", "potato","",9);
        assertEquals(1, myHero.getId());
    }
    @Test
    public void findReturnsCorrectHero() throws Exception {
        Hero hero= setupHero();
        assertEquals(1, hero.findById(hero.getId()).getId());
    }

    @Test
    public void findReturnsCorrectHeroWhenMoreThanOneHeroExists() throws Exception {
        Hero hero = setupHero();
        Hero otherHero = new Hero("How to pair successfully","","",9);
        assertEquals(2, Hero.findById(otherHero.getId()).getId());
    }
    @Test
    public void deleteDeletesASpecificSquad() throws Exception {
        Hero hero = setupHero();
        Hero otherPost = new Hero("How to pair successfully","","",9);
        hero.deleteHero();
        assertEquals(1, Hero.getAll().size()); //one is left
        assertEquals(Hero.getAll().get(0).getId(), 2); //the one that was deleted has the id of 2. Why do we care?
    }

}