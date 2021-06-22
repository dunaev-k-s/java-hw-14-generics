package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.netology.domain.Offer;
import ru.netology.domain.OfferByPriceComparator;
import ru.netology.repository.OfferRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class FindAllAndFastTest {
    OfferRepository repository = new OfferRepository();
    OfferManager manager = new OfferManager(repository);
    OfferByPriceComparator comparator = new OfferByPriceComparator();

    Offer one = new Offer(15, 129900, "SVO", "KZN", 95);
    Offer two = new Offer(16, 219900, "SVO", "KZN", 90);
    Offer three = new Offer(12, 238500, "VKO", "KZN", 85);
    Offer four = new Offer(11, 350000, "DME", "KZN", 80);
    Offer five = new Offer(5, 315000, "DME", "KZN", 80);
    Offer six = new Offer(3, 310000, "DME", "KZN", 70);
    Offer seven = new Offer(43, 311000, "DME", "KZN", 65);
    Offer eight = new Offer(10, 330000, "DME", "KZN", 60);
    Offer nine = new Offer(8, 411400, "SVO", "KZN", 55);
    Offer ten = new Offer(6, 410000, "SVO", "KZN", 50);

    @BeforeEach
    public void setUp() {
        manager.add(one);
        manager.add(two);
        manager.add(three);
        manager.add(four);
        manager.add(five);
        manager.add(six);
        manager.add(seven);
        manager.add(eight);
        manager.add(nine);
        manager.add(ten);
    }

    @Test
    public void shouldFindDmeKzn(){

        Offer[] actual = manager.findAll("DME", "KZN", comparator);
        Offer[] expected = new Offer[]{eight, seven, six, four, five};

        System.out.println(Arrays.toString(actual));
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSvoKzn(){

        Offer[] actual = manager.findAll("SVO", "KZN", comparator);
        Offer[] expected = new Offer[]{ten,nine,two,one};

        System.out.println(Arrays.toString(actual));
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindVkoKzn(){

        Offer[] actual = manager.findAll("VKO", "KZN",comparator);
        Offer[] expected = new Offer[]{three};

        System.out.println(Arrays.toString(actual));
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindNothing(){

        Offer[] actual = manager.findAll("SVX", "KZN", comparator);
        Offer[] expected = new Offer[0];

        assertArrayEquals(expected, actual);
    }
}
