package br.com.ntconsult.cooperadosapi.service;

import br.com.ntconsult.cooperadosapi.entities.Cooperado;

import java.util.Optional;

public interface CooperadoService {

    /**
     * Retorna um cooperado dado um CPF
     * @param cpf
     * @return Optional<Cooperado>
     */
    Optional<Cooperado> buscarPorCpf(String cpf);
}
