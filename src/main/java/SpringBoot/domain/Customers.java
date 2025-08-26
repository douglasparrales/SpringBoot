package SpringBoot.domain;

/**
 * CLASS TYPE POJO
 */
public class Customers {

    /**
     * ATTRIBUTES CUSTOMERS
     */
    private int id;
    private String name;
    private String username;
    private String password;

    /**
     * Constructor
     * @param id id customer
     * @param name name customer
     * @param username username customer
     * @param password password customer
     */
    public Customers(int id, String name, String username, String password){
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
    }


    /**
     * METHODS GETTER AND SETTERS
     */
    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
