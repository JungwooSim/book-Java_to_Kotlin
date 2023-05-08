package travelator._java;

import travelator._kotlin.EmailAddress;

public class Marketing {

    public static boolean isHotmailAddress(EmailAddress address) {
        return address.getDomain().equalsIgnoreCase("hotmail.com");
    }
}