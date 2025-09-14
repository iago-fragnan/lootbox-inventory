package dev.iagof.lootbox.utils;

import java.util.Random;

public class RandomString {

    // https://stackoverflow.com/a/20536819
    public static String generate(Integer length){
        StringBuilder sb = new StringBuilder ();
        String candidateChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        Random random = new Random ();
        for (int i = 0; i < length; i ++) {
            sb.append (candidateChars.charAt (random.nextInt (candidateChars
                    .length ())));
        }

        return sb.toString ();
    }
}
