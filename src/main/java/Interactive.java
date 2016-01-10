import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tyw on 16-1-10.
 */
public class Interactive {
    PrintStream printer;
    String status;
    List<String> statusLog=new ArrayList<String>();
    String log="";

    public Interactive(PrintStream printer) {
        this.printer=printer;

    }


    public void simpleDefeat(Player playerA,Player playerB){

        for(int i=0;(playerA.getBlood() > 0) && (playerB.getBlood() > 0);i++)
        {
            status=playerA.getHurt(playerB);
            if(playerA.getBlood()>0) {
                statusLog.add(status+"\n");
                status=playerB.getHurt(playerA);
                if(playerB.getBlood()>0) {
                    statusLog.add(status + "\n");
                }else {statusLog.add(status);}
            }else {statusLog.add(status);}
//            System.out.print(playerB.getBlood()+"b\n");
//            System.out.print(playerA.getBlood()+"a\n");
        }
//        if(playerA.getBlood()>0){status=playerB.goDie();}
//        else {status=playerA.goDie();}
//        statusLog.add(status);
    }

    public void say() {
        printer.println(status);
    }

    public void sayLog(){
        for(int i=0;i<statusLog.size();i++){log+=statusLog.get(i);}
        printer.println(log);}

}
