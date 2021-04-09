package eg.gov.iti.jets;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.List;
import jakarta.ws.rs.core.Link;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Account {

    @XmlAttribute
    private int id;

    private String userName;
    private String fullName;
    private String password;
    private String phone;
    private String address;

    // @XmlJavaTypeAdapter(Link.JaxbAdapter.class)
    // private List<Link> links;

    public Account() {

    }

    public Account(int id, String UserName, String FullName, String Password, String Phone, String Address) {
        this.id = id;
        this.userName = UserName;
        this.fullName = FullName;
        this.password = Password;
        this.phone = Phone;
        this.address = Address;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
     this.password = password;
    }
       
    // public List<Link> getLinks() {
    //     return links;
    // }

    // public void setLinks(List<Link> links) {
    //  this.links = links;
    // }
       
}
