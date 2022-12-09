package exercise;

// BEGIN
public class NegativeRadiusException extends Exception {
    private final String errorCode;

    public NegativeRadiusException(String errorCode) {
        this.errorCode = errorCode;
    }
    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorDescription() {
        return String.format("[%s]: negative radius", this.errorCode);
    }
}
// END
