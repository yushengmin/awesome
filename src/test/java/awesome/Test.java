package awesome;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Test{


    public static void main(String[] args) {
        BCryptPasswordEncoder bcryptPasswordEncoder=new BCryptPasswordEncoder();
        String a =bcryptPasswordEncoder.encode("123");
        System.out.println(a);
    }
}


