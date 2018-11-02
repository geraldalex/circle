package sample;

public class User {
    private String firstName;
    private String lasttName;
    private String uasername;
    private String password;
    private String gender;


    public User() {

    }

    public User(String firstName, String lasttName, String uasername, String password, String gender) {
        this.firstName = firstName;
        this.lasttName = lasttName;
        this.uasername = uasername;
        this.password = password;
        this.gender = gender;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLasttName(String lasttName) {
        this.lasttName = lasttName;
    }

    public void setUasername(String uasername) {
        this.uasername = uasername;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLasttName() {
        return lasttName;
    }

    public String getUasername() {
        return uasername;
    }

    public String getPassword() {
        return password;
    }

    public String getGender() {
        return gender;
    }
}
