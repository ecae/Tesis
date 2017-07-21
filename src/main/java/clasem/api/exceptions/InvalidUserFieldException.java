package clasem.api.exceptions;

public class InvalidUserFieldException extends ApiException {

    private static final long serialVersionUID = -1344640670884805385L;

    public static final String DESCRIPTION = "campo vacio o inexistente: ";

    public static final int CODE = 2;

    public InvalidUserFieldException() {
        this("");
    }

    public InvalidUserFieldException(String detail) {
        super(DESCRIPTION + "'" + detail+"'", CODE);
    }

}

