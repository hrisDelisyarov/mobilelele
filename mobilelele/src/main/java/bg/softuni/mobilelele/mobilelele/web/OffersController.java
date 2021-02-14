package bg.softuni.mobilelele.mobilelele.web;

import bg.softuni.mobilelele.mobilelele.model.entities.enums.OffersEngineEnum;
import bg.softuni.mobilelele.mobilelele.model.entities.enums.TransmissionTypeEnum;
import bg.softuni.mobilelele.mobilelele.model.service.OfferServiceModel;
import bg.softuni.mobilelele.mobilelele.service.BrandService;
import bg.softuni.mobilelele.mobilelele.service.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/offers")
public class OffersController {


    private final OfferService offerService;
    private final BrandService brandService;

    @ModelAttribute("offerModel")
    public OfferServiceModel offerModel(){
        return new OfferServiceModel();
    }
    public OffersController(OfferService offerService, BrandService brandService)
    {

        this.offerService = offerService;
        this.brandService = brandService;
    }
    @GetMapping("/all")
    public String getAllOffers(Model model){
        model.addAttribute("offers", offerService.getAllOffers());

        return "offers";
    }

    @GetMapping("/add")
    public String getOffersAdd(Model model){
        model.addAttribute("brands", brandService.getAllBrands());
        model.addAttribute("engines", OffersEngineEnum.values());
        model.addAttribute("transmissions", TransmissionTypeEnum.values());
        return "offer-add";
    }

    @PostMapping("/offers/add")
    public String createOffer(@ModelAttribute OfferServiceModel offerModel){

        offerService.save(offerModel);

        System.out.println(offerModel.toString());
        return "redirect:/offers/all";
    }
}
