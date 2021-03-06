package clasem.api.exceptions;

public class UnauthorizedException extends ApiException {

    private static final long serialVersionUID = -1344640670884805385L;

    public static final String DESCRIPTION = "La identificación utilizada no tiene la autoridad suficiente";

    public static final int CODE = 5;

    public UnauthorizedException() {
        this("");
    }

    public UnauthorizedException(String detail) {
        super(DESCRIPTION + ". " + detail, CODE);
    }

}
