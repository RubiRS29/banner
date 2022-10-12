package kaans.com.app.service.response;


import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@Builder
public class Response {

    private HttpStatus httpStatus;
    private String message;
    private String details;
    private LocalDateTime time;

}
