package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.netology.domain.Offer;
import ru.netology.repository.OfferRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class FindAllTest {
    OfferRepository repository = new OfferRepository();
    OfferManager manager = new OfferManager(repository);

    Offer one = new Offer(15, 129900, "SVO", "KZN", 95);
    Offer two = new Offer(16, 219900, "SVO", "KZN", 95);
    Offer three = new Offer(12, 238500, "VKO", "KZN", 90);
    Offer four = new Offer(11, 350000, "DME", "KZN", 90);
    Offer five = new Offer(5, 315000, "DME", "KZN", 95);
    Offer six = new Offer(3, 310000, "DME", "KZN", 95);
    Offer seven = new Offer(43, 311000, "DME", "KZN", 95);
    Offer eight = new Offer(10, 330000, "DME", "KZN", 95);
    Offer nine = new Offer(8, 411400, "SVO", "KZN", 95);
    Offer ten = new Offer(6, 410000, "SVO", "KZN", 95);

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

        Offer[] actual = manager.findAll("DME", "KZN");
        Offer[] expected = new Offer[]{six, seven, five, eight, four};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSvoKzn(){

        Offer[] actual = manager.findAll("SVO", "KZN");
        Offer[] expected = new Offer[]{one, two, ten, nine};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindVkoKzn(){

        Offer[] actual = manager.findAll("VKO", "KZN");
        Offer[] expected = new Offer[]{three};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindNothing(){

        Offer[] actual = manager.findAll("SVX", "KZN");
        Offer[] expected = new Offer[0];

        assertArrayEquals(expected, actual);
    }
}
