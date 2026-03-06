package br.saks.register_services.exceptions;

import lombok.Getter;

@Getter
public class ApiException extends RuntimeException{

    private final String code;


    public ApiException(String message, String code) {
        super(message);
        this.code = code;
    }

    public ApiException(String message, String code, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

}
