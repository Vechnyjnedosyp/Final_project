package utils;

import java.util.Random;

public class RandomValue {

    public static String generateRandomHexString(int length){
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        while(sb.length() < length){
            sb.append(Integer.toHexString(random.nextInt()));
        }
        return sb.toString().substring(0, length);
    }

    public String generateString(int length) {
        return generateRandomHexString(length).toLowerCase();
    }

}
