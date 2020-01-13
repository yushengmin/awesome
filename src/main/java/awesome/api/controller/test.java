package awesome.api.controller;


import org.springframework.util.DigestUtils;

public class test {
    public static void main(String[] args) {
        String a="12344444";
        String md5= DigestUtils.md5DigestAsHex(a.getBytes());
        System.out.println(md5);


    }

}
