package ra.edu.ptit_cntt2_it211_practice.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

@Data
public class ErrorResponse {
    private int status;
    private String message;
    private LocalDateTime localDateTime;
    private Map<String, String> errors;

    // Lỗi chung 404
    public ErrorResponse(int status, String message){
        this.status = status;
        this.message = message;
        this.localDateTime = LocalDateTime.now();
    }

    public ErrorResponse(int status, String message, Map<String, String> errors){
        this.status = status;
        this.message = message;
        this.localDateTime = LocalDateTime.now();
        this.errors = errors;
    }
}
