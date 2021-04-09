package beans;
import java.io.Serializable;

public class UserBean implements Serializable {

    private String name;
    private String password;

    public UserBean() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
