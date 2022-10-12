package kaans.com.app.service.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ResponseHandler {

    public ResponseEntity<Response> successResponse(String message) {
        Response response =
                new Response(HttpStatus.OK, message, "SUCCESSFUL", LocalDateTime.now());

        return new ResponseEntity<Response>(response, null,HttpStatus.CREATED);
    }

}
