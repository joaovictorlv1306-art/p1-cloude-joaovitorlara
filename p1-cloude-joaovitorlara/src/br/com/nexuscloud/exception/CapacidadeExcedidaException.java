package br.com.nexuscloud.exception;

// Exceção checked, obriga try-catch ou throws - RA: 25225997-2
public class CapacidadeExcedidaException extends Exception {

    // Envia a mensagem para a superclasse - RA: 25225997-2
    public CapacidadeExcedidaException(String mensagem) {
        super(mensagem);
    }
}