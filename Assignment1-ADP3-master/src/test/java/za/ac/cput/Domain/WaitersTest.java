package za.ac.cput.Domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WaitersTest {
    @Test
    void shouldCheckAllItemsInTheList() {
        List<Integer> numbers = List.of(1, 5, 6, 8);
        Assertions.assertAll(() -> Assertions.assertEquals(1, numbers.get(0)),
                             () -> Assertions.assertEquals(5, numbers.get(1)),
                             () -> Assertions.assertEquals(6, numbers.get(2)),
                             () -> Assertions.assertEquals(8, numbers.get(3)));

    }

}