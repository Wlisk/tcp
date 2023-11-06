package universidade;

public class Monitor {
    private int semestreAtual;
    private boolean temExperiencia;

    private static final int MAX_NUM_YEAR_COLLEGE = 5;
    private static final int MAX_NUM_SEMESTRES = MAX_NUM_YEAR_COLLEGE / 2;

    public Monitor() {
        this.semestreAtual = 0;
        this.temExperiencia = false;
    }

    public Monitor(int semestreAtual, boolean temExperiencia) {
        if(semestreAtual < 0) throw new Error("Semestre atual não pode ser menor que zero.");

        this.semestreAtual = semestreAtual;
        this.temExperiencia = temExperiencia;
    }

    public boolean setSemestreAtual(int semestreAtual) { 
        if(semestreAtual < 0 || semestreAtual > MAX_NUM_SEMESTRES) return false;

        this.semestreAtual = semestreAtual; 
        return true;
    }
    public void setTemExperiencia(boolean temExperiencia) { this.temExperiencia = temExperiencia; }

    public int getSemestreAtual() { return this.semestreAtual; }
    public boolean getTemExperiencia() { return this.temExperiencia; }
}