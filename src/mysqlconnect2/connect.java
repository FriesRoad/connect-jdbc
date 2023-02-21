package mysqlconnect2;

import java.util.Date;

public class connect {

    int id;
    String name;
    String pas;
    String email;
    Date birthday;

    public connect(int id, String name, String password, String email, Date birthday) {
        this.id = id;
        this.name = name;
        this.pas = password;
        this.email = email;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "connect{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + pas + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}

