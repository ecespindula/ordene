package go.erick.ordene;

/**
 * Created by erick on 25/11/16.
 */

public class Trocado {
    private int trocado1;
    private int trocado2;
    private boolean flagFim=false;
    private int pivo;

    public Trocado(int trocado1, int trocado2) {
        this.trocado1 = trocado1;
        this.trocado2 = trocado2;
    }

    public boolean isFlagFim() {
        return flagFim;
    }

    public void setFlagFim(boolean flagFim) {
        this.flagFim = flagFim;
    }

    public int getTrocado1() {
        return trocado1;
    }

    public void setTrocado1(int trocado1) {
        this.trocado1 = trocado1;
    }

    public int getTrocado2() {
        return trocado2;
    }

    public void setTrocado2(int trocado2) {
        this.trocado2 = trocado2;
    }

    public int getPivo() {
        return pivo;
    }

    public void setPivo(int pivo) {
        this.pivo = pivo;
    }
}
