import java.io.PrintStream;

/**
 * Created by tyw on 16-1-10.
 */
public class Solider extends Player{
    private Weapon weapon;
    private Armor armor;
    int denfense=0;
    public Solider(String name, int blood, int attack, PrintStream printer) {
        super(name, blood, attack, printer);
    }
    public void setWeapon(Weapon weapon){
        this.weapon=weapon;
        this.attack+=weapon.getAttack();
    }
    public Weapon getWeapon(){
        return this.weapon;
    }
    public void setArmor(Armor armor){
        this.armor=armor;
        this.denfense=armor.getDefense();
    }
    public Armor getArmor(){
        return this.armor;
    }

    public String getHurt(NormalPlayer player){
        if(player!=null) {
            int actualAttack=0;
            if(player.getAttack()>this.denfense) {
                actualAttack = player.getAttack() - this.denfense;
            }
            this.blood -= actualAttack;
            if (this.blood < 0) {
                status = this.goDie();
            } else {
                status = "普通人" + player.getName() + "攻击了战士" + this.name + "," + this.name + "受到了" + actualAttack + "点伤害," + this.name + "剩余生命：" + this.blood;
            }
            return status;
        }else {
            return "getHurt input null";
        }
    }
    public String getHurt(Solider player){
        if(player!=null) {
            int actualAttack=0;
            if(player.getAttack()>this.denfense) {
                actualAttack = player.getAttack() - this.denfense;
            }
            this.blood -= actualAttack;
            if (this.blood < 0) {
                status = this.goDie();
            } else {
                if(player.getWeapon()!=null) {
                    status = "战士" + player.getName() +"用"+player.getWeapon().getName()+ "攻击了战士" + this.name + "," + this.name + "受到了" + actualAttack + "点伤害," + this.name + "剩余生命：" + this.blood;
                }else{
                    status = "普通人" + player.getName() + "攻击了战士" + this.name + "," + this.name + "受到了" + actualAttack + "点伤害," + this.name + "剩余生命：" + this.blood;
                }
            }
            return status;
        }else {
            return "getHurt input null";
        }
    }
}
