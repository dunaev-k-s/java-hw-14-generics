package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Offer;
import ru.netology.domain.OfferByPriceComparator;
import ru.netology.repository.OfferRepository;

import java.util.Arrays;
import java.util.Comparator;

@NoArgsConstructor
@Data
public class OfferManager {
    OfferRepository repository = new OfferRepository();
    public OfferManager(OfferRepository repository){
        this.repository = repository;
    }



    public Offer[] findAll(String from, String to, Comparator<Offer> comparator) {
        Offer[] result = new Offer[0];
        for (Offer offer : repository.getAll()) {
            if (from.equals(offer.getDeparture()) && to.equals(offer.getArrival())){
                Offer[] tmp = new Offer[result.length + 1];
                System.arraycopy(result,0,tmp,0,result.length);
                tmp[tmp.length - 1] = offer;
                result = tmp;
                Arrays.sort(result,comparator);
            }
        }
        return result;
    }

    public void add(Offer offer) {
        repository.save(offer);
    }
}
