package exercise;

public class User {
    private String id;
    private String firstName;
    private String lastName;
    private String email;

    public User() {
        this.id = null;
        this.firstName = null;
        this.lastName = null;
        this.email = null;
    }
    public User(String id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }
}
