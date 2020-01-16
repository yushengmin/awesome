package awesome.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.DigestUtils;

public class Md5 {
    public static String md5(String str){
        String md5= DigestUtils.md5DigestAsHex(str.getBytes());
//        System.out.println(md5);
        return md5;
    }

    public static void main(String[] args) {
        Md5.md5("admin");
    }





}
