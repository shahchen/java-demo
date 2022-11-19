package map;

import java.util.EnumMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 线程安全map
 */
public class ConcurrentHashMapDemo {
    Map<String, String> map = new ConcurrentHashMap<>();

    public void test() {
    }
}
