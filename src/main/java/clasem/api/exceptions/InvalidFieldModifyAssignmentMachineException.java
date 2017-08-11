package clasem.api.exceptions;

public class InvalidFieldModifyAssignmentMachineException extends ApiException {

    private static final long serialVersionUID = -1344640612384805385L;

    public static final String DESCRIPTION = "";

    public static final int CODE = 22;

    public InvalidFieldModifyAssignmentMachineException() {
        this("");
    }

    public InvalidFieldModifyAssignmentMachineException(String detail) {
        super(DESCRIPTION + "" + detail, CODE);
    }

}