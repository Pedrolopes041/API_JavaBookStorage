package com.bookstorage.jpa.modals;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "Review")
public class ReviewModal implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String comment;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToOne
    @JoinColumn(name = "book_id")
    private Bookmodal bookmodal;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {

        this.id = id;
    }

    public String getComment() {

        return comment;
    }

    public void setComment(String comment) {

        this.comment = comment;
    }

    public Bookmodal getBookmodal() {
        return bookmodal;
    }

    public void setBookmodal(Bookmodal bookmodal) {
        this.bookmodal = bookmodal;
    }
}
