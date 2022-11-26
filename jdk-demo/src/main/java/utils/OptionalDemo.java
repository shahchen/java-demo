package utils;

import org.junit.Test;
import utils.model.*;

import java.util.Optional;

public class OptionalDemo {
    /**
     * Optional类是Java8为了解决null值判断问题，
     * 借鉴google guava类库的Optional类而引入的一个同名Optional类，
     * 使用Optional类可以避免显式的null值判断（null的防御性检查），避免null导致的NPE（NullPointerException）。
     *
     * 对于一个属性可能存在或者可能null可使用Optional
     */

    //--------------------------------原始方式------------------------------------------
    // 可能出现NullPointerException
    public String getInsuranceName0(Person0 person0) {
        return person0.getCar().getInsurance().getName();
    }

    // 防御式减少NullPointerException 过多嵌套
    public String getInsuranceName1(Person0 person0) {
        if (null != person0) {
            Car0 car0 = person0.getCar();
            if (null != car0) {
                Insurance0 insurance0 = car0.getInsurance();
                if (null != insurance0) {
                    String name = insurance0.getName();
                    return name;
                }
            }
        }
        return "unknown";
    }

    //null-安全的第二种尝试（过多的return语句）
    public String getInsuranceName2(Person0 person0) {
        if (null == person0) {
            return "unknown";
        }
        Car0 car0 = person0.getCar();
        if (null == car0) {
            return "unknown";
        }
        Insurance0 insurance0 = car0.getInsurance();
        if (null == insurance0) {
            return "unknown";
        }
        return insurance0.getName();
    }


    //---------------------------------创建对象-----------------------------------------
    /**
     *     创建一个空对象
     */
    @Test
    public void testEmpty() {
        // private Optional<Car> car = Optional.empty();
        Person person = new Person();
        System.out.println(person.getCar());
    }

    /**
     * 创建不允许为null的对象
     */
    @Test
    public void testOf() {
        Car car = new Car();
        Optional<Car> opCar = Optional.of(car);
        System.out.println(opCar);
        // 为null会抛异常
        System.out.println(Optional.of(null));
    }

    /**
     * 创建允许为null的对象
     */
    @Test
    public void testOfNullable() {
        Car car = new Car();
        Optional<Car> opCar = Optional.ofNullable(car);
        System.out.println(opCar);
        // 为null不会抛异常
        System.out.println(Optional.ofNullable(null));
    }

    //---------------------------------获取值-----------------------------------------
    @Test
    public void testGet() {
        Car car = new Car();
        Optional<Car> opCar = Optional.ofNullable(car);
        Car car1 = opCar.get();
        System.out.println(car1.equals(car));
    }

    @Test
    public void testIfElse() {
        Car car = new Car();
        Optional<Car> opCar = Optional.ofNullable(car);
        // 为空对象
//        if (opCar.isEmpty()) {
//        }
        // 存在值
        if(opCar.isPresent()) {

        }

        /**
         * 存在然后对值进行操作
         */

        opCar.ifPresent(c -> c.setName("新车"));
        System.out.println(opCar.get().getName());
//        opCar.ifPresentOrElse();

        Car newCar = new Car();
        /**
         *  不为null返回，否则返回newCar
         */
        Car car1 = opCar.orElse(newCar);

//        opCar.orElseThrow()

        /**
         * 不为null返回，否则返回使用函数返回值
         */
//        opCar.or(()->Optional.of(car));
        opCar.orElseGet(Car::new);

    }

    //----------------------------------过滤----------------------------------------
    @Test
    public void testFilter() {
        Car car = new Car();
        Optional<Car> opCar = Optional.ofNullable(car);
        opCar.get().setName("new");
        /**
         * 按条件过滤
         */
        Optional<Car> afterFilterCar1 = opCar.filter(c -> ("new").equals(c.getName()));
        System.out.println(afterFilterCar1);
        System.out.println("\n");
        afterFilterCar1.get().setName("new1");
        Optional<Car> afterFilterCar = afterFilterCar1.filter(c -> ("new").equals(c.getName()));
        System.out.println(afterFilterCar);
    }


    //----------------------------------map---------------------------------------
    // 根据person获取insurance的名字
    /**
     * map会将返回结果包裹在Optional中
     */
//    @Test
//    public String getInsuranceUseMap(Person person) {
//        return Optional.ofNullable(person)
//                .map(Person::getCar)
//                .map(Car::getInsurance)
//                .map(Insurance::getName)
//                .orElse("null");
//    }

    /**
     * flatMap会将返回结果对象,而不包裹Optional中
     */
    @Test
    public void getInsuranceUseFlatmap() {
        Person person = new Person();
        Car car = new Car();
        Insurance insurance = new Insurance();
        insurance.setName("hahaha");
        car.setInsurance(Optional.of(insurance));
        person.setCar(Optional.of(car));

        String result = Optional.ofNullable(person)
                .flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("null");
        System.out.println(result);
    }

    //----------------------------------其他---------------------------------------
    // stream()
    // equals()
    // toString()
    // hashCode()




}
