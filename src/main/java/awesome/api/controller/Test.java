package awesome.api.controller;

import org.beetl.ext.simulate.JsonUtil;

import java.security.MessageDigest;
import java.sql.SQLOutput;
import java.util.concurrent.ExecutionException;

public class Test {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        String appkey = "45gn7md5n44aak7a57rdjud3b5l4xdgv75saomys";
        long timestamp = System.currentTimeMillis();
        String secret = "ba24a917a38e11e49c6fb82a72e0d896";
        System.out.println(timestamp);

        String data = appkey + "1585047674022" + secret;
        String sha1Digest = getSHA1Digest(data);
    }


    public static String getSHA1Digest(String data) {
        String digest = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] bytes = md.digest(data.getBytes("UTF-8"));
            digest = byte2hex(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(digest);
        return digest;
    }

    /**
     * 二进制转十六进制字符串
     *
     * @param bytes
     * @return
     */
    private static String byte2hex(byte[] bytes) {
        StringBuilder sign = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(bytes[i] & 0xFF);
            if (hex.length() == 1) {
                sign.append("0");
            }
            sign.append(hex.toUpperCase());
        }

        return sign.toString();
    }
}
