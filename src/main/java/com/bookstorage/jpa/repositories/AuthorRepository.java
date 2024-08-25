package com.bookstorage.jpa.repositories;

import com.bookstorage.jpa.modals.AuthorModal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthorRepository extends JpaRepository<AuthorModal, UUID> {
}
