package br.com.nexuscloud.model;

import java.util.Objects;

// Cliente dono dos servidores - RA: 25225997-2
public class Cliente {
    // Atributos privados (encapsulamento) - RA: 25225997-2
    private String cpf;
    private String nome;

    // Construtor - RA: 25225997-2
    public Cliente(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    // Getters e setters - RA: 25225997-2
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    // Igualdade pelo CPF - RA: 25225997-2
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // mesma referência
        if (o == null || getClass() != o.getClass()) return false; // nulo ou outra classe
        return Objects.equals(cpf, ((Cliente) o).cpf); // compara o CPF
    }

    // hashCode com o mesmo campo do equals - RA: 25225997-2
    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }
}