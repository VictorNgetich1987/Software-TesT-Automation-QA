package Java;

import java.util.UUID;

public class Contact {
    private  final String contactId;//not updatable
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    // Constructor that accepts an explicit contactId (used by your tests)
    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        if (contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException("Contact ID must not be null and max 10 characters");
        }
        this.contactId = contactId;

        validateAndSetFields(firstName, lastName, phone, address);
    }

    // Constructor that auto-generates a contactId 
    public Contact(String firstName, String lastName, String phone, String address) {
        // Generate UUID and take first 10 characters 
        this.contactId = UUID.randomUUID().toString().replace("-", "").substring(0, 10);

        validateAndSetFields(firstName, lastName, phone, address);
    }

    private void validateAndSetFields(String firstName, String lastName, String phone, String address) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("First name must not be null and max 10 characters");
        }
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Last name must not be null and max 10 characters");
        }
        if (phone == null || phone.length() != 10 || !phone.matches("\\d+")) {
            throw new IllegalArgumentException("Phone must be exactly 10 digits");
        }
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address must not be null and max 30 characters");
        }

        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    // Getters
    public String getContactId() {
        return contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    // Setters with validation
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("First name must not be null and max 10 characters");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Last name must not be null and max 10 characters");
        }
        this.lastName = lastName;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if (phone == null || phone.length() != 10 || !phone.matches("\\d+")) {
            throw new IllegalArgumentException("Phone must be exactly 10 digits");
        }
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address must not be null and max 30 characters");
        }
        this.address = address;
    }
}
