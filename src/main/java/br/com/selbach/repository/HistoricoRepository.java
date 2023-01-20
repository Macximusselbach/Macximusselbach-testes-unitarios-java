package br.com.selbach.repository;

import br.com.selbach.domain.Chamada;
import br.com.selbach.domain.HistoricoChamadas;

import java.util.ArrayList;
import java.util.List;

public class HistoricoRepository {

    private List<HistoricoChamadas> historicoChamadaAlunos = new ArrayList<>();

    public void salvar(Chamada chamada){
        var historicoChamada = new HistoricoChamadas(chamada.getAluno(), chamada);
        historicoChamadaAlunos.add(historicoChamada);

    }

}
