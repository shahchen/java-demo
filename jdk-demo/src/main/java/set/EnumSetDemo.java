package set;

import org.junit.Test;

import java.util.EnumSet;

public class EnumSetDemo {
    /**
     * EnumSet是一个set，然后set中的元素都是某个Enum类型。
     * EnumSet是一个interface而不是一个类
     * EnumSet有很多构造方法
     * 其他接口和HashSet一样，多了个clone
     */

    private enum ColorEnum {
        BLACK,
        RED,
        BLUE,
        GREEN
    }

    @Test
    public void test() {
            //用全部枚举值创建一个EnumSet集合
            EnumSet es = EnumSet.allOf(ColorEnum.class);
            System.out.println(es);

            //创建一个EnumSet空集合
            EnumSet es2 = EnumSet.noneOf(ColorEnum.class);
            System.out.println(es2);

            //以枚举值BLUE和BLACK来创建EnumSet集合
            EnumSet es3 = EnumSet.of(ColorEnum.BLUE, ColorEnum.BLACK);
            System.out.println(es3);

            //创建一个包含枚举值从RED到GREEN的EnumSet集合
            EnumSet es4 = EnumSet.range(ColorEnum.RED, ColorEnum.GREEN);
            System.out.println(es4);

            //创建一个EnumSet集合，其元素和es4集合元素类型相同， es4元素+es5元素=枚举的全部枚举值
            EnumSet es5 = EnumSet.complementOf(es4);
            System.out.println(es5);

    }
}
