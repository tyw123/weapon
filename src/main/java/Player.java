import java.io.PrintStream;

/**
 * Created by tyw on 16-1-10.
 */
public class Player {
    String name;
    int blood;
    int attack;
    PrintStream printer;
    String status;

    public Player(String name, int blood, int attack, PrintStream printer) {
        this.name=name;
        this.blood=blood;
        this.attack=attack;
        this.printer=printer;
    }

    public String getHurt(Player player) {
        this.blood-=player.getAttack();
        if(this.blood<0){status=this.goDie();}
        else{status=player.getName()+"攻击了"+this.name+","+this.name+"受到了"+player.getAttack()+"点伤害,"+this.name+"剩余生命："+this.blood;}
        return status;
    }

    public String goDie() {
        status=this.name+"被打败了";
        return status;
    }

    public int getAttack() {
        return this.attack;
    }

    public int getBlood() {
        return this.blood;
    }

    public String getName(){return this.name;}

    public void say() {
        printer.println(status);
    }
}
