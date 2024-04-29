package ada.tech.controle.estoque.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ItemEstoqueNotFoundException {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public static class ItemNotFoundException extends RuntimeException {
    }
}

