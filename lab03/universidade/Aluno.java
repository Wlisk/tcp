package universidade;

public class Aluno {
    private int numeroMatricula;
    private double indiceDesempenho;

    public static final int DEFAULT_MATRICULA = 0;
    public static final double MAX_INDICE_DESEMPENHO = 10.0f;
    public static final double MIN_INDICE_DESEMPENHO = 0.0f;

    public Aluno() {
        this.numeroMatricula = DEFAULT_MATRICULA;
        this.indiceDesempenho = MIN_INDICE_DESEMPENHO;
    }

    public Aluno(int numeroMatricula, double indiceDesempenho) {
        if(numeroMatricula < 0) throw new Error("Número de matricula não deve ser menor que 0. Número inserido: " + numeroMatricula);

        this.numeroMatricula = numeroMatricula;
        this.indiceDesempenho = indiceDesempenho;
    }

    public int getNumeroMatricula() { return this.numeroMatricula; }
    public double getIndiceDesempenho() { return this.indiceDesempenho; }

    public boolean setNumeroMatricula(int numeroMatricula) {
        if(numeroMatricula < 0) return false;

        this.numeroMatricula = numeroMatricula;
        return true;
    }
    public void setIndiceDesempenho(double indiceDesempenho) {
        this.indiceDesempenho = indiceDesempenho;
    }

    public boolean aumentaIndiceDesempenho(double indiceDesempenho) {
        if(this.indiceDesempenho == MAX_INDICE_DESEMPENHO) return false;

        this.indiceDesempenho += indiceDesempenho;

        if(this.indiceDesempenho > MAX_INDICE_DESEMPENHO) 
            this.indiceDesempenho = MAX_INDICE_DESEMPENHO;

        return true;
    }

    public boolean diminuiIndiceDesempenho(double indiceDesempenho) {
        if(this.indiceDesempenho == MIN_INDICE_DESEMPENHO) return false;

        this.indiceDesempenho -= indiceDesempenho;

        if(this.indiceDesempenho < MIN_INDICE_DESEMPENHO)
            this.indiceDesempenho = MIN_INDICE_DESEMPENHO;

        return true;
    }

    public void imprime() {
        System.out.println( String.format("Matricula %08d com %.1f de desempenho.", this.numeroMatricula, this.indiceDesempenho) );
    }
}