
package com.tit.addressbook.controller;
import com.tit.addressbook.dto.AddressBookDTO;
import com.tit.addressbook.model.AddressBookEntry;
import com.tit.addressbook.service.AddressBookService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@Validated
@RestController
@RequestMapping("/addressbook")
public class AddressBookController {
    private final AddressBookService addressBookService;

    public AddressBookController(AddressBookService addressBookService) {
        this.addressBookService = addressBookService;
    }

    @PostMapping
    public ResponseEntity<String> createEntry(@Valid @RequestBody AddressBookDTO dto) {
        String response = addressBookService.createEntry(dto);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<AddressBookEntry>> getAllEntries() {
        return ResponseEntity.ok(addressBookService.getAllEntries());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressBookEntry> getEntryById(@PathVariable Long id) {
        AddressBookEntry entry = addressBookService.getEntryById(id);
        return entry != null ? ResponseEntity.ok(entry) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateEntry(@PathVariable Long id, @Valid @RequestBody AddressBookDTO dto) {
        String response = addressBookService.updateEntry(id, dto);
        return response != null ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEntry(@PathVariable Long id) {
        String response = addressBookService.deleteEntry(id);
        return response != null ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
    }
}
