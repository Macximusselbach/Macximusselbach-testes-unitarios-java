package br.com.selbach.domain;

import br.com.selbach.exceptions.ValidacaoException;

import java.util.List;

public class Aluno {
    private String nome;
    private boolean statusMatricula;

    private List<Chamada> historicoPresenca;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isStatusMatricula() {
        return statusMatricula;
    }

    public void setStatusMatricula(boolean statusMatricula) {
        this.statusMatricula = statusMatricula;
    }

    public List<Chamada> getHistoricoPresenca() {
        return historicoPresenca;
    }

    public void setHistoricoPresenca(List<Chamada> historicoPresenca) {
        this.historicoPresenca = historicoPresenca;
    }

    public void verificaAlunoMatriculado() throws ValidacaoException {
        if(!this.statusMatricula){
            throw new ValidacaoException(Mensagens.ALUNO_NAO_MATRICULADO.getMensagem());
        }

    }
}
