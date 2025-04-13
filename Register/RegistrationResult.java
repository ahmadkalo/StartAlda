public class RegistrationResult {

    // Zustände, die in diesem Prototypen verwendet werden
	public final static String PASSWORD_MISSING = "passmissing"; 
	public final static String REGISTRATION_SUCCESSFULL = "ok";
	public final static String USERID_MISSING = "useridmissing";
	public final static String NAME_MISSING = "namemissing";

    // Noch nicht verwendet, aber für zukünftige Zwecke
    public final static String EMAIL_ALREADY_EXISTS = "mail";
	
	private boolean result;
	
	private String reason;

	public boolean getResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public String getReason() {
		return reason;
	}

	/**
	 * Setzen eines Grunds für die fehlerhafte Registrierung.
	 * Wie könnte man diese Methode sinnvoll erweitern? ToDo
	 *
	 * @param reason
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	

}
