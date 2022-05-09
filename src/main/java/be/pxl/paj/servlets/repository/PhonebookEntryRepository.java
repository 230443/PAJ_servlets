package be.pxl.paj.servlets.repository;

import be.pxl.paj.servlets.domain.PhonebookEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhonebookEntryRepository extends JpaRepository<PhonebookEntry, Long> {
}