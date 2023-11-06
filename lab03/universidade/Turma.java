package universidade;

import java.util.ArrayList;

public class Turma {
    private int numAlunos;
    private int numMonitores;
    private Professor professor;
    private ArrayList<Monitor> monitores;
    private ArrayList<Aluno> alunos;

    public static final int MAX_NUM_ALUNOS = 40;
    public static final int MIN_NUM_ALUNOS = 10;
    public static final int MAX_NUM_MONITORES = 3;
    public static final int MIN_NUM_MONITORES = 0;

    public Turma() {
        this.numAlunos = 0;
        this.numMonitores = 0;
        this.professor = null;
        this.monitores = null;
        this.alunos = new ArrayList<Aluno>();
    }

    public Turma(Professor professor, ArrayList<Monitor> monitores, ArrayList<Aluno> alunos) {
        if(!setProfessor(professor)) throw new Error("A turma não pode ficar sem professor!");

        if(!setMonitores(monitores)) throw new Error("Número de monitores para a turma maior ou menor do que o permitido.");

        if(!setAlunos(alunos)) throw new Error("Número de alunos para a turma maior ou menor do que o permitido.");

        this.numAlunos = alunos.size();
        this.numMonitores = monitores.size();
        this.professor = professor;
        this.monitores = monitores;
        this.alunos = alunos;
    }

    public boolean adicionaAluno(Aluno aluno) {
        if(aluno == null || alunos.size() == MAX_NUM_ALUNOS) return false;

        this.alunos.add(aluno);
        return true;
    }

    public boolean removeAluno() {
        final int removeIndex = this.alunos.size() - 1;

        if(this.alunos.isEmpty() || alunos.size() == MIN_NUM_ALUNOS) return false;

        this.alunos.remove(removeIndex);
        return true;
    }

    public void imprimeAlunos() {
        alunos.forEach((aluno) -> aluno.imprime());
        /* equivalente a: for(int i = 0; i < alunos.size(); ++i) alunos.get(i).imprime(); */
    }

    public int getNumAlunos() { return this.numAlunos; }
    public int getNumMonitores() { return this.numMonitores; }
    public Professor getProfessor() { return this.professor; }
    public ArrayList<Aluno> getAlunos() { return this.alunos; }
    public ArrayList<Monitor> getMonitores() { return this.monitores; }

    public boolean setProfessor(Professor professor) {
        if(professor == null) return false;

        this.professor = professor;
        return true;
    }

    public boolean setMonitores(ArrayList<Monitor> monitores) {
        if(monitores.size() < MIN_NUM_MONITORES || monitores.size() > MAX_NUM_MONITORES) return false;

        this.monitores = monitores;
        return true;
    }

    public boolean setAlunos(ArrayList<Aluno> alunos) {
        if(alunos.size() < MIN_NUM_ALUNOS || alunos.size() > MAX_NUM_ALUNOS) return false;

        this.alunos = alunos;
        return true;
    }
}