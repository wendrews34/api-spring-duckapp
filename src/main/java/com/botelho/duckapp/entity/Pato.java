package com.botelho.duckapp.entity;

import com.botelho.duckapp.enums.StatusPato;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Pato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String raca;
    private int idade;
    private String sexo;
    private StatusPato status;
    private String mae;

    public Pato() {
        // Construtor vazio necessário para JPA
    }

    public Pato(String nome, String raca, int idade, String sexo, StatusPato status, String mae) {
        this.nome = nome;
        this.raca = raca;
        this.idade = idade;
        this.sexo = sexo;
        this.status = status;
        this.mae = mae;
    }

    public Pato(Long id, String nome, String raca, int idade, String sexo, StatusPato status, String mae) {
        this.id = id;
        this.nome = nome;
        this.raca = raca;
        this.idade = idade;
        this.sexo = sexo;
        this.status = status;
        this.mae = mae;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public StatusPato getStatus() {
        return status;
    }

    public void setStatus(StatusPato status) {
        this.status = status;
    }

    public String getMae() {
        return mae;
    }

    public void setMae(String mae) {
        this.mae = mae;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pato pato = (Pato) o;
        return Objects.equals(id, pato.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Pato{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", raca='" + raca + '\'' +
                ", idade=" + idade +
                ", sexo='" + sexo + '\'' +
                ", status=" + status +
                ", mae='" + mae + '\'' +
                '}';
    }
}
