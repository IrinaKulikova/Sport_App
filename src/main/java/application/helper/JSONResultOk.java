package application.helper;


public class JSONResultOk<T> extends JSONResult<T> {

    public JSONResultOk(T data) {
        this.status = "Ok";
        this.message = "Success!";
        this.data = data;
    }
}