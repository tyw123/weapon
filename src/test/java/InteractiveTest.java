import org.junit.Test;

import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by tyw on 16-1-10.
 */
public class InteractiveTest {
    PrintStream fakedOut = mock(PrintStream.class);
    Player Tom=new Player("Tom",100,30,fakedOut);
    Player Jay=new Player("Jay",200,40, fakedOut);
    Solider 张三=new Solider("张三",100,30,fakedOut);
    NormalPlayer 李四=new NormalPlayer("李四",100,30,fakedOut);
    Solider Lucy=new Solider("Lucy",100,30,fakedOut);
    @Test
    public void should_interactive_simpleDefeat_return_right(){
        Interactive Defeat=new Interactive(fakedOut);
        Defeat.simpleDefeat(Tom,Jay);
        Defeat.say();
        verify(fakedOut).println("Tom被打败了");
    }
    @Test
    public void should_interactive_simpleDefeat_father_test_return_right(){
        Interactive Defeat=new Interactive(fakedOut);
        Defeat.simpleDefeat(Tom,Jay);
        Defeat.sayLog();
        verify(fakedOut).println("Jay攻击了Tom,Tom受到了40点伤害,Tom剩余生命：60\n" +
                "Tom攻击了Jay,Jay受到了30点伤害,Jay剩余生命：170\n" +
                "Jay攻击了Tom,Tom受到了40点伤害,Tom剩余生命：20\n" +
                "Tom攻击了Jay,Jay受到了30点伤害,Jay剩余生命：140\n" +
                "Tom被打败了");
    }
    @Test
    public void should_interactive_pleDefeat_father_test_return_right(){
        Interactive Defeat=new Interactive(fakedOut);
        Defeat.simpleDefeat(张三,Lucy);
        张三.setWeapon(new Weapon("优质木棒",33));
        张三.setArmor(new Armor("遮阳伞",12));
        Lucy.setWeapon(new Weapon("打狗棒",42));
        Lucy.setArmor(new Armor("遮阳伞",12));
        Defeat.sayLog();
        verify(fakedOut).println("Jay攻击了Tom,Tom受到了40点伤害,Tom剩余生命：60\n" +
                "Tom攻击了Jay,Jay受到了30点伤害,Jay剩余生命：170\n" +
                "Jay攻击了Tom,Tom受到了40点伤害,Tom剩余生命：20\n" +
                "Tom攻击了Jay,Jay受到了30点伤害,Jay剩余生命：140\n" +
                "Tom被打败了");
    }


}
