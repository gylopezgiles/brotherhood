package com.magneto.brotherhood.helpers;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class HashHelper {

    public static String generateHashByString(String[] strings){
        StringBuilder stringToEncode = new StringBuilder();
        for(String str: strings){
            stringToEncode.append(str);
        }
        return Base64.getEncoder().encodeToString(stringToEncode.toString().getBytes(StandardCharsets.UTF_8));
    }

}
