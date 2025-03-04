package com.tit.addressbook.service;

import com.tit.addressbook.dto.AddressBookDTO;
import com.tit.addressbook.model.AddressBookEntry;
import com.tit.addressbook.repository.AddressBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class AddressBookService {
    private final AddressBookRepository addressBookRepository;

    public AddressBookService(AddressBookRepository addressBookRepository) {
        this.addressBookRepository = addressBookRepository;
    }

    public String createEntry(AddressBookDTO dto) {
        AddressBookEntry entry = new AddressBookEntry(null, dto.getName(), dto.getAddress(), dto.getPhone(), dto.getEmail());
        AddressBookEntry savedEntry = addressBookRepository.save(entry);
        log.info("New entry created: {}", savedEntry);
        return "Entry created with ID: " + savedEntry.getId();
    }

    public List<AddressBookEntry> getAllEntries() {
        log.info("Fetching all address book entries.");
        return addressBookRepository.findAll();
    }

    public AddressBookEntry getEntryById(Long id) {
        return addressBookRepository.findById(id).orElse(null);
    }

    public String updateEntry(Long id, AddressBookDTO dto) {
        Optional<AddressBookEntry> optionalEntry = addressBookRepository.findById(id);
        if (optionalEntry.isPresent()) {
            AddressBookEntry entry = optionalEntry.get();
            entry.setName(dto.getName());
            entry.setAddress(dto.getAddress());
            entry.setPhone(dto.getPhone());
            entry.setEmail(dto.getEmail());
            addressBookRepository.save(entry);
            return "Entry updated";
        }
        return null;
    }

    public String deleteEntry(Long id) {
        if (addressBookRepository.existsById(id)) {
            addressBookRepository.deleteById(id);
            return "Entry deleted";
        }
        return null;
    }
}
