import java.io.PrintStream;

/**
 * Created by tyw on 16-1-10.
 */
public class Interactive {
    PrintStream printer;
    String status;

    public Interactive(PrintStream printer) {
        this.printer=printer;
    }


    public void simpleDefeat(Player playerA,Player playerB){

        for(int i=0;(playerA.getBlood() > 0) && (playerB.getBlood() > 0);i++)
        {
            playerA.getHurt(playerB);
            if(playerA.getBlood()>0) {
                playerB.getHurt(playerA);
            }//else {status=playerA.goDie();}
            System.out.print(playerB.getBlood()+"b\n");
            System.out.print(playerA.getBlood()+"a\n");
        }
        if(playerA.getBlood()>0){status=playerB.goDie();}
        else {status=playerA.goDie();}
    }

    public void say() {
        printer.println(status);
    }

}
