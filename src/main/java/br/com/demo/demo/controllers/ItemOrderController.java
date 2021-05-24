package br.com.demo.demo.controllers;

import br.com.demo.demo.models.ItemOrder;
import br.com.demo.demo.services.ItemOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ItemOrderController")
public class ItemOrderController {

    @Autowired
    private ItemOrderService itemOrderService;

    @PostMapping()
    public ResponseEntity<ItemOrder> create(@RequestBody ItemOrder itemOrder) {
        return new ResponseEntity<>(itemOrderService.create(itemOrder), HttpStatus.OK);
    }

    @PutMapping(path = "/{idItemOrder}")
    public ResponseEntity<ItemOrder> update(@RequestBody ItemOrder itemOrder) {
        return new ResponseEntity(itemOrderService.update(itemOrder), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{idItemOrder}")
    public ResponseEntity<ItemOrder> findById(@PathVariable("idItemOrder") Long idItemOrder) {
        return new ResponseEntity<>(itemOrderService.findById(idItemOrder), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<ItemOrder>> getAll() {
        return ResponseEntity.ok().body(itemOrderService.findAll());
    }
}
