package map;

import org.junit.Test;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class EnumMapDemo {
    /**
     * EnumMap中，key的类型是枚举类型，所有的key的可能值在创建的时已经知道，所以实现相对hashMap，性能效率较高
     * 用法和HashMap一样,会多一个深拷贝方法clone
     */
    EnumMap<ColorEnum, String> colorMap = new EnumMap<>(ColorEnum.class);
    EnumMap<ColorEnum, String> colorMap1 = new EnumMap<>(colorMap);
//    Map<ColorEnum, String> map = new HashMap<>();
//    EnumMap<ColorEnum, String> colorMap2 = new EnumMap<>(map);

    private enum ColorEnum {
        BLACK,
        RED,
        BLUE,
        GREEN
    }

    @Test
    public void test() {
        colorMap.put(ColorEnum.BLACK, "black");
        colorMap.put(ColorEnum.RED, "red");

        EnumMap<ColorEnum, String> clone = colorMap.clone();
        colorMap.put(ColorEnum.BLACK, "newBlack");
        System.out.println(colorMap.toString());
        System.out.println(clone);

    }

}
