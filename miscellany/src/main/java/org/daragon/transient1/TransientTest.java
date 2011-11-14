package org.daragon.transient1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Date;

public class TransientTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println(System.getProperty(("user.home")));
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.out"));
        User user = new User("david","1234",new Date(1722,11,11));
        user.setPassword("1234");
        user.setUsername("david");
        oos.writeObject(user);
        oos.flush();
        oos.close();
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.out"));
        User u = (User) ois.readObject();
        System.out.println(u.getUsername());
        System.out.println(u.getPassword());

    }

}
