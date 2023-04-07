package stock.management.api_stock.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity Error404() {
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(StockException.class)
    public ResponseEntity stockException(StockException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
