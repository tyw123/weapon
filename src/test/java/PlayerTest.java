import org.junit.Test;

import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by tyw on 16-1-10.
 */
public class PlayerTest {
    PrintStream fakedOut = mock(PrintStream.class);
    Player Tom=new Player("Tom",100,30,fakedOut);
    Player Jay=new Player("Jay",200,40, fakedOut);
    @Test
    public void should_player_getHurt_return_right(){
        Tom.getHurt(Jay);
        assertThat(Tom.getBlood(),is(60));
    }
    @Test
    public void should_player_goDie_return_right(){
        Tom.getHurt(Jay);Tom.getHurt(Jay);Tom.getHurt(Jay);
        Tom.say();
        verify(fakedOut).println("Tom被打败了");
    }
    @Test
    public void should_player_getHurt_farther_test_return_right(){
        Tom.getHurt(Jay);
        Tom.say();
        verify(fakedOut).println("Jay攻击了Tom,Tom受到了40点伤害,Tom剩余生命：60");
    }
}
