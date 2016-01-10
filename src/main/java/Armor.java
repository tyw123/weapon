/**
 * Created by tyw on 16-1-10.
 */
public class Armor {
    private String name;
    private int defense;
    public Armor(String name,int defense){
        this.name=name;
        this.defense =defense;
    }

    public String getName(){

        return this.name;
    }
    public int getDefense(){
        return this.defense;
    }
}
