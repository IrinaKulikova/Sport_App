package application.helper;


public class JSONResultError<T> extends JSONResult<T> {

    public JSONResultError(T data, String msg) {
        this.status = "Error";
        this.message = msg;
        this.data = data;
    }
}
