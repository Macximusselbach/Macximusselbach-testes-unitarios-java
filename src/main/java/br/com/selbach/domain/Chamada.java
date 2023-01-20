package br.com.selbach.domain;

import br.com.selbach.domain.Aluno;
import br.com.selbach.exceptions.ValidacaoException;

import java.time.LocalDate;

public class Chamada {

    private Aluno aluno;
    private boolean presente;
    private LocalDate data;

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public boolean estaPresente() {
        return presente;
    }

    public void setPresente(boolean presente) {
        this.presente = presente;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void validaDataFutura() throws ValidacaoException {
        if (this.data.isAfter(LocalDate.now())) {
            throw new ValidacaoException(Mensagens.REGISTRO_EM_DATA_FUTURA.getMensagem());

        }
    }
}