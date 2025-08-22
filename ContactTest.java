package Test;

import static org.junit.jupiter.api.Assertions.*;

import Java.Contact;
import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    public void testContactCreationValid() {
        Contact contact = new Contact("C01", "John", "Doe", "1234567890", "123 Main St");
        assertEquals("C01", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    @Test
    public void testInvalidContactIdTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("TOO_LONG_ID", "John", "Doe", "1234567890", "123 Main St");
        });
    }

    @Test
    public void testInvalidPhoneLength() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("C02", "John", "Doe", "12345", "123 Main St");
        });
    }

    @Test
    public void testInvalidPhoneNonDigits() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("C03", "John", "Doe", "12345abcd9", "123 Main St");
        });
    }

    @Test
    public void testUpdateFieldsValid() {
        Contact contact = new Contact("C04", "Jane", "Smith", "1112223333", "456 Elm St");

        contact.setFirstName("Janet");
        contact.setLastName("Doe");
        contact.setPhone("9998887777");
        contact.setAddress("New Address");

        assertEquals("Janet", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("9998887777", contact.getPhone());
        assertEquals("New Address", contact.getAddress());
    }

    @Test
    public void testSetFirstNameInvalid() {
        Contact contact = new Contact("C05", "Jane", "Smith", "1112223333", "456 Elm St");
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName("ThisNameIsWayTooLong"));
    }

    @Test
    public void testSetLastNameInvalid() {
        Contact contact = new Contact("C01", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName(null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName("ThisIsLongerThan10Chars");
        });
    }


    @Test
    public void testSetPhoneInvalid() {
        Contact contact = new Contact("C07", "Jane", "Smith", "1112223333", "456 Elm St");
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone("abc1234567"));
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone("123"));
    }

    @Test
    public void testSetAddressInvalid() {
        Contact contact = new Contact("C08", "Jane", "Smith", "1112223333", "456 Elm St");
        assertThrows(IllegalArgumentException.class, () -> contact.setAddress(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setAddress("This address is way too long to be accepted by the validation logic."));
    }
}
