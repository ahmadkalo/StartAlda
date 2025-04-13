import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RegistrationControlTest {

    private RegistrationControl control;

    @BeforeEach
    public void setup() {
        control = new RegistrationControl();
    }

    @Test
    public void testRegisterUser_validUser_shouldSucceed() {
        UserDTO user = UserFactory.createNewUserWithNameAndPassword("Anna", "secure123");
        user.setUserID("anna1");
        user.setGebDatum("01.01.2000");
        user.setAddress("anna@mail.de");

        RegistrationResult result = control.registerUser(user);

        assertTrue(result.getResult());
        assertEquals(RegistrationResult.REGISTRATION_SUCCESSFULL, result.getReason());
    }

    @Test
    public void testRegisterUser_missingPassword_shouldFail() {
        UserDTO user = UserFactory.createDefaultUserWithNoPassword();

        RegistrationResult result = control.registerUser(user);

        assertFalse(result.getResult());
        assertEquals(RegistrationResult.PASSWORD_MISSING, result.getReason());
    }

    @Test
    public void testRegisterUser_emptyPasswordAndAddress_shouldFail() {
        UserDTO user = UserFactory.createDefaultUserWithNoPasswordAndNoAddress();

        RegistrationResult result = control.registerUser(user);

        assertFalse(result.getResult());
        assertEquals(RegistrationResult.PASSWORD_MISSING, result.getReason());
    }

    @Test
    public void testRegisterUser_missingUserID_shouldFail() {
        UserDTO user = UserFactory.createNewUserWithNameAndPassword("Max", "pw123");
        user.setGebDatum("01.01.2000");
        user.setAddress("max@mail.de");

        RegistrationResult result = control.registerUser(user);

        assertFalse(result.getResult());
        assertEquals(RegistrationResult.USERID_MISSING, result.getReason());
    }

    @Test
    public void testRegisterUser_missingName_shouldFail() {
        UserDTO user = new UserDTO();
        user.setPassword("pw1234");
        user.setUserID("noname1");
        user.setGebDatum("01.02.2001");
        user.setAddress("unknown@mail.de");

        RegistrationResult result = control.registerUser(user);

        assertFalse(result.getResult());
        assertEquals(RegistrationResult.NAME_MISSING, result.getReason());
    }
}
