package map;

import java.util.Hashtable;

public class HashTableDemo {
    /**
     * 从Java 2平台v1.2，这个类被改造为实现Map接口，使其成为成员Java Collections Framework 。
     * 与新的集合实现不同， Hashtable是同步的。
     * 如果不需要线程安全的实现，建议使用HashMap代替Hashtable 。
     * 如果需要线程安全的并发实现，那么建议使用ConcurrentHashMap代替Hashtable 。
     *
     * 相同点:
     *  hashmap和Hashtable都实现了map、Cloneable（可克隆）、Serializable（可序列化）这三个接口
     *
     * 不同点:
     *
     * 1、底层数据结构不同:jdk1.7底层都是数组+链表,但jdk1.8 HashMap加入了红黑树
     * 2、Hashtable 是不允许键或值为 null 的，HashMap 的键值则都可以为 null。
     * 3、添加key-value的hash值算法不同：HashMap添加元素时，是使用自定义的哈希算法,而HashTable是直接采用key的hashCode()
     * 4、实现方式不同：Hashtable 继承的是 Dictionary类，而 HashMap 继承的是 AbstractMap 类。
     * 5、初始化容量不同：HashMap 的初始容量为：16，Hashtable 初始容量为：11，两者的负载因子默认都是：0.75。
     * 6、扩容机制不同：当已用容量>总容量 * 负载因子时，HashMap 扩容规则为当前容量翻倍，Hashtable 扩容规则为当前容量翻倍 +1。
     * 7、支持的遍历种类不同：HashMap只支持Iterator遍历,而HashTable支持Iterator和Enumeration两种方式遍历
     * 8、迭代器不同：HashMap的迭代器(Iterator)是fail-fast迭代器，而Hashtable的enumerator迭代器不是fail-fast的。所以当有其它线程改变了HashMap的结构（增加或者移除元素），将会抛出ConcurrentModificationException，但迭代器本身的remove()方法移除元素则不会抛出ConcurrentModificationException异常。但这并不是一个一定发生的行为，要看JVM。而Hashtable 则不会。
     * 9、部分API不同：HashMap不支持contains(Object value)方法，没有重写toString()方法,而HashTable支持contains(Object value)方法，而且重写了toString()方法
     * 10、同步性不同: Hashtable是同步(synchronized)的，适用于多线程环境,而hashmap不是同步的，适用于单线程环境。多个线程可以共享一个Hashtable；而如果没有正确的同步的话，多个线程是不能共享HashMap的。
     *
     * 由于Hashtable是线程安全的也是synchronized，所以在单线程环境下它比HashMap要慢。如果你不需要同步，只需要单一线程，那么使用HashMap性能要好过Hashtable。
     *
     */
}
