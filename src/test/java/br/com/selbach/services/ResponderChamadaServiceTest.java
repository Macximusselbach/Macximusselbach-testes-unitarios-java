package br.com.selbach.services;

import br.com.selbach.TestBase;
import br.com.selbach.domain.Aluno;
import br.com.selbach.domain.Chamada;
import br.com.selbach.domain.HistoricoChamadas;
import br.com.selbach.domain.Mensagens;
import br.com.selbach.exceptions.ValidacaoException;
import br.com.selbach.repository.ChamadaRepository;
import br.com.selbach.repository.HistoricoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;

import java.time.LocalDate;

class ResponderChamadaServiceTest extends TestBase {

    Chamada chamada;

    Aluno aluno;

    @Spy
    HistoricoChamadas historicoChamadaAluno;

    @Mock
    ChamadaRepository chamadaRepository;

    @Mock
    HistoricoRepository historicoRepository;

    @InjectMocks
    ResponderChamadaService responderChamadaService;

    @BeforeEach
    public void setUp(){
        aluno = new Aluno();
        aluno.setNome("Max");
        aluno.setStatusMatricula(false);
        chamada = new Chamada();
        chamada.setAluno(aluno);
        chamada.setData(LocalDate.now());
        historicoChamadaAluno.setChamada(chamada);
        historicoChamadaAluno.setAluno(aluno);
    }

    @Test()
    void verificaAlunoNaoMatriculado(){
        var validacao = Assertions.assertThrows(
                ValidacaoException.class,
                ()-> responderChamadaService.apply(chamada)
        );

        Assertions.assertEquals(Mensagens.ALUNO_NAO_MATRICULADO.getMensagem(), validacao.getMessage());
    }

    @Test
    void verificaDataChamadaInvalida(){
        aluno.setStatusMatricula(true);
        chamada.setAluno(aluno);
        chamada.setData(LocalDate.now().plusDays(1));
        var validacao = Assertions.assertThrows(
                ValidacaoException.class,
                ()-> responderChamadaService.apply(chamada)
        );

        Assertions.assertEquals(Mensagens.REGISTRO_EM_DATA_FUTURA.getMensagem(), validacao.getMessage());

    }

    @Test
    void alunoSalvoComSucesso() throws ValidacaoException {
        aluno.setStatusMatricula(true);
        chamada.setAluno(aluno);
        Mockito.when(chamadaRepository.salvar(chamada)).thenReturn(chamada);
        var result = responderChamadaService.apply(chamada);

        Mockito.verify(historicoRepository).salvar(chamada);

        Assertions.assertEquals(chamada.getData(), result.getData());
    }



}