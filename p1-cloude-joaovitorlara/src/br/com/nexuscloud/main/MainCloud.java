package br.com.nexuscloud.main;

import br.com.nexuscloud.exception.CapacidadeExcedidaException;
import br.com.nexuscloud.model.Cliente;
import br.com.nexuscloud.model.Container;
import br.com.nexuscloud.model.Servidor;
import br.com.nexuscloud.service.CloudManager;

public class MainCloud {
    // throws por causa da exceção checked - RA: 25225997-2
    public static void main(String[] args) throws CapacidadeExcedidaException {
        // 1. Cria o manager - RA: 25225997-2
        CloudManager manager = new CloudManager();

        // 2. Cria o cliente - RA: 25225997-2
        Cliente cliente = new Cliente("111.222.333-44", "Wayne Enterprises");

        // 3. Cria o servidor (nasce desligado) - RA: 25225997-2
        Servidor servidor = new Servidor("192.168.0.1", 16.0, 5.50);

        // 4. Registra o cliente e adiciona o servidor - RA: 25225997-2
        manager.registrarCliente(cliente);
        manager.adicionarServidor(cliente, servidor);

        // 5. Cria os containers - RA: 25225997-2
        Container c1 = new Container("C-01", 10.0);
        Container c2 = new Container("C-02", 8.0);

        // 6. Teste unchecked (servidor desligado).
        // Descomentar para testar e comentar depois - RA: 25225997-2
        // servidor.alocarContainer(c1);

        // 7. Liga o servidor - RA: 25225997-2
        servidor.ligar();

        // 8. Aloca o container 1 (10.0 de 16.0) - RA: 25225997-2
        servidor.alocarContainer(c1);

        // 9. Teste checked: 10.0 + 8.0 = 18.0 > 16.0, cai no catch - RA: 25225997-2
        try {
            servidor.alocarContainer(c2);
        } catch (CapacidadeExcedidaException e) {
            System.out.println("Erro tratado: " + e.getMessage());
        }

        // 10. Fatura ativa, esperado 5.5 - RA: 25225997-2
        System.out.println("Fatura ativa: R$ " + manager.calcularFaturaAtiva(cliente));
    }
}