package clasem.api.exceptions;

public class InvalidImageException extends ApiException {

    private static final long serialVersionUID = -1344640612384805385L;

    public static final String DESCRIPTION = "";

    public static final int CODE = 22;

    public InvalidImageException() {
        this("");
    }

    public InvalidImageException(String detail) {
        super(DESCRIPTION + "" + detail, CODE);
    }

}