package com.slinger.farmerMerchantAuctionSystem.Farmer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/users/farmer")
public class FarmerController {
    FarmerService farmerService;
    @Autowired
    public FarmerController(FarmerService farmerService){
        this.farmerService=farmerService;
    }

    @PostMapping(path="/new")
    public ResponseEntity<Farmer> createNewFarmer(@Valid @RequestBody Farmer farmer) {
        try{
            return new ResponseEntity<Farmer>(farmerService.createNewFarmer(farmer),HttpStatus.CREATED);
        }
        catch (IllegalStateException e){
            return new ResponseEntity<Farmer>(HttpStatus.BAD_REQUEST);

        }
    }
    @GetMapping
    public ResponseEntity<List<Farmer>> getAllFarmers(){
        return new ResponseEntity<List<Farmer>>(farmerService.getAllFarmers(),HttpStatus.OK);
    }
    @GetMapping(path="{farmerId}")
    public ResponseEntity<Optional<Farmer>> getFarmerById(@PathVariable Integer farmerId){
        return new ResponseEntity<Optional<Farmer>>(farmerService.getFarmerById(farmerId),HttpStatus.OK);
    }

    @DeleteMapping(path="{farmerId}")
    public ResponseEntity<Farmer> deleteFarmerById(@PathVariable Integer farmerId){
        return new ResponseEntity<Farmer>(HttpStatus.OK);
    }

}
