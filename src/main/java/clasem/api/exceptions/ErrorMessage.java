package clasem.api.exceptions;

public class ErrorMessage {

    private String error;

    private String description;

    public ErrorMessage() {
    }

    public ErrorMessage(ApiException exception) {
        this(exception.getClass().getSimpleName(), exception.getMessage());
    }

    public ErrorMessage(Exception exception) {
        this(exception.getClass().getSimpleName(), exception.getMessage());
    }



    public ErrorMessage(String error, String description) {
        this.error = error;
        this.description = description;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getError() {
        return error;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "ApiErrorMessage [error=" + error + ", description=" + description + "]";
    }

}

