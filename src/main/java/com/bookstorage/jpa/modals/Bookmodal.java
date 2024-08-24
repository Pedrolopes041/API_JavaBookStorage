package com.bookstorage.jpa.modals;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "Book")
public class Bookmodal implements Serializable {
    private static final long serialVersionUID = 1L;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private UUID id;

    @Column(nullable = false, unique = true)
    private String title;

    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    @JoinColumn(name = "publisher_id")//add uma nova coluna que será a chave estrangeira
    private PublisherModal publisherModal;

    @ManyToMany
    @JoinTable(
            name = "TB_BOOK_AUTHOR",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private Set<AuthorModal> authors = new HashSet<>();

    @OneToOne(mappedBy = "bookmodal", cascade = CascadeType.ALL)
    private ReviewModal reviewModal;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public PublisherModal getPublisherModal() {
        return publisherModal;
    }

    public void setPublisherModal(PublisherModal publisherModal) {
        this.publisherModal = publisherModal;
    }

    public Set<AuthorModal> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<AuthorModal> authors) {
        this.authors = authors;
    }

    public ReviewModal getReviewModal() {
        return reviewModal;
    }

    public void setReviewModal(ReviewModal reviewModal) {
        this.reviewModal = reviewModal;
    }
}
