package modules;


import java.util.List;
import java.util.Objects;

public class Squad {
    private String mCause_value;
    private String mSquadName;

    public Squad(String cause_value,String squadName){
        this.mCause_value=cause_value;
        this.mSquadName=squadName;
    }
    public String getmCause_value(){
        return mCause_value;
    }
    public String getmSquadName() {
        return mSquadName;
    }
    @Override
    public int hashCode(){
        return Objects.hash(getmSquadName(),getmCause_value());
    }




}
