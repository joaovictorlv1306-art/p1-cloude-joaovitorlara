package br.com.nexuscloud.service;

import br.com.nexuscloud.model.Cliente;
import br.com.nexuscloud.model.Servidor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Banco de dados dos clientes e servidores - RA: 25225997-2
public class CloudManager {
    // HashMap: chave Cliente, valor Set de Servidores (sem repetição e sem ordem) - RA: 25225997-2
    private Map<Cliente, Set<Servidor>> bancoDeDados = new HashMap<>();

    // Registra o cliente com conjunto vazio, se não existir - RA: 25225997-2
    public void registrarCliente(Cliente c) {
        bancoDeDados.putIfAbsent(c, new HashSet<>());
    }

    // Adiciona o servidor ao cliente - RA: 25225997-2
    public void adicionarServidor(Cliente c, Servidor s) {
        bancoDeDados.get(c).add(s);
    }

    // Soma o preço dos servidores ligados usando Stream - RA: 25225997-2
    public double calcularFaturaAtiva(Cliente c) {
        return bancoDeDados.getOrDefault(c, new HashSet<>()) // vazio se não achar
                .stream()
                .filter(Servidor::isStatusLigado) // só os ligados
                .mapToDouble(Servidor::getPrecoPorHora) // extrai o preço
                .sum(); // soma total
    }

    // Getter do banco - RA: 25225997-2
    public Map<Cliente, Set<Servidor>> getBancoDeDados() {
        return bancoDeDados;
    }
}