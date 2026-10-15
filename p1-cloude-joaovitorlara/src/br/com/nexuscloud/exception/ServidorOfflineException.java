package br.com.nexuscloud.exception;

// Exceção unchecked, não precisa de try-catch - RA: 25225997-2
public class ServidorOfflineException extends RuntimeException {

    // Envia a mensagem para a superclasse - RA: 25225997-2
    public ServidorOfflineException(String mensagem) {
        super(mensagem);
    }
}