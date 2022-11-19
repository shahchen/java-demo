package map;

import lombok.Data;

import java.util.*;

public class HashMapDemo {
    /**
     * HashMap支持的构造方法
     */
    // 使用默认参数
    private static Map<String, String> map = new HashMap<>();
    //指定初始化容量，不够时会自动扩容,默认是16
    private static Map<String, String> map1 = new HashMap<>(16);
    // 指定初始容量和加载因子，默认是16和0.75
    private static Map<String, String> map2 = new HashMap<>(16, 0.75f);
    // 使用已经有的map拷贝构造
    private static Map<String, String> map3 = new HashMap<>(map);


    private Map<String, Map<String, String>> people = new HashMap<>();


    static {
        map.put("key", "value");
        map.put("key1", "value1");
        map.put("key2", "value2");
    }

    //---------------------------------compute-------------------------------------

    /**
     * 如果不存在，则进行...加入可调对象产生的新值
     */
    public void insert(String name, String tagName, String tagValue) {
        // computeIfAbsent的可调对象是Function类，只有1个参数， 传入的是key为name
        people.computeIfAbsent(name, key -> {
            Map<String, String> tags = new HashMap<>();
            tags.put(tagName, tagValue);
            return tags;
        });
    }

    /**
     * 如果存在，则进行...
     */
    public void update(String name, String tagName, String tagValue) {
        // computeIfPresent的可调对象是BiFunction类，只有2个餐素， 传入的是key为name, value为old的tags
        people.computeIfPresent(name, (key, value) -> {
            System.out.println("key: " + key + " oldValue " + value);
            value.put(tagName, tagValue);
            return value;
        });
    }

    /**
     * 计算新值为null则删除key,不为空这更新key的value为新值
     */
    public void updateOrRemove(String name, String tagName, String tagValue) {
        people.compute(name, (key, value) -> {
            System.out.println("key: " + key + " oldValue " + value);
            value.get(tagName);
            return null;
        });
    }

    //------------------------------merge---------------------------------

    /**
     * 它将新的值赋值到 key （如果不存在）或更新给定的key 值对应的 value
     *
     */
    public void merge() {
        // 求学生分数和
        List<StudentScore> studentScoreList = new ArrayList<>();
        StudentScore studentScore1 = new StudentScore() {{
            setName("张三");
            setSubject("语文");
            setScore(70);
        }};
        StudentScore studentScore2 = new StudentScore() {{
            setName("张三");
            setSubject("数学");
            setScore(80);
        }};
        StudentScore studentScore3 = new StudentScore() {{
            setName("张三");
            setSubject("英语");
            setScore(65);
        }};
        studentScoreList.add(studentScore1);
        studentScoreList.add(studentScore2);
        studentScoreList.add(studentScore3);
        Map<String, Integer> studentScoreMap2 = new HashMap<>();
        studentScoreList.forEach(studentScore -> studentScoreMap2.merge(
                studentScore.getName(),
                studentScore.getScore(),
                Integer::sum));
    }

    //-------------------------------remove---------------------------------------
    /**
     * 删除key，返回key对应value
     */
    public void removeAndReturnValue(String key) {
        String removeValue = map.remove(key);
        System.out.println("remove " + key + " result is " + removeValue);
    }

    /**
     * 删除满足key-value，返回是否执行删除
     */
    public void removeKeyValue(String key, String value) {
        boolean removeResult = map.remove(key, value);
        System.out.println("remove " + key + " " + value + " result is " + removeResult);
    }

    //--------------------------------replace-----------------------------------

    /**
     * key存在则用新值替换旧值
     */
    public void replaceWithNewValue(String key, String newValue) {
        map.replace(key, newValue);
    }

    /**
     * key-value存在则用新值替换旧值
     */
    public void replace2(String key, String oldValue, String newValue) {
        map.replace(key, oldValue, newValue);
    }

    /**
     * 对于所有key-value，用可调对象产生一个新值替换旧值
     */
    public void replace3(String key, String oldValue, String newValue) {
        map.replaceAll((k, v) -> {
            String newV = v;
            return newV;
        });
    }

    //----------------------------get---------------------------------
    public void get(String key, String defaultValue) {
        String s = map.get(key);
        String v = map.getOrDefault(key, defaultValue);
    }

    //------------------------------put--------------------------------
    public void put(String key, String value) {
        map.put(key, value);
        map.putAll(new HashMap<>());
        /**
         * 如果key不存在或者value为null,则put
         */
        map.putIfAbsent(key, value);
    }

    //--------------------------other-------------------------------
    public void other(String key, String value) {
        map.containsKey(key);
        map.containsValue(key);
        map.isEmpty();
        map.size();
        map.clear();
        Set<Map.Entry<String, String>> entries = map.entrySet();
        Set<String> strings = map.keySet();
        Collection<String> values = map.values();
    }


    @Data
    public static class StudentScore {
        String name;
        String subject;
        int score;
    }

    public static void main(String[] args) {
        HashMapDemo m = new HashMapDemo();
        m.insert("chen", "age", "12");
        m.insert("chen", "age", "13");
        System.out.println(m.people + "\n");
        m.update("chen", "age", "18");
        System.out.println(m.people + "\n");
        m.updateOrRemove("chen", "city", "");
        System.out.println(m.people + "\n");
        System.out.println(Float.isNaN(Float.NaN));
    }
}
