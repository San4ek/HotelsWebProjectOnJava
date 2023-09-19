package com.example.hotels.Converter;

public class IdConverter {

    public static long convert(String id) {
        long longId= 0L;
        int numb=0;
        for (int i=id.length()-1; i>=0; --i) {
            if (id.charAt(i)>='0' && id.charAt(i)<='9') {
                longId+= (id.charAt(i)-'0') *(Math.pow(10,numb));
                ++numb;
            }
        }

        return  longId;
    }
}
