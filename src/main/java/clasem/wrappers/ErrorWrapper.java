package clasem.wrappers;

public class ErrorWrapper {

    String message;
    String field;

    public ErrorWrapper() {
    }

    public ErrorWrapper(String message, String field) {
        this.message = message;
        this.field = field;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    @Override
    public String toString() {
        return "ErrorWrapper{" +
                "message='" + message + '\'' +
                ", field='" + field + '\'' +
                '}';
    }
}
