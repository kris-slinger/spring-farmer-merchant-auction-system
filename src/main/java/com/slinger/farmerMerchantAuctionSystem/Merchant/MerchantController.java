package com.slinger.farmerMerchantAuctionSystem.Merchant;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users/merchant")
public class MerchantController {
    MerchantService merchantService;
    @Autowired
    public MerchantController(MerchantService merchantService){
        this.merchantService=merchantService;
    };
    @PostMapping(path="/new")
        public ResponseEntity<Merchant> createNewMerchant(@Valid @RequestBody Merchant MerchantDetails){
            System.out.println(MerchantDetails);
            try{
                return new ResponseEntity<Merchant>(merchantService.createNewMerchant(MerchantDetails),HttpStatus.CREATED);
            }
            catch(IllegalStateException e){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

    }
    @GetMapping
    public ResponseEntity<List<Merchant>> getAllMerchants(){
        return new ResponseEntity<List<Merchant>>(merchantService.getAllMerchants(), HttpStatus.OK);
    }
    @GetMapping(path="{merchantId}")
    public ResponseEntity<Optional<Merchant>> getMerchantById(@PathVariable Integer merchantId){
        return new ResponseEntity<Optional<Merchant>>(merchantService.getMerchantById(merchantId),HttpStatus.OK);

    }
    @PutMapping(path="{merchantId}")
    public ResponseEntity<Merchant>  updateUserById(@PathVariable Integer merchantId,@Valid @RequestBody Merchant merchantDetail){
        return  new ResponseEntity<Merchant>(merchantService.updateMerchantById(merchantId,merchantDetail),HttpStatus.OK);
    }
    @DeleteMapping(path="{merchantId}")
    public void deleteUserById(@PathVariable Integer merchantId){
        merchantService.deleteMerchant(merchantId);

    }


}
