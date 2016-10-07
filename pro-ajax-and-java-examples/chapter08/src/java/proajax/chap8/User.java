package proajax.chap8;

/**
 *
 * @author nate
 */
public class User {
    
    /** Creates a new instance of User */
    public User() {
    }
    
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String isNate() {
        String result = "notNate";
        if (name.equalsIgnoreCase("Nate")) {
            result = "nate";
        }
        return result;
    }
}
