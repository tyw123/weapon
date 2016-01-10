import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by tyw on 16-1-10.
 */
public class SoliderTest {
    PrintStream fakedOut = mock(PrintStream.class);
    Solider 张三=new Solider("张三",100,30,fakedOut);
    NormalPlayer 李四=new NormalPlayer("李四",100,30,fakedOut);
    Solider Lucy=new Solider("Lucy",100,30,fakedOut);
    @Test
    public void should_solider_getHurt_normalplayer_return_right(){
        张三.setWeapon(new Weapon("优质木棒",33));
        张三.setArmor(new Armor("遮阳伞",12));
        张三.getHurt(李四);
        张三.say();
        verify(fakedOut).println("普通人李四攻击了战士张三,张三受到了18点伤害,张三剩余生命：82");
    }
    @Test
    public void should_solider_getHurt_solider_return_right(){
        张三.setWeapon(new Weapon("优质木棒",33));
        张三.setArmor(new Armor("遮阳伞",12));
        Lucy.setWeapon(new Weapon("打狗棒",42));
        Lucy.setArmor(new Armor("遮阳伞",12));
        张三.getHurt(Lucy);
        张三.say();
        verify(fakedOut).println("战士Lucy用打狗棒攻击了战士张三,张三受到了60点伤害,张三剩余生命：40");
    }
}
