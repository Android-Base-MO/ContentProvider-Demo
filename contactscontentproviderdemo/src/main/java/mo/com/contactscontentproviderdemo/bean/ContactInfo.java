package mo.com.contactscontentproviderdemo.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/8/21.
 */
public class ContactInfo implements Serializable {
    private String id;
    private String phone;
    private String name;
    private String email;
    private String im;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIm() {
        return im;
    }

    public void setIm(String im) {
        this.im = im;
    }

    @Override
    public String toString() {
        return "ContactInfo{" +
                "id='" + id + '\'' +
                ", phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", im='" + im + '\'' +
                '}';
    }
}
