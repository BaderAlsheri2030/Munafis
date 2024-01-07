package com.example.munafis.Controller;

import com.example.munafis.DTO.RfpDTO;
import com.example.munafis.Model.Offer;
import com.example.munafis.Model.Rfp;
import com.example.munafis.Service.RfpService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("api/v1/proposal")
@RequiredArgsConstructor
public class RfpController {

    private final RfpService rfpService;

    @GetMapping("get-all-proposals")
    public ResponseEntity getAllProposals(){
        return ResponseEntity.status(200).body(rfpService.getAll());
    }

    //create proposal using the company id and the competition id
    @PostMapping("{company_id}/create-proposal/{comp_id}")
    public ResponseEntity addProposal(@PathVariable Integer company_id,@PathVariable Integer comp_id, @Valid @RequestBody RfpDTO rfpDTO){
        rfpService.addRfp(rfpDTO,company_id,comp_id);
        return ResponseEntity.status(200).body("Proposal created");
    }

    @PutMapping("{company_id}/update-proposal/{rfp_id}")
    public ResponseEntity updateProposal(@PathVariable Integer rfp_id,@PathVariable Integer company_id,@Valid @RequestBody RfpDTO rfpDTO){
        rfpService.updateRfp(rfp_id,rfpDTO,company_id);
        return ResponseEntity.status(200).body("Proposal updated");
    }

    @DeleteMapping("delete-proposal/{rfp_id}")
    public ResponseEntity deleteProposal(@PathVariable Integer rfp_id){
        rfpService.deleteRfp(rfp_id);
        return ResponseEntity.status(200).body("Proposal deleted");
    }


    @PutMapping("/acceptOffer/{rfp_id}/{company_id}/{offer_id}")
    public ResponseEntity acceptOffer(@PathVariable Integer rfp_id,@PathVariable Integer company_id,@PathVariable Integer offer_id) {
        rfpService.acceptOffer(rfp_id,company_id,offer_id);
        return ResponseEntity.status(200).body("");

    }

    @GetMapping("/viewReceivedOffers/{rfp_id}")
    public ResponseEntity viewReceivedOffers(@PathVariable Integer rfp_id){
        List<Offer> offers = rfpService.viewReceivedOffers(rfp_id);
        return ResponseEntity.status(200).body(offers);
    }

    @GetMapping("/viewOffersByPrice/{rfp_id}/{min}/{max}")
    public ResponseEntity  viewOffersByPrice(@PathVariable Integer rfp_id,@PathVariable double min,@PathVariable double max){
        List<Offer> offers = rfpService.viewOffersByPrice(rfp_id,min,max);
        return ResponseEntity.status(200).body(offers);

    }

    @GetMapping("/findRfpsByDeadlineBefore{date}")
    public ResponseEntity findRfpsByDeadlineBefore(@PathVariable LocalDate date){
        Set<Rfp> rfps = rfpService.findRfpsBydeadlineBefore(date);
        return ResponseEntity.status(200).body(rfps);
    }
    @GetMapping("/findProposalsByLocation{location}")
    public ResponseEntity findProposalsByLocation(@PathVariable String location){
        Set<Rfp> rfps = rfpService.findProposalsByLocation(location);
        return ResponseEntity.status(200).body(rfps);
    }

    @GetMapping("/findProposalsByCompanyName{name}")
    public ResponseEntity findProposalsByCompanyName(@PathVariable String name){
        Set<Rfp> rfps = rfpService.findProposalsByCompanyName(name);
        return ResponseEntity.status(200).body(rfps);
    }

}