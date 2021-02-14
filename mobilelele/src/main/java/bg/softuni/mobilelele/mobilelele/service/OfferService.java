package bg.softuni.mobilelele.mobilelele.service;

import bg.softuni.mobilelele.mobilelele.model.service.OfferServiceModel;
import bg.softuni.mobilelele.mobilelele.model.view.OfferSummaryViewModel;

import java.util.List;

public interface OfferService {

    List<OfferSummaryViewModel> getAllOffers();

    Long save(OfferServiceModel model);
}
