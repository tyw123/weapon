import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by tyw on 16-1-10.
 */
public class NormalPlayerTest  {
    PrintStream fakedOut = mock(PrintStream.class);
    Solider 张三=new Solider("张三",100,30,fakedOut);
    NormalPlayer 李四=new NormalPlayer("李四",100,30,fakedOut);
    NormalPlayer Lucy=new NormalPlayer("Lucy",100,30,fakedOut);
    @Test
    public void should_normalPlayer_getHurt_normalplayer_return_right(){
        张三.setWeapon(new Weapon("优质木棒",33));
        张三.setArmor(new Armor("遮阳伞",12));
        李四.getHurt(张三);
        李四.say();
        verify(fakedOut).println("战士张三用优质木棒攻击了普通人李四,李四受到了63点伤害,李四剩余生命：37");
    }
    @Test
    public void should_normalPlayer_getHurt_normalPlayer_return_right(){
        李四.getHurt(Lucy);
        李四.say();
        verify(fakedOut).println("普通人Lucy攻击了普通人李四,李四受到了30点伤害,李四剩余生命：70");
    }

}
