package ed.lab;

import java.util.HashMap;
import java.util.Map;

public class E02Logger {
    private Map<String, Integer> nextAllowed;

    public E02Logger() {
        nextAllowed = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        Integer allowTime = nextAllowed.get(message);
        if (allowTime == null || timestamp >= allowTime) {
            nextAllowed.put(message, timestamp + 10);
            return true;
        }
        return false;
    }

}
