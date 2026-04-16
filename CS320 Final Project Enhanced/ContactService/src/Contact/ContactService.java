package Contact;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class ContactService {
    // Define a map to store contacts by setting ID as key,
    // and other values as contact object.
    private Map<String, Contact> contacts;

    // Define a zero parameterized constructor to initialize
    // contacts map
    public ContactService() {
        contacts = new HashMap<>();
    }

    // The getContact() method to retrieve the contact.
    public Contact getContact(String contactID) {
        return contacts.get(contactID);
    }

    // The addContact() method to add a new contact
    public void addContact(Contact newContact) {
        String id = newContact.getContactID();

        if (contacts.containsKey(id)) {
            throw new IllegalArgumentException("Contact ID must be unique.");
        }

        contacts.put(id, newContact);
    }

    // The deleteContact() method to delete a new contact
    public void deleteContact(String contactID) {
        if (contacts.remove(contactID) == null) {
            throw new IllegalArgumentException("Contact ID not found.");
        }
    }

    // Generic updateContact() method so that other methods can be simplified
    private void updateContact(String contactID, Consumer<Contact> updater) {
        Contact contact = contacts.get(contactID);

        if (contact == null) {
            throw new IllegalArgumentException("Contact ID not found.");
        }

        updater.accept(contact); // applies the update
    }

    // The updateFirstName() method to update the first name if the contact exists
    public void updateFirstName(String contactID, String newFirstName) {
        updateContact(contactID, c -> c.setFirstName(newFirstName));
    }

    // The updateLastName() method to update the last name if the contact exists
    public void updateLastName(String contactID, String newLastName) {
        updateContact(contactID, c -> c.setLastName(newLastName));
    }

    // The updatePhone() method to update the phone if the contact exists
    public void updatePhone(String contactID, String newPhone) {
        updateContact(contactID, c -> c.setPhone(newPhone));
    }

    // The updateAddress() method to update the address if the contact exists
    public void updateAddress(String contactID, String newAddress) {
        updateContact(contactID, c -> c.setAddress(newAddress));
    }

    // The getContacts() method returns the Map object contacts.
    public List<Contact> getContacts() {
        return new ArrayList<>(contacts.values());
    }
}
