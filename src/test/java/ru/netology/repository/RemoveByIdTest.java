package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Offer;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class RemoveByIdTest {
    OfferRepository repository = new OfferRepository();
    Offer one = new Offer(15, 129900, "SVO", "KZN", 95);
    Offer two = new Offer(16, 219900, "VKO", "KZN", 95);
    Offer three = new Offer(12, 238500, "VKO", "KZN", 90);
    Offer four = new Offer(11, 310000, "DME", "KZN", 90);
    Offer five = new Offer(5, 310000, "DME", "KZN", 95);
    Offer six = new Offer(3, 310000, "DME", "KZN", 95);
    Offer seven = new Offer(43, 310000, "DME", "KZN", 95);
    Offer eight = new Offer(10, 310000, "DME", "KZN", 95);
    Offer nine = new Offer(8, 411400, "SVO", "KZN", 95);
    Offer ten = new Offer(6, 411400, "SVO", "KZN", 95);

    @BeforeEach
    public void setUp() {
        repository.save(one);
        repository.save(two);
        repository.save(three);
        repository.save(four);
        repository.save(five);
        repository.save(six);
        repository.save(seven);
        repository.save(eight);
        repository.save(nine);
        repository.save(ten);
    }

    @Test
    public void shouldRemoveById() {
        repository.removeById(5);

        Offer[] returned = new Offer[]{one,
                two,
                three,
                four,
                six,
                seven,
                eight,
                nine,
                ten};

        assertArrayEquals(returned, repository.getAll());
    }

}


