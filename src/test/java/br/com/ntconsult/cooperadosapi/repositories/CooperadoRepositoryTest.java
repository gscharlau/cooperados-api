package br.com.ntconsult.cooperadosapi.repositories;

import br.com.ntconsult.cooperadosapi.entities.Cooperado;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class CooperadoRepositoryTest {

    @Autowired
    private CooperadoRepository cooperadoRepository;
    private static final String CPF = "83134764270";

    @Before
    public void setUp() throws Exception {
        Cooperado cooperado = Cooperado.CooperadoBuilder.aCooperado().withId(0L).withCpf(CPF).withNome("Cooperado 001").build();
        this.cooperadoRepository.save(cooperado);
    }

    @After
    public void tearDown() throws Exception {
        this.cooperadoRepository.deleteAll();
    }

    @Test
    public void findByCpf() {
        Cooperado cooperado = this.cooperadoRepository.findByCpf(CPF);
        assertEquals(CPF,cooperado.getCpf());
    }
}