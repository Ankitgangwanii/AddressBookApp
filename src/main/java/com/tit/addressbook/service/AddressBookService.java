package com.tit.addressbook.service;
import com.tit.addressbook.dto.AddressBookDTO;
import com.tit.addressbook.model.AddressBookEntry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.*;
@Slf4j
@Service
public class AddressBookService {
    private final List<AddressBookEntry> entries = new ArrayList<>();
    private long idCounter = 1;

    public String createEntry(AddressBookDTO dto) {
        AddressBookEntry entry = new AddressBookEntry(idCounter++, dto.getName(), dto.getAddress(), dto.getPhone(), dto.getEmail());
        entries.add(entry);
        log.info("THis is my entry"+entry);
        return "Entry created with ID: " + entry.getId();
    }

    public List<AddressBookEntry> getAllEntries() {
        log.info("Fetching all address book entries.");
        return entries;
    }

    public AddressBookEntry getEntryById(Long id) {
        return entries.stream().filter(e -> e.getId().equals(id)).findFirst().orElse(null);
    }

    public String updateEntry(Long id, AddressBookDTO dto) {
        Optional<AddressBookEntry> optionalEntry = entries.stream().filter(e -> e.getId().equals(id)).findFirst();
        if (optionalEntry.isPresent()) {
            AddressBookEntry entry = optionalEntry.get();
            entry.setName(dto.getName());
            entry.setAddress(dto.getAddress());
            entry.setPhone(dto.getPhone());
            entry.setEmail(dto.getEmail());
            return "Entry updated";
        }
        return null;
    }

    public String deleteEntry(Long id) {
        return entries.removeIf(e -> e.getId().equals(id)) ? "Entry deleted" : null;
    }
}