package clasem.api.exceptions;

public class ApiException extends Exception {

    private static final long serialVersionUID = 1613504205825647750L;

    public ApiException(String description, int code) {
        super(description);
    }


}
