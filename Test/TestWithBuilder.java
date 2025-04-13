import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestWithBuilder {

    private RegistrationControl control;

    @BeforeEach
    public void setup() {
        control = new RegistrationControl();
    }

    @Test
    public void testRegisterUserWithVariousInputsUsingBuilder() {

        UserDTO validUser = new UserDTOBuilder()
                .withName("Anna")
                .withUserID("anna1")
                .withPassword("pass123")
                .withAddress("anna@mail.de")
                .withGebDatum("01.01.2000")
                .build();

        RegistrationResult result1 = control.registerUser(validUser);
        assertTrue(result1.getResult());
        assertEquals(RegistrationResult.REGISTRATION_SUCCESSFULL, result1.getReason());


        UserDTO missingPassword = new UserDTOBuilder()
                .withName("Max")
                .withUserID("max1")
                .withPassword("")
                .withAddress("max@mail.de")
                .build();

        RegistrationResult result2 = control.registerUser(missingPassword);
        assertFalse(result2.getResult());
        assertEquals(RegistrationResult.PASSWORD_MISSING, result2.getReason());


        UserDTO missingName = new UserDTOBuilder()
                .withUserID("noname1")
                .withPassword("secret123")
                .withAddress("no@mail.de")
                .build();

        RegistrationResult result3 = control.registerUser(missingName);
        assertFalse(result3.getResult());
        assertEquals(RegistrationResult.NAME_MISSING, result3.getReason());


        UserDTO missingUserID = new UserDTOBuilder()
                .withName("Lisa")
                .withPassword("secret123")
                .withAddress("lisa@mail.de")
                .build();

        RegistrationResult result4 = control.registerUser(missingUserID);
        assertFalse(result4.getResult());
        assertEquals(RegistrationResult.USERID_MISSING, result4.getReason());


        UserDTO emptyUser = new UserDTOBuilder().build();

        RegistrationResult result5 = control.registerUser(emptyUser);
        assertFalse(result5.getResult());
        assertEquals(RegistrationResult.PASSWORD_MISSING, result5.getReason());
    }
}
