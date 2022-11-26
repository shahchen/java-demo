package utils.model;

import java.util.Optional;

public class Person {
//    我们在声明变量时使用的是 Optional<Car> 类型，而不是 Car 类型，这句声明非常清楚地表明了这里发生变量缺失是允许的。
    // 人可能有Car也可能没有
    private Optional<Car> car = Optional.empty();

    public Optional<Car> getCar() {
        return car;
    }

    public void setCar(Optional<Car> car) {
        this.car = car;
    }
}
