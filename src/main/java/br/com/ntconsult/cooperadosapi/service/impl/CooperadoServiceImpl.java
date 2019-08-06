package br.com.ntconsult.cooperadosapi.service.impl;

import br.com.ntconsult.cooperadosapi.entities.Cooperado;
import br.com.ntconsult.cooperadosapi.repository.CooperadoRepository;
import br.com.ntconsult.cooperadosapi.service.CooperadoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CooperadoServiceImpl implements CooperadoService {

    private static final Logger log = LoggerFactory.getLogger(CooperadoServiceImpl.class);

    @Autowired
    private CooperadoRepository cooperadoRepository;

    @Override
    public Optional<Cooperado> buscarPorCpf(String cpf) {
        return Optional.empty();
    }
}
