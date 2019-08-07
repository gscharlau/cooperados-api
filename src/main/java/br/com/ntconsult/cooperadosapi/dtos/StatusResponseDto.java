package br.com.ntconsult.cooperadosapi.dtos;

import br.com.ntconsult.cooperadosapi.enuns.SituacaoCooperado;

public class StatusResponseDto {

    private SituacaoCooperado status;

    public StatusResponseDto() {
    }

    public StatusResponseDto(SituacaoCooperado status) {
        this.status = status;
    }

    public SituacaoCooperado getStatus() {
        return status;
    }

    public void setStatus(SituacaoCooperado status) {
        this.status = status;
    }

}
