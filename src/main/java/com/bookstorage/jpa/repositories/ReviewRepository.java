package com.bookstorage.jpa.repositories;

import com.bookstorage.jpa.modals.ReviewModal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReviewRepository extends JpaRepository<ReviewModal, UUID> {
}
