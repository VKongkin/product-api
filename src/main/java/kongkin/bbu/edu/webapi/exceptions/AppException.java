package kongkin.bbu.edu.webapi.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppException extends Exception{
    private String code;
    private String message;
    private String messageKH;

    public AppException() {
        super();
    }

    public AppException(String code,String message,   String messageKH) {
        super(message);
        this.code = code;
        this.message = message;
        this.messageKH = messageKH;
    }
}
