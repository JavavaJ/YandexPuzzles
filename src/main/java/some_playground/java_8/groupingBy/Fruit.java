package some_playground.java_8.groupingBy;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Fruit {

    private String name;
    private int quantity;
    private BigDecimal price;

}
