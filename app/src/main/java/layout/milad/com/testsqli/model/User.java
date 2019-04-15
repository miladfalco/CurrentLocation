package layout.milad.com.testsqli.model;

public class User {

    private int id;
    private String Name;
    private String family;

    public User() {
    }

    public User(int id, String name, String family) {
        this.id = id;
        Name = name;
        this.family = family;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }
}
