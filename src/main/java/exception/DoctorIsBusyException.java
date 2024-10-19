package exception;

public class DoctorIsBusyException extends RuntimeException {

    public DoctorIsBusyException (String message){
        super(message);
    }
}
