package com.bookstorage.jpa.repositories;

import com.bookstorage.jpa.modals.PublisherModal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PublisherRepository extends JpaRepository<PublisherModal, UUID> {
}
