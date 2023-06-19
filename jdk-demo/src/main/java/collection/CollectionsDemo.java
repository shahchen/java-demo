package collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsDemo {

    @Test
    // Collections.addAll()相对于List自带addAll写的简洁和直接添加数组
    public void testCollectionsAddAll() {
        List<Integer> list = new ArrayList<>();
        // 普通写法
        list.add(1);
        list.add(2);
        list.add(3);

        // Collections.addAll()写法
        // 1使用变参数
        Collections.addAll(list, 1, 2, 3);
        // 2使用数组
        Integer[] arr = {1, 2, 3};
        Collections.addAll(list, arr);
    }


}
