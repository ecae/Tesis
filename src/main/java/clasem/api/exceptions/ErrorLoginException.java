package clasem.api.exceptions;

public class ErrorLoginException extends ApiException {

    private static final long serialVersionUID = -1344640670884805385L;

    public static final String DESCRIPTION = "Usuario no se encuentra registrado.";

    public static final int CODE = 2;

    public ErrorLoginException() {
        this("");
    }

    public ErrorLoginException(String detail) {
        super(DESCRIPTION + "'" + detail+"'", CODE);
    }
}
