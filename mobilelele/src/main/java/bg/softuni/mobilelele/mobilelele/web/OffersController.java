package bg.softuni.mobilelele.mobilelele.web;

import bg.softuni.mobilelele.mobilelele.model.entities.enums.OffersEngineEnum;
import bg.softuni.mobilelele.mobilelele.model.entities.enums.TransmissionTypeEnum;
import bg.softuni.mobilelele.mobilelele.model.service.OfferServiceModel;
import bg.softuni.mobilelele.mobilelele.service.BrandService;
import bg.softuni.mobilelele.mobilelele.service.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.DeleteMapping;
import javax.validation.Valid;

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
    //TODO: DETAILS MAN
    @GetMapping("/offer/{id}")
    public String offerDetails(@PathVariable String id,
                               Model model){
        model.addAttribute("id",id);
        return "details";
    }

    @DeleteMapping("/offer/{id}")
    public String offerDelete(@PathVariable Long id,
                               Model model) {
        offerService.delete(id);
        return "redirect:/offers/all";
    }
    @PostMapping("/offers/add")
    public String createOffer(@Valid @ModelAttribute OfferServiceModel offerModel,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes)
    {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("offerModel", offerModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.offerModel", bindingResult);


            return "redirect:/offers/add";
        }
        Long newOfferId=offerService.save(offerModel);

        //System.out.println(offerModel.toString());
        return "redirect:/offers/offer/" + newOfferId;
    }
}
