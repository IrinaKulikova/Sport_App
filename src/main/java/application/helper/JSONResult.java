package application.helper;

import lombok.Data;

@Data
public abstract class JSONResult<T> {
    String status;
    String message;
    T data;
}
