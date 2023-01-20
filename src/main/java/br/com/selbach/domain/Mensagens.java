package br.com.selbach.domain;

public enum Mensagens {
    ALUNO_NAO_MATRICULADO("Aluno não está matriculado!"),
    REGISTRO_EM_DATA_FUTURA("Data futura!");

    private String mensagem;

    Mensagens(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
}
