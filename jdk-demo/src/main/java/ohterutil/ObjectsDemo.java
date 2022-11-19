package ohterutil;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ObjectsDemo {
    /**
     * Objects工具类
     */

    //-----------------------equal----------------------------
    @Test
    public void testEqual() {
        String a = "chen";
        String b = "chen";
        /**
         * 判断单个对象是否相等，底层调用== 和 equal方法
         */
        if(Objects.equals(a, b)) {
            System.out.println("a == b");
        }
        List<String> list1 = new ArrayList<>();
        list1.add("chen");
        list1.add("shah");
        List<String> list2 = Arrays.asList("chen", "shah", "good");
        /**
         * 判断单个对象或者列表的对应元素是否相等
         */
        if(Objects.deepEquals(list1, list2)) {
            System.out.println("list1 is equal list2");
        }
    }

    //----------------hash----------------------
    @Test
    public void testHash() {
        String str = "789";
        List<String> list = Arrays.asList("123", "456");
        /**
         * 返回非空对象的hash值（一个int）
         */
        System.out.println(Objects.hashCode(str));
        System.out.println("=====================");
        /**
         * 返回非空序列的hash值（一个int）
         */
        System.out.println(Objects.hash(list));
    }

    //--------------------toString----------------------
    @Test
    public void testToString() {
        List<String> list = Arrays.asList("123", "456");
        String str = null;
        /**
         * 为空时返回null,底层调用toString
         */
        System.out.println(Objects.toString(list));
        System.out.println("====================");
        /**
         * 为空时返回null
         */
        System.out.println(Objects.toString(str));
        System.out.println("====================");
        /**
         * 指定为空时返回字符串
         */
        System.out.println(Objects.toString(str, "str is null"));
        System.out.println("====================");
//        System.out.println(Objects.toIdentityString(str));
    }

    //---------------------null---------------------
    @Test
    public void testNull() {
        String str1 = null;
        String str2 = "fdsf";
        /**
         * 判断是否为null
         */
        if (Objects.isNull(str1)) {
            System.out.println("str1 is null\n");
        } else {
            System.out.println("str1 is not null\n");
        }
        if (Objects.isNull(str2)) {
            System.out.println("str2 is null\n");
        } else {
            System.out.println("str2 is not null\n");
        }
        /**
         *  判断对象非null
         */
        if (Objects.nonNull(str1)) {
            System.out.println("str1 is not null\n");
        } else {
            System.out.println("str1 is null\n");
        }
        if (Objects.nonNull(str2)) {
            System.out.println("str2 is not null\n");
        } else {
            System.out.println("str2 is null\n");
        }
        /**
         * 检查对象不为null，为null抛异常，否则返回原对象
         */
//        Objects.requireNonNull(str1); //NullPointerException
        System.out.println(Objects.requireNonNull(str2));
        /**
         * 指定异常的信息
         */
//        Objects.requireNonNull(str1, "str1 is null"); // NullPointerException: str1 is null

    }

    //---------------------------compare-------------------
    @Test
    public void testCompare() {
        String str1 = "chen";
        String str2 = "shah";
        System.out.println(Objects.compare(str1, str2, String::compareTo));
    }

    //-------------------index-------------------------
    @Test
    public void testIndex() {
        // 检查索引是否符合
//        Objects.checkIndex();
//        Objects.checkFromIndexSize()
    }
}
