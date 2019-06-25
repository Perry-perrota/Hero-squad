package modules;
import java.util.List;
import java.util.Objects;

public class Hero extends Squad{
    private String mStrength;
    private String mWeakness;
    private int mAge;
    private String mName;
    private int id;


    public Hero(String strength, String weakness, int age,String hero_name,String cause_value,String squad_name) {
        super(cause_value,squad_name);
        this.mStrength = strength;
        this.mWeakness = weakness;
        this.mAge = age;
        this.mName =hero_name;


    }


    @Override
    public int hashCode() {
        return Objects.hash(getStrength(), getWeakness(), getName(), getAge());

    }


    public String getStrength() {
        return mStrength;
    }

    public String getWeakness() {
        return mWeakness;
    }

    public String getName() {
        return mName;
    }

    public int getAge() {
        return mAge;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setmName(String hero_name){
        this.mName=hero_name;
    }
    public void setmStrength(String strength){
        this.mName=strength;
    }
    public void setmAge(int age){
        this.mAge=age;
    }
    public void setmWeakness(String weakness){
        this.mWeakness=weakness;
    }

    }




