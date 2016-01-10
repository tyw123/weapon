import java.io.PrintStream;

/**
 * Created by tyw on 16-1-10.
 */
public class NormalPlayer extends Player{
    public NormalPlayer(String name, int blood, int attack, PrintStream printer) {
        super(name, blood, attack, printer);
    }
    public String getHurt(NormalPlayer player){
        if(player!=null) {
            this.blood -= player.getAttack();
            if (this.blood < 0) {
                status = this.goDie();
            } else {
                status = "普通人" + player.getName() + "攻击了普通人" + this.name + "," + this.name + "受到了" + player.getAttack() + "点伤害," + this.name + "剩余生命：" + this.blood;
            }
            return status;
        }else {
            return "getHurt input null";
        }
    }
    public String getHurt(Solider player){
        if(player!=null) {
            this.blood -= player.getAttack();
            if (this.blood < 0) {
                status = this.goDie();
            } else {
                if(player.getWeapon()!=null) {
                    status = "战士" + player.getName() +"用"+player.getWeapon().getName()+ "攻击了普通人" + this.name + "," + this.name + "受到了" + player.getAttack() + "点伤害," + this.name + "剩余生命：" + this.blood;
                }else{
                    status = "战士" + player.getName() + "攻击了普通人" + this.name + "," + this.name + "受到了" + player.getAttack() + "点伤害," + this.name + "剩余生命：" + this.blood;
                }
            }
            return status;
        }else {
            return "getHurt input null";
        }
    }
}
