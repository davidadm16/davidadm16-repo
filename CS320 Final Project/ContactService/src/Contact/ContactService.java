/*
Author: David Diaz
SNHU CS320
 */

package Contact;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class ContactService {
    // Define a map to store contacts by setting ID as key,
    // and other values as contact object.
    private List<Contact> contacts;

    // Define a zero parameterized constructor to initialize
    // contacts map
    public ContactService()
    {
        contacts = new ArrayList<>();
    }

    // The getContact() method to retrieve the contact.
    public Contact getContact(String contactID)
    {
        for(Contact contact : contacts) {
            if (Objects.equals(contact.getContactID(), contactID)) {
                return contact;
            }
        }
        return null;
    }

    // The addContact() method to add a new contact
    public void addContact(Contact newContact)
    {
        //Iterate through the contacts list to search for any duplicates
        for(Contact contact : contacts) {
            // Validate the existence of the contact ID, if exists,
            // throw the exception.

            if (Objects.equals(contact.getContactID(), newContact.getContactID()))
            {
                throw new IllegalArgumentException("Contact ID must be unique.");
            }
        }

        // Otherwise, add the contact with key as contact ID.
        contacts.add(newContact);
    }

    // The deleteContact() method to delete a new contact
    public void deleteContact(String contactID)
    {
        Contact contact = getContact(contactID);
        //Throw the exception if it does not exist.
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID not found.");
        }
        else {
            // Otherwise, remove the contact from the contacts.
            contacts.remove(contact);
        }
    }

    // The updateFirstName() method to update the first name if the contact exists
    public void updateFirstName(String contactID, String newFirstName)
    {
        // Get the contact by using the contact ID.
        Contact contact = getContact(contactID);

        // If the contact is not null, update the first name with newFirstName
        // for the contactID.
        if (contact != null)
        {
            // Call the setFirstName() to update the name.
            contact.setFirstName(newFirstName);
        }
        // Otherwise, throw exception.
        else
        {
            throw new IllegalArgumentException("Contact ID not found.");
        }
    }

    // The updateLastName() method to update the last name if the contact exists
    public void updateLastName(String contactID, String newLastName)
    {
        // Get the contact by using the contact ID.
        Contact contact =getContact(contactID);

        // If the contact is not null, update the last name with newLastName
        // for the contactID.
        if (contact != null)
        {
            // Call the setLastName() to update the name.
            contact.setLastName(newLastName);
        }

        // Otherwise, throw exception.
        else
        {
            throw new IllegalArgumentException("Contact ID not found.");
        }
    }

    // The updatePhone() method to update the phone if the contact exists
    public void updatePhone(String contactID, String newPhone)
    {
        // Get the contact by using the contact ID.
        Contact contact = getContact(contactID);

        // If the contact is not null, update the phone number with newPhone
        // for the contactID.
        if (contact != null)
        {
            // Call the setPhone() to update the phone number.
            contact.setPhone(newPhone);
        }

        // Otherwise, throw exception.
        else
        {
            throw new IllegalArgumentException("Contact ID not found.");
        }
    }

    // The updateAddress() method to update the address if the contact exists
    public void updateAddress(String contactID, String newAddress)
    {
        // Retrieve the contact by ID
        Contact contact = getContact(contactID);

        // If the contact is not null, update the phone number with newPhone
        // for the contactID.
        if (contact != null)
        {
            // Call the setAddress() to update the address with newAddress.
            contact.setAddress(newAddress);
        }

        // Otherwise, throw exception.
        else
        {
            throw new IllegalArgumentException("Contact ID not found.");
        }
    }

    // The getContacts() method returns the list of contacts.
    public List<Contact> getContacts()
    {
        return contacts;
    }
}
