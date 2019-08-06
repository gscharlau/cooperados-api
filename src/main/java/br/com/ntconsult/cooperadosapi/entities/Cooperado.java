package br.com.ntconsult.cooperadosapi.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cooperado")
public class Cooperado implements Serializable {

    private Long id;
    private String cpf;
    private String nome;

    public Cooperado() {
    }

    public Cooperado(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "cpf", nullable = false)
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Column(name = "nome", nullable = false)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Cooperados [id=" + id + ", cpf=" + cpf + ", nome='" + nome + "]";
    }

    public static final class CooperadoBuilder {
        private Long id;
        private String cpf;
        private String nome;

        private CooperadoBuilder() {
        }

        public static CooperadoBuilder aCooperado() {
            return new CooperadoBuilder();
        }

        public CooperadoBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public CooperadoBuilder withCpf(String cpf) {
            this.cpf = cpf;
            return this;
        }

        public CooperadoBuilder withNome(String nome) {
            this.nome = nome;
            return this;
        }

        public Cooperado build() {
            Cooperado cooperado = new Cooperado();
            cooperado.setId(id);
            cooperado.setCpf(cpf);
            cooperado.setNome(nome);
            return cooperado;
        }
    }
}