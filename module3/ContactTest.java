import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*; 
import org.junit.jupiter.api.BeforeEach;

public class ContactTest { 
 
 private Contact contact; 
 
  @BeforeEach
  void setUp() {
    contact = new Contact("Ada Lovelace", "+1 617 555 0101");
  } 
 
  @Test
  void getName_returnsCorrectName() {
    assertEquals("Ada Lovelace", contact.getName());
  }

  @Test
  void getName_isIndependent_forEachContactObject() {
    Contact secondContact = new Contact("Ada Lovelace", "+1 444 444 4444");
    contact = new Contact("Fredd Merc", "+1 234 567 8910");
    assertEquals("Ada Lovelace", secondContact.getName());
  } 
 
  @Test
  void getPhone_returnsCorrectPhone() {
    assertEquals("+1 617 555 0101", contact.getPhone());
  } 
 
  @Test
  void toString_containsBothFields() {
    assertTrue(contact.toString().contains("Ada Lovelace"));
    assertTrue(contact.toString().contains("+1 617 555 0101"));
  }
} 