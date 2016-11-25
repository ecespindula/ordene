package go.erick.ordene;

/**
 * Created by erick on 25/11/16.
 */

public class Troca {
    private int troca1;
    private int troca2;
    public Troca(){
        this.troca1=-1;
        this.troca2=-1;
    }

    private void setTroca1(int troca1){
        this.troca1 = troca1;
    }

    private void setTroca2(int troca2){
        this.troca2 = troca2;
    }

    public boolean insere(int troca){
        if(troca1<0){
            setTroca1(troca);
            return false;
        }else if(troca2<0){
            setTroca2(troca);
            return true;
        }else{
            return true;
        }
    }

    public void reseta(){
        setTroca1(-1);
        setTroca2(-1);
    }

    public int getTroca1() {
        return troca1;
    }

    public int getTroca2() {
        return troca2;
    }
}
