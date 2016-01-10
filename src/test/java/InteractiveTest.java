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
    @Test
    public void should_player_getHurt_return_right(){
        Interactive Defeat=new Interactive(fakedOut);
        Defeat.simpleDefeat(Tom,Jay);
        Defeat.say();
        verify(fakedOut).println("Tom被打败了");
    }
}
