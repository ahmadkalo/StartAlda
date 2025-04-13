public class RegistrationControl {


	public RegistrationResult registerUser(UserDTO dto) {
		RegistrationResult result = new RegistrationResult();

		//TODO
		//E-Mail-Adresse mit der Datenbank überprüfen
		// CheckOnDB(mailAddress) --> Check Existenz über eine DAO (z.B. UserDAO)
		String mailAddress = dto.getAddress();

		if (dto.getPassword() == null || dto.getPassword().isEmpty()) {
			result.setReason(RegistrationResult.PASSWORD_MISSING);
			result.setResult(false);
		} else if (dto.getUserID() == null || dto.getUserID().isEmpty()) {
			result.setReason(RegistrationResult.USERID_MISSING);
			result.setResult(false);
		} else if (dto.getName() == null || dto.getName().isEmpty()) {
			result.setReason(RegistrationResult.NAME_MISSING);
			result.setResult(false);
		} else {

			result.setReason(RegistrationResult.REGISTRATION_SUCCESSFULL);
			result.setResult(true);
		}

		return result;
	}





}
