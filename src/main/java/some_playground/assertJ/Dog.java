package some_playground.assertJ;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class Dog {

    private String name;
    private Float weight;
    private boolean isVaccinated;

    public Dog(String name, Float weight) {
        this.name = name;
        this.weight = weight;
    }
}
