//Created by Roberto Vera
//Skeleton code by professor Mohamad Kassab
import java.util.*; 

public class ContactManager {
    public static void main(String[] args) { 
 
    HashMap<String, Contact> contacts = new HashMap<>(); 
 
    // Step 4: add contacts here 
    contacts.put("Ada Lovelace", new Contact("Ada Lovelace", "+1 617 555 0101"));
    contacts.put("Brian P", new Contact("Brian P", "+1 111 111 1111"));
    contacts.put("Chris D", new Contact("Chris D", "+1 222 222 2222"));
    contacts.put("Daniel F", new Contact("Daniel F", "+1 333 333 3333"));
    contacts.put("Aria G", new Contact("Aria G", "+1 444 444 4444"));
    // Step 5: look up a contact 
    lookUp(contacts, "Bruce"); // Name not found test
    lookUp(contacts, "Ada Lovelace");

    // Step 6: print sorted list 
    ArrayList<Contact> sorted = new ArrayList<>(contacts.values());
    sorted.sort((a, b) -> a.getName().compareTo(b.getName()));
    
    printContacts(sorted);
    }

    public static void lookUp (HashMap<String, Contact> contactList, String name){
       if (contactList.get(name) == null){
        System.out.println("Contact not found.");
       }
       else{
        System.out.println(contactList.get(name));
       }
    }

    public static void printContacts (ArrayList<Contact> contactList){
        System.out.println("=== All Contacts ===");
        for (Contact contact : contactList) {
            System.out.println(contact); 
        } 
    }
}
