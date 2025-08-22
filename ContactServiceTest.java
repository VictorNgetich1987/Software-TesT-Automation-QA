package Test;

import static org.junit.jupiter.api.Assertions.*;
import Java.Contact;
import Java.ContactService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    private ContactService service;

    @BeforeEach
    public void setUp() {
        service = new ContactService();
    }

    @Test
    public void testAddContact() {
        Contact contact = new Contact("C01", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        assertEquals(contact, service.getContact("C01"));
    }

    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("C02", "Jane", "Smith", "0987654321", "456 Oak Ave");
        service.addContact(contact);
        service.deleteContact("C02");
        assertThrows(IllegalArgumentException.class, () -> service.getContact("C02"));
    }

    @Test
    public void testUpdateContactFields() {
        Contact contact = new Contact("C03", "Mike", "Jordan", "1112223333", "789 Pine Rd");
        service.addContact(contact);

        service.updateFirstName("C03", "Michael");
        service.updateLastName("C03", "Jackson");
        service.updatePhone("C03", "9998887777");
        service.updateAddress("C03", "Updated Address");

        Contact updated = service.getContact("C03");
        assertEquals("Michael", updated.getFirstName());
        assertEquals("Jackson", updated.getLastName());
        assertEquals("9998887777", updated.getPhone());
        assertEquals("Updated Address", updated.getAddress());
    }

    @Test
    public void testAddDuplicateContactThrowsException() {
        Contact c1 = new Contact("C04", "A", "B", "1234567890", "Address");
        Contact c2 = new Contact("C04", "X", "Y", "1234567890", "Other");

        service.addContact(c1);
        assertThrows(IllegalArgumentException.class, () -> service.addContact(c2));
    }
}
