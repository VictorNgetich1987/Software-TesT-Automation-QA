package Java;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ContactService {
    private final Map<String, Contact> contacts = new HashMap<>();

    // Add a Contact object that already has an ID 
    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null");
        }
        String contactId = contact.getContactId();
        if (contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException("Invalid contact ID");
        }
        if (contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Duplicate contact ID");
        }
        contacts.put(contactId, contact);
    }

    // Add contact with auto-generated unique ID 
    public Contact addContact(String firstName, String lastName, String phone, String address) {
        String contactId;
        do {
            contactId = UUID.randomUUID().toString().replace("-", "").substring(0, 10);
        } while (contacts.containsKey(contactId));  // Ensure uniqueness

        Contact contact = new Contact(contactId, firstName, lastName, phone, address);
        contacts.put(contactId, contact);
        return contact;
    }

    public void deleteContact(String contactId) {
        if (contactId == null || !contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact not found");
        }
        contacts.remove(contactId);
    }

    public void updateFirstName(String contactId, String firstName) {
        Contact contact = getContact(contactId);
        contact.setFirstName(firstName);
    }

    public void updateLastName(String contactId, String lastName) {
        Contact contact = getContact(contactId);
        contact.setLastName(lastName);
    }

    public void updatePhone(String contactId, String phone) {
        Contact contact = getContact(contactId);
        contact.setPhone(phone);
    }

    public void updateAddress(String contactId, String address) {
        Contact contact = getContact(contactId);
        contact.setAddress(address);
    }

    public Contact getContact(String contactId) {
        if (contactId == null || !contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact not found");
        }
        return contacts.get(contactId);
    }
}
