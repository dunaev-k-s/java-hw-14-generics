package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Offer;
import ru.netology.repository.OfferRepository;

import java.util.Arrays;

@NoArgsConstructor
@Data
public class OfferManager {
    OfferRepository repository = new OfferRepository();
    public OfferManager(OfferRepository repository){
        this.repository = repository;
    }



    public Offer[] findAll(String from, String to) {
        Offer[] result = new Offer[0];
        for (Offer offer : repository.getAll()) {
            if (from == offer.getDeparture() && to == offer.getArrival()){
                Offer[] tmp = new Offer[result.length + 1];
                System.arraycopy(result,0,tmp,0,result.length);
                tmp[tmp.length - 1] = offer;
                if (tmp.length != 1) {
                    for (int i = 0; i < (tmp.length -1); i++ ) {
                        Offer temp = new Offer();
                        if (tmp[i].compareTo(tmp[i+1]) == 1){
                            temp = tmp[i];
                            tmp[i] = tmp[i + 1];
                            tmp[i + 1] = temp;
                        }
                    }
                }
                result = tmp;
            }
        }
        return result;

    }

    public void add(Offer offer) {
        repository.save(offer);
    }
}
