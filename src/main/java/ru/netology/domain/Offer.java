package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Offer implements Comparable<Offer> {
    int id;
    int price;
    String departure;
    String arrival;
    int time;

    @Override
    public int compareTo(Offer o) {
        return Integer.compare(price, o.price);
    }

}
