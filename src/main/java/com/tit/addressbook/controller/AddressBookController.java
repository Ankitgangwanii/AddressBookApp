
package com.tit.addressbook.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/address")
public class AddressBookController {
    Map<Integer,String> addressMap;
    // Constructor
    public AddressBookController(){
        addressMap = new HashMap<>();

    }
    @GetMapping("/")
    public ResponseEntity<Map<Integer,String>> getAllAddress(){
        return ResponseEntity.ok(addressMap);
    }
    // method to get address by id
    @GetMapping("/get/{id}")
    public ResponseEntity<String> getAddressById(@PathVariable int id){
        if(addressMap.containsKey(id)){
            String address = addressMap.get(id);
            return ResponseEntity.ok(address);
        }
        return ResponseEntity.ok("id not found");
    }
    //method to post address
    @PostMapping("/post")
    public ResponseEntity<String> postAddress(@RequestParam int id,
                                              @RequestParam String address){
        addressMap.put(id,address);
        return ResponseEntity.ok("address stored successfully");
    }
    //method to put address
    @PutMapping("/put")
    public ResponseEntity<String> putAddress(@RequestParam int id,
                                             @RequestParam String address){
        //check if id present
        if(!addressMap.containsKey(id)){
            return ResponseEntity.ok("id not found");
        }
        addressMap.put(id,address);
        return ResponseEntity.ok("address updated successfully");
    }
    //method to delete address
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteAddress(@RequestParam int id){
        //check if id present
        if(!addressMap.containsKey(id)){
            return ResponseEntity.ok("id not found");
        }
        addressMap.remove(id);
        return ResponseEntity.ok("address deleted successfully");
    }
}
