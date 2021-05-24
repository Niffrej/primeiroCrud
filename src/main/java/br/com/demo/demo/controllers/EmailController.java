package br.com.demo.demo.controllers;

import br.com.demo.demo.models.Email;
import br.com.demo.demo.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping()
    public ResponseEntity<Email> create(@RequestBody Email email) {
        return new ResponseEntity<>(emailService.create(email), HttpStatus.OK);
    }

    @PutMapping(path = "/{idEmail}")
    public ResponseEntity<Email> update(@RequestBody Email email) {
        return new ResponseEntity(emailService.update(email), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{idEmail}")
    public ResponseEntity<Email> findById(@PathVariable("idEmail") Long idEmail) {
        return new ResponseEntity<>(emailService.findById(idEmail), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Email>> getAll() {
        return ResponseEntity.ok().body(emailService.findAll());
    }
}
