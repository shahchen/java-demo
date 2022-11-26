package utils;

import org.junit.Test;
import utils.model.Person;

import java.util.Optional;

public class OptionalDemo {
    /**
     * Optional类是Java8为了解决null值判断问题，
     * 借鉴google guava类库的Optional类而引入的一个同名Optional类，
     * 使用Optional类可以避免显式的null值判断（null的防御性检查），避免null导致的NPE（NullPointerException）。
     *
     *
     */

    @Test
    public void test() {
        Person person = new Person();
        person.getCar().getInsurance().getName();
    }

}
