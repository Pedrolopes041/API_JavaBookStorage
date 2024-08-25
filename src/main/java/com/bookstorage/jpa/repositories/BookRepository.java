package com.bookstorage.jpa.repositories;

import com.bookstorage.jpa.modals.Bookmodal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookRepository extends JpaRepository<Bookmodal, UUID> {
}
