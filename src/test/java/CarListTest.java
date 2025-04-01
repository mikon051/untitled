import org.example.Car;
import org.example.CarArrayList;
import org.example.CarLinkedList;
import org.example.CarList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarListTest {

    CarList carList;

    @BeforeEach
    void setUp() {
        carList = new CarLinkedList();
        for (int i = 0; i < 100; i++) {
            carList.add(new Car("Porche" + i, i));
        }
    }

    @Test
    public void whenWeAdd100CarWeAreExpected100Car() {
        assertEquals(100, carList.size());
    }

    @Test
    public void whenWeRemoveElementWeExpectedDeleteOfListForNumberElement() {
        assertTrue(carList.removeAt(5));
        assertEquals(99, carList.size());
    }

    @Test
    public void whenWeRemoveTheRightOneElement() {
        Car car = new Car("Toyta", 15);
        carList.add(car);
        assertEquals(101, carList.size());
        assertTrue(carList.remove(car));
        assertEquals(100, carList.size());
    }

    @Test
    public void whenNonExistentElementRemovedThenReturnFalse() {
        Car car = new Car("Toyta", 15);
        assertFalse(carList.remove(car));
        assertEquals(100, carList.size());
    }

    @Test
    public void whenWeRemoveAllElementsWeWaitSize0() {
        carList.clear();
        assertEquals(0, carList.size());
    }

    @Test
    public void whenWeTakeElementForNumberWewWaitReturnThisElement() {
        Car car = carList.get(0);
        assertEquals("Porche0", car.getName());
    }

    @Test
    public void whenWeExitOfListWeWaitReturnException() {
        try {
            carList.get(105);
        } catch (Exception e) {
            System.out.println("выход за пределы массива");
        }
    }

    @Test
    public void whenWeInputElementWeWaitThisElementOnTheChoosePlace() {
        Car car = new Car("Toyta", 10);
        carList.add(car, 100);
        Car result = carList.get(100);

        assertEquals("Toyta", result.getName());
    }
}