package com.wah.commons.utils;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;
import java.util.UUID;

public class UUIDUtils{

    public static String random(){
        SecureRandom secureRandom = new SecureRandom();
        byte[]       seed         = new byte[8];

        secureRandom.nextBytes(seed);

        Random random      = new Random((new BigInteger(seed)).longValue());
        byte[] randomBytes = new byte[16];
        long   mostSigBits = 0L;

        random.nextBytes(randomBytes);

        for(int i = 0; i < 8; ++i){
            mostSigBits = mostSigBits << 8 | (long) (randomBytes[i] & 255);
        }

        long leastSigBits = 0L;

        for(int i = 8; i < 16; ++i){
            leastSigBits = leastSigBits << 8 | (long) (randomBytes[i] & 255);
        }

        return new UUID(mostSigBits, leastSigBits).toString();
    }

    public static String uuid36(){
        return UUID.randomUUID().toString();
    }

    public static String uuid32(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static String uuid16(){
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");

        BigInteger first = new BigInteger(uuid.substring(0, uuid.length() / 2), 16);
        BigInteger last  = new BigInteger(uuid.substring(uuid.length() / 2), 16);

        return first.add(last).toString(16);
    }
}
