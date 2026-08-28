//Created by Roberto Vera
//Skeleton code by professor Mohamad Kassab

public class Contact {
   // FIELDS: the data each Employee object holds 
    private String  name; 
    private String phone;
 
    // CONSTRUCTOR: runs when you write new Employee(...) 
    public Contact(String name, String phone) { 
        this.name   = name;     // 'this.name' is the field; 'name' is the parameter 
        this.phone = phone;
    } 
 
    // GETTERS: controlled read access to private fields 
    public String  getName()   { return name; } 
    public String  getPhone() { return phone; } 
 
    // TOSTRING: what prints when you System.out.println(contact) 
    @Override 
    public String toString() { 
        return name + " | " + phone; 
    } 
}
