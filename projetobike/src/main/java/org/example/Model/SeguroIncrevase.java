package org.example.Model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "seguroincrevase")

public class SeguroIncrevase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "sobrenome", nullable = false, length = 100)
    private String sobrenome;

    @Column( name = "cpf", nullable = false, length = 100)
    private String cpf;

    @Column(name = "email", nullable = false, length =100)
    private String email;

    @Column(name = "cep", nullable = false, length = 100)
    private String cep;

    @Column(name ="número", nullable = false, length = 100)
    private String numero;

    @Column(name = "logadouro", nullable = false, length = 100)
    private String logadouro;

    @Column(name = "bairro", nullable = false, length = 100)
    private String bairro;

    @Column(name = "cidade", nullable = false, length = 100)
    private String cidade;

    @Column(name = "estado", nullable = false, length = 100)
    private String estado;

    public enum Role {
        ROLE_ADMIN, ROLE_CLIENTE
    }
    public SeguroIncrevase(String nome, String sobrenome, String cpf, String email, String cep) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.email = email;
        this.cep = cep;
        this.numero = numero;
        this.logadouro = logadouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }
     @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SeguroIncrevase seguroIncrevase = (SeguroIncrevase) o;
        return java.util.Objects.equals(id, seguroIncrevase.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    @Override
        public String toString () {
            return "SeguroIncrevase{" +
                    "id=" + id +
                    '}';
        }

    }