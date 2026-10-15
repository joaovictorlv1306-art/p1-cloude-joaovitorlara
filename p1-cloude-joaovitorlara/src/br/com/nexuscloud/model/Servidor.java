package br.com.nexuscloud.model;

import br.com.nexuscloud.exception.CapacidadeExcedidaException;
import br.com.nexuscloud.exception.ServidorOfflineException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Servidor que hospeda containers - RA: 25225997-2
public class Servidor {
    // Atributos privados (encapsulamento) - RA: 25225997-2
    private String ip;
    private double ramTotal;
    private double precoPorHora;

    // Começa desligado - RA: 25225997-2
    private boolean statusLigado = false;

    // Inicializada na declaração para evitar NullPointerException - RA: 25225997-2
    private List<Container> containers = new ArrayList<>();

    // Construtor (status e lista já têm valor inicial) - RA: 25225997-2
    public Servidor(String ip, double ramTotal, double precoPorHora) {
        this.ip = ip;
        this.ramTotal = ramTotal;
        this.precoPorHora = precoPorHora;
    }

    // Liga o servidor - RA: 25225997-2
    public void ligar() {
        this.statusLigado = true;
    }

    // Soma a RAM dos containers usando Stream - RA: 25225997-2
    public double calcularRamEmUso() {
        return containers.stream()
                .mapToDouble(Container::getRamNecessaria) // extrai a RAM
                .sum(); // soma total
    }

    // Valida antes de adicionar (Fail-Fast) - RA: 25225997-2
    public void alocarContainer(Container c) throws CapacidadeExcedidaException {
        // Servidor desligado: lança a unchecked - RA: 25225997-2
        if (!statusLigado) {
            throw new ServidorOfflineException(
                "Erro: Não é possível alocar containers em um servidor desligado.");
        }
        // RAM insuficiente: lança a checked - RA: 25225997-2
        if (calcularRamEmUso() + c.getRamNecessaria() > ramTotal) {
            throw new CapacidadeExcedidaException(
                "Falha Crítica: Memória RAM insuficiente no servidor " + ip + ".");
        }
        // Validações ok, adiciona - RA: 25225997-2
        containers.add(c);
    }

    // Getters e setters - RA: 25225997-2
    public String getIp() { return ip; }
    public void setIp(String ip) { this.ip = ip; }
    public double getRamTotal() { return ramTotal; }
    public void setRamTotal(double ramTotal) { this.ramTotal = ramTotal; }
    public double getPrecoPorHora() { return precoPorHora; }
    public void setPrecoPorHora(double precoPorHora) { this.precoPorHora = precoPorHora; }
    public boolean isStatusLigado() { return statusLigado; }
    public List<Container> getContainers() { return containers; }

    // Igualdade pelo IP - RA: 25225997-2
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // mesma referência
        if (o == null || getClass() != o.getClass()) return false; // nulo ou outra classe
        return Objects.equals(ip, ((Servidor) o).ip); // compara o IP
    }

    // hashCode com o mesmo campo do equals - RA: 25225997-2
    @Override
    public int hashCode() {
        return Objects.hash(ip);
    }
}