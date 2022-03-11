package demo.controller.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AnyException extends Exception{
    private String message;
}
