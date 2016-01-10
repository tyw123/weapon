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

    public void getHurt(Player player) {
        this.blood-=player.getAttack();
        if(this.blood<0){this.goDie();}
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

    public void say() {
        printer.println(status);
    }
}
