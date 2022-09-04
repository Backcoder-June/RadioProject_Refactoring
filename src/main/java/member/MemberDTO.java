package member;

import org.springframework.stereotype.Component;

public class MemberDTO {
    private String id;
    private int password;
    private String name;
    private String phone;
    private String email;
    private String regdate;


    public MemberDTO(){}
    public MemberDTO(String id, int password, String name, String phone, String email, String regdate) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.regdate = regdate;
    }


    @Override
    public String toString() {
        return "MemberDTO{" +
                "id='" + id + '\'' +
                ", password=" + password +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", regdate='" + regdate + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }
}



