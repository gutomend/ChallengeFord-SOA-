package br.com.fiap.autospec_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroResposta> tratarErroValidacao(
            MethodArgumentNotValidException ex) {

        List<String> mensagens = ex
                .getBindingResult()
                .getFieldErrors()
                .stream()
                .map(erro -> erro.getDefaultMessage())
                .toList();

        ErroResposta resposta = new ErroResposta(
                HttpStatus.BAD_REQUEST.value(),
                mensagens
        );

        return ResponseEntity.badRequest().body(resposta);
    }
}