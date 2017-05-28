package com.lffblk.tutorials.java8.base64;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.UUID;

/**
 * Created by lffblk on 28.05.2017.
 */
public class Base64Tester {
    public static void main(String[] args) {
        try {
            // Encode using basic encoder
            String base64encodedString = Base64.getEncoder().encodeToString("lffblk".getBytes("utf-8"));
            System.out.println("Base64 encoded string: " + base64encodedString);

            // Decode
            byte[] base64decodedBytes = Base64.getDecoder().decode(base64encodedString);
            System.out.println("Original string: " + new String(base64decodedBytes, "utf-8"));

            base64encodedString = Base64.getUrlEncoder().encodeToString("google.com".getBytes("utf-8"));
            System.out.println("\nBase64 Encoded String (URL) :" + base64encodedString);
            base64decodedBytes = Base64.getUrlDecoder().decode(base64encodedString);
            System.out.println("Original URL: " + new String(base64decodedBytes, "utf-8"));

            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < 10; ++i) {
                stringBuilder.append(UUID.randomUUID().toString());
            }
            byte[] mimeBytes = stringBuilder.toString().getBytes("utf-8");
            String mimeEncodedString = Base64.getMimeEncoder().encodeToString(mimeBytes);
            System.out.println("\nBase64 Encoded String (MIME):" + mimeEncodedString);
            base64decodedBytes = Base64.getMimeDecoder().decode(mimeEncodedString);
            System.out.println("Original MIME: " + new String(base64decodedBytes, "utf-8"));
        }
        catch (UnsupportedEncodingException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
