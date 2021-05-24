package br.com.demo.demo.controllers;

import br.com.demo.demo.models.Address;
import br.com.demo.demo.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping()
    public ResponseEntity<Address> create(@RequestBody Address address) {
        return new ResponseEntity<>(addressService.create(address), HttpStatus.OK);
    }

    @PutMapping(path = "/{idAddress}")
    public ResponseEntity<Address> update(@RequestBody Address address) {
        return new ResponseEntity(addressService.update(address), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{idAddress}")
    public ResponseEntity<Address> findById(@PathVariable("idAddress") Long idAddress) {
        return new ResponseEntity<>(addressService.findById(idAddress), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Address>> getAll() {
        return ResponseEntity.ok().body(addressService.findAll());
    }
}
