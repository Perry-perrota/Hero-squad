package models;

import java.util.ArrayList;
import java.util.Objects;

public class Hero {
    private String mHero_name;
    private String mStrength;
    private String mWeakness;
    private int mAge;
    private static ArrayList<Hero> instances=new ArrayList<>();
    private int id;
    private int squadId;


    public Hero(String heroName,String strength,String weakness,int age){
        this.mAge=age;
        this.mHero_name=heroName;
        this.mWeakness=weakness;
        this.mStrength=strength;
        instances.add(this);
        this.id=instances.size();
        this.squadId=squadId;

    }

    public String getmHero_name() {
        return mHero_name;
    }

    public String getmStrength() {
        return mStrength;
    }

    public String getmWeakness() {
        return mWeakness;
    }

    public int getmAge() {
        return mAge;
    }

    public static ArrayList<Hero> getAll(){
        return instances;
    }
    public static void clearAllHeroes(){
        instances.clear();
    }

    public int getId(){
        return id;
    }
    public static Hero findById(int id){
        return instances.get(id-1);
    }
    public void deleteHero(){
        instances.remove(id-1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hero hero = (Hero) o;
        return mAge == hero.mAge &&
                id == hero.id &&
                squadId == hero.squadId &&
                mHero_name.equals(hero.mHero_name) &&
                mStrength.equals(hero.mStrength) &&
                mWeakness.equals(hero.mWeakness);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mHero_name, mStrength, mWeakness, mAge, id, squadId);
    }
}
