package clasem.api.exceptions;

public class NotFoundRolException extends ApiException{


    private static final long serialVersionUID = -1344640670884805385L;

    public static final String DESCRIPTION = "Campo Rol vacio o inexistente ";

    public static final int CODE = 4;

    public NotFoundRolException() {
        this("");
    }

    public NotFoundRolException(String detail) {
        super(DESCRIPTION + ". " + detail, CODE);
    }
}
