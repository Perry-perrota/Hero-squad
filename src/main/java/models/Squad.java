package models;

import java.util.ArrayList;
import java.util.List;

public class Squad {
    private String mSquad_name;
    private String mCauseValue;
    private static ArrayList<Squad> instances=new ArrayList<>();
    private int id;
    private List<models.Hero> mheroes;
    private int squad_size;

    public int getSquad_size() {
        return squad_size;
    }



    public String getmSquad_name() {
        return mSquad_name;
    }

    public String getmCauseValue() {
        return mCauseValue;
    }
    public static void clearAllSquads(){
        instances.clear();

    }
    public static ArrayList<Squad> getAll(){
        return instances;
    }
    public int getId(){
        return id;
    }
    public static Squad findById(int id){
        return instances.get(id-1);
    }
    public void deleteSquad(){
        instances.remove(id-1);
    }

    public List<models.Hero> getMheroes() {
        return mheroes;
    }
    public void addHero(models.Hero hero){
        mheroes.add(hero);
    }
    public Squad(String squad_name, String causeValue, int squad_size){
        this.mSquad_name=squad_name;
        this.mCauseValue=causeValue;
        instances.add(this);
        this.id=instances.size();
        mheroes=new ArrayList<models.Hero>();
        this.squad_size=squad_size;
    }
}
