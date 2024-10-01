import java.util.Objects;
import java.util.UUID;

class Person3 {
    private String name;
    private int age;
    private String username;
    private String password;

    public Person3(String name, int age, String username, String password) {
        this.name = name;
        this.age = age;
        this.username = username;
        this.password = password;
    }

    // Getter for username and password (for comparison in Manager class)
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // Override toString to print name and age
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }

    // Override equals to compare username and password
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person3 person = (Person3) o;
        return Objects.equals(username, person3.username) && Objects.equals(password, person3.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }
}

// Manager class extending Person
class Manager extends Person {
    private String managerID;
    private int actionNumber;

    // Constructor for Manager class
    public Manager(String name, int age, String username, String password) {
        super(name, age, username, password); // Calls the constructor of the Person class
        // Auto-generate managerID using UUID
        this.managerID = UUID.randomUUID().toString();
        // Initialize actionNumber to 0
        this.actionNumber = 0;
    }

    // Getter for managerID
    public String getManagerID() {
        return managerID;
    }

    // Getter and Setter for actionNumber
    public int getActionNumber() {
        return actionNumber;
    }

    public void setActionNumber(int actionNumber) {
        this.actionNumber = actionNumber;
    }

    // Override toString to include managerID
    @Override
    public String toString() {
        return "Manager{managerID='" + managerID + "', name='" + getUsername() + "', age=" + getActionNumber() + "}";
    }

    // Override equals to compare username/password or managerID/password
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manager manager = (Manager) o;

        // Check if username/password or managerID/password match
        return (Objects.equals(getUsername(), manager.getUsername()) && Objects.equals(getPassword(), manager.getPassword())) ||
                (Objects.equals(managerID, manager.managerID) && Objects.equals(getPassword(), manager.getPassword()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(managerID, getUsername(), getPassword());
    }

    public static void main(String[] args) {
        // Testing the Manager class
        Manager manager1 = new Manager("Alice", 35, "aliceManager", "managerPass1");
        Manager manager2 = new Manager("Bob", 40, "bobManager", "managerPass2");
        Manager manager3 = new Manager("Alice", 35, "aliceManager", "managerPass1");

        // Print manager info
        System.out.println(manager1);
        System.out.println(manager2);

        // Test action number
        System.out.println("Manager1 action number: " + manager1.getActionNumber());
        manager1.setActionNumber(10);
        System.out.println("Updated Manager1 action number: " + manager1.getActionNumber());

        // Test equals
        if (manager1.equals(manager3)) {
            System.out.println("Manager1 and Manager3 are equal (username/password or managerID/password match).");
        } else {
            System.out.println("Manager1 and Manager3 are not equal.");
        }

        if (manager1.equals(manager2)) {
            System.out.println("Manager1 and Manager2 are equal.");
        } else {
            System.out.println("Manager1 and Manager2 are not equal.");
        }
    }
}
