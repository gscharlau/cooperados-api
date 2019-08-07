package br.com.ntconsult.cooperadosapi.controllers;

import br.com.ntconsult.cooperadosapi.entities.Cooperado;
import br.com.ntconsult.cooperadosapi.enuns.SituacaoCooperado;
import br.com.ntconsult.cooperadosapi.service.CooperadoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class CooperadoControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    private CooperadoService cooperadoService;

    private static final String URL_ENDPOINT = "/users/";
    private static final String CPF_ABLE = "41449059422";
    private static final String CPF_UNABLE = "1234567890";

    @Test
    public void validarInscricaoCooperadoComCpfValido() throws Exception {
        BDDMockito.given(this.cooperadoService.buscarPorCpf(Mockito.anyString()))
                .willReturn(Optional.of(Cooperado.CooperadoBuilder.aCooperado().build()));

        mvc.perform(MockMvcRequestBuilders.get(URL_ENDPOINT + CPF_ABLE)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.status").value(SituacaoCooperado.ABLE_TO_VOTE.toString()))
                .andExpect(jsonPath("$.errors").isEmpty());
    }

    @Test
    public void validarInscricaoCooperadoComCpfInvalido() throws Exception {
        BDDMockito.given(this.cooperadoService.buscarPorCpf(Mockito.anyString()))
                .willReturn(Optional.empty());

        mvc.perform(MockMvcRequestBuilders.get(URL_ENDPOINT + CPF_UNABLE)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.status").value(SituacaoCooperado.UNABLE_TO_VOTE.toString()))
                .andExpect(jsonPath("$.errors").isEmpty());
    }


}