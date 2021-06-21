package ru.netology.repository;

import ru.netology.domain.Offer;

public class OfferRepository {
    Offer[] offers = new Offer[0];

    public void save(Offer offer) {
        Offer[] tmp = new Offer[offers.length + 1];
        System.arraycopy(offers, 0, tmp, 0, offers.length);
        tmp[tmp.length - 1] = offer;
        offers = tmp;
    }

    public void removeById(int id) {
        Offer[] tmp = new Offer[offers.length - 1];
        int index = 0;
        for (Offer offer : offers) {
            index++;
            if (offer.getId() != id) {
                if (index != offers.length) {
                    tmp[index - 1] = offer;
                }
            } else {
                index--;
            }
        }
        offers = tmp;
    }

    public Offer[] getAll() {
        return offers;
    }
}
