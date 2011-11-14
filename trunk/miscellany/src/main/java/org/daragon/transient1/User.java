package org.daragon.transient1;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
    private String           username;
    private transient String password;
    
    private Date birthDate;

    public User(String username, String password, Date birthDate) {
        super();
        this.username = username;
        this.password = password;
        this.birthDate = birthDate;
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

}
