package modules;

import org.junit.Test;

import static org.junit.Assert.*;

public class HeroTest {
    @Test
    public void NewHeroObjectGetsCreated_true() throws Exception {
        Hero hero = setupNewHero();
        assertEquals(true, hero instanceof Hero);
    }

    public Hero setupNewHero() {
        return new Hero("sing", "dance", 4, "superman");
    }
    @Test
    public void HeroInstantiatesWithHeroName_true() throws Exception {
        Hero hero = setupNewHero();
        assertEquals("superman", hero.getName());
    }
    @Test
    public void HeroInstantiatesWithStrength_true() throws Exception {
        Hero hero = setupNewHero();
        assertEquals("sing", hero.getStrength());
    }
    @Test
    public void HeroInstantiatesWithAge_true() throws Exception {
        Hero hero = setupNewHero();
        assertEquals(4, hero.getAge());
    }
    @Test
    public void HeroInstantiatesWithWeakness_true() throws Exception {
        Hero hero = setupNewHero();
        assertEquals("dance", hero.getWeakness());
    }
}
