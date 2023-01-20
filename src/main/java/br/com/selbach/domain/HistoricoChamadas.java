package br.com.selbach.domain;

public class HistoricoChamadas {

    private Aluno aluno;

    private Chamada chamada;

    public HistoricoChamadas() {
    }

    public HistoricoChamadas(Aluno aluno, Chamada chamada) {
        this.aluno = aluno;
        this.chamada = chamada;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Chamada getChamada() {
        return chamada;
    }

    public void setChamada(Chamada chamada) {
        this.chamada = chamada;
    }
}
