package some_playground.assertJ;

import org.assertj.core.api.AbstractListAssert;
import org.assertj.core.api.ListAssert;
import org.assertj.core.api.ObjectAssert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;


class DogTest {

    @Test
    public void testDog() {
        Dog fido = new Dog("Fido", 5.25F);
        Dog fidoClone = new Dog("Fido", 5.25F);

        // comparing references
        assertThat(fido).isNotEqualTo(fidoClone);

        // comparing content
        assertThat(fido).usingRecursiveComparison()
            .isEqualTo(fidoClone);
    }

    @Test
    public void testBooleans() {
        // asserting booleans
        assertThat(true).isTrue();
        assertThat(false).isFalse();
    }

    @Test
    public void testIterables() {
        List<String> list = Arrays.asList("1", "2", "3");

        assertThat(list).isNotEmpty();
        assertThat(list).contains("1", "2");
        assertThat(list).startsWith("1");

        // which is the same as
        assertThat(list).isNotEmpty()
            .contains("1", "2")
            .startsWith("1");
    }

    @Test
    public void testMap() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "a");
        map.put(2, "b");

        assertThat(map).isNotEmpty()
            .containsKey(2)
            .doesNotContainKeys(10)
            .contains(entry(2, "b"));
    }

    @Test
    public void testDogs() {
        List<Dog> dogs = Arrays.asList(
            new Dog("Rocky", 7F),
            new Dog("Brian", 5F),
            new Dog("Rocky", 6F));

        assertThat(dogs.get(0)).usingRecursiveComparison()
            .ignoringFields("weight")
            .isEqualTo(dogs.get(2));

        assertThat(dogs).extracting(Dog::getName)
            .contains("Brian", "Rocky")
            .doesNotContainNull();

        assertThat(dogs).filteredOn(dog -> dog.getName()
            .equals("Rocky"))
            .hasSize(2);

        assertThat(dogs).extracting(Dog::isVaccinated)
            .containsOnly(false);
    }

    @Test
    public void testNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        assertThat(numbers).isNotEmpty()
            .hasSize(5)
            .doesNotHaveDuplicates()
            .contains(4, 2, 5, 1, 3)
            .endsWith(5)
            .startsWith(1)
            .containsSequence(3, 4)
            .containsExactly(1, 2, 3, 4, 5);
    }

}