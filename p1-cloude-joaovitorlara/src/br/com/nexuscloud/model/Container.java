package br.com.nexuscloud.model;

import java.util.Objects;

// Aplicação que roda no servidor - RA: 25225997-2
public class Container {
    // Atributos privados (encapsulamento) - RA: 25225997-2
    private String id;
    private double ramNecessaria;

    // Construtor - RA: 25225997-2
    public Container(String id, double ramNecessaria) {
        this.id = id;
        this.ramNecessaria = ramNecessaria;
    }

    // Getters e setters - RA: 25225997-2
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public double getRamNecessaria() { return ramNecessaria; }
    public void setRamNecessaria(double ramNecessaria) { this.ramNecessaria = ramNecessaria; }

    // Igualdade pelo ID - RA: 25225997-2
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // mesma referência
        if (o == null || getClass() != o.getClass()) return false; // nulo ou outra classe
        return Objects.equals(id, ((Container) o).id); // compara o ID
    }

    // hashCode com o mesmo campo do equals - RA: 25225997-2
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}