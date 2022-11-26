package utils.model;

import java.util.Optional;

public class Car {
    private String name;

    // Car可能有保险可能没有保险
    private Optional<Insurance> insurance = Optional.empty();

    public Optional<Insurance> getInsurance() {
        return insurance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInsurance(Optional<Insurance> insurance) {
        this.insurance = insurance;
    }

    public String getName() {
        return name;
    }
}
