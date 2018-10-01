package application.result;

import lombok.Data;

@Data
public class JSONResult<T> {
    String status;
    String message;
    T data;

    public JSONResult() {
        this.status = "Ok";
        this.message = "Success!";
    }
}