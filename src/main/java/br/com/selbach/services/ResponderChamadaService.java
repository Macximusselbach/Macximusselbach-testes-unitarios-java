package br.com.selbach.services;

import br.com.selbach.domain.Chamada;
import br.com.selbach.exceptions.ValidacaoException;
import br.com.selbach.repository.ChamadaRepository;
import br.com.selbach.repository.HistoricoRepository;

public class ResponderChamadaService {

    private ChamadaRepository chamadaRepository;

    private HistoricoRepository historicoRepository;

    public ResponderChamadaService(ChamadaRepository chamadaRepository, HistoricoRepository historicoRepository) {
        this.chamadaRepository = chamadaRepository;
        this.historicoRepository = historicoRepository;
    }

    public Chamada apply(Chamada chamada) throws ValidacaoException {
        chamada.getAluno().verificaAlunoMatriculado();
        chamada.validaDataFutura();

        var chamadaSalva = chamadaRepository.salvar(chamada);
        historicoRepository.salvar(chamada);

        return chamadaSalva;
    }
}
