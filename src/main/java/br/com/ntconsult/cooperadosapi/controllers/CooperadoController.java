package br.com.ntconsult.cooperadosapi.controllers;

import br.com.ntconsult.cooperadosapi.dtos.StatusResponseDto;
import br.com.ntconsult.cooperadosapi.entities.Cooperado;
import br.com.ntconsult.cooperadosapi.enuns.SituacaoCooperado;
import br.com.ntconsult.cooperadosapi.response.Response;
import br.com.ntconsult.cooperadosapi.service.CooperadoService;
import org.hibernate.validator.constraints.br.CPF;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.Optional;

@RestController
@RequestMapping("/users/")
@CrossOrigin(origins = "*")
public class CooperadoController {

    private static final Logger log = LoggerFactory.getLogger(CooperadoController.class);

    @Autowired
    private CooperadoService cooperadoService;

    public CooperadoController() {
    }

    @GetMapping(value = "/{cpf}")
    public ResponseEntity<Response<StatusResponseDto>> validarInscricaoCooperado(
            @PathVariable("cpf")
            @CPF(message = ("CPF inválido"))
            @NotEmpty(message = "CPF é campo obrigatório")
            @Valid String cpf){

        log.info("Consulta de cooperado por CPF: {}", cpf);
        Optional<Cooperado> cooperado = cooperadoService.buscarPorCpf(cpf);
        Response<StatusResponseDto> response = new Response<StatusResponseDto>();

        if(!cooperado.isPresent()){
            log.info("Cooperado não encontrado");
            response.setData(new StatusResponseDto(SituacaoCooperado.UNABLE_TO_VOTE));
        } else {
            response.setData(new StatusResponseDto(SituacaoCooperado.ABLE_TO_VOTE));
        }

        return ResponseEntity.ok(response);
    }

}
