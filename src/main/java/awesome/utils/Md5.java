package awesome.utils;

import org.springframework.util.DigestUtils;

public class Md5 {
    public  static String stringToMd5(String str){
        String result= DigestUtils.md5DigestAsHex(str.getBytes());
        return result;
        }


}
