package modules;

import org.junit.Test;

import static org.junit.Assert.*;

public class SquadTest {


    @Test
    public void SquadInstantiatesWithCause_value_true() throws Exception {
        Squad squad = setupNewSquad();
        assertEquals("hunger", squad.getmCause_value());
    }

    @Test
    public void SquadInstantiatesWithSquad_name_true() throws Exception {
       Squad squad = setupNewSquad();
        assertEquals("famine-fight",squad.getmSquadName());
    }
    public Squad setupNewSquad(){
        return new Squad("hunger","famine-fight");
    }
}