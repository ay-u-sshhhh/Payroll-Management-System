package common;

public class Response<T> {
    private String message;
    private T data;

    // Constructors
    public Response() {
    }

    public Response(String message) {
        this.message = message;
    }

    public Response(String message, T data) {
        this.message = message;
        this.data = data;
    }

    // Getters and setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
