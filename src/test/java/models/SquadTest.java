package models;

import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

public class SquadTest {
    @After
    public void tearDown() {
        Squad.clearAllSquads();
    }

    @Test
    public void getmSquad_name() {
    }

    @Test
    public void getmCauseValue() {
        Squad squad = setupSquad();
        assertEquals("young", squad.getmCauseValue());
    }

    @Test
    public void NewSquadObjectGetsCreated_true() throws Exception {
        Squad squad = setupSquad();
        assertEquals(true, squad instanceof Squad);
    }

    public Squad setupSquad() {
        return new Squad("forever", "young");
    }

    @Test
    public void getId_squadsInstantiateWithAnID_1() throws Exception {
        Squad.clearAllSquads();
        Squad mySquad = new Squad("Day 1: Intro", "potato");
        assertEquals(1, mySquad.getId());
    }
    @Test
    public void findReturnsCorrectSquad() throws Exception {
        Squad squad = setupSquad();
        assertEquals(1, Squad.findById(squad.getId()).getId());
    }

    @Test
    public void findReturnsCorrectSquadWhenMoreThanOneSquadExists() throws Exception {
        Squad post = setupSquad();
        Squad otherSquad = new Squad("How to pair successfully","");
        assertEquals(2, Squad.findById(otherSquad.getId()).getId());
    }
    @Test
    public void delete_DeletesASpecificSquad() throws Exception {
        Squad post = setupSquad();
        Squad squad = new Squad("How to pair successfully","");
        post.deleteSquad();
        assertEquals(1, Squad.getAll().size()); //one is left
        assertEquals(Squad.getAll().get(0).getId(), 2); //the one that was deleted has the id of 2. Why do we care?
    }
}