package br.com.ntconsult.cooperadosapi.repository;

import br.com.ntconsult.cooperadosapi.entities.Cooperado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface CooperadoRepository extends JpaRepository<Cooperado, Long> {

    @Transactional(readOnly = true)
    Cooperado findByCpf(Long cpf);

}
