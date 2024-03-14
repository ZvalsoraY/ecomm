package fast.comm.models;

import javax.xml.crypto.Data;

//@Entity
//@Table(name = "t_user")
public class User {
    private long id;
    private String name;
    private String patronymic;
    private String surname;
    private Data birthDay;
    private String phoneNumber;
    private String status;
    private String password;

    public User() {
    }

    public User(long id, String name, String patronymic, String surname, Data birthDay, String phoneNumber, String status, String password) {
        this.id = id;
        this.name = name;
        this.patronymic = patronymic;
        this.surname = surname;
        this.birthDay = birthDay;
        this.phoneNumber = phoneNumber;
        this.status = status;
        this.password = password;
    }
}
