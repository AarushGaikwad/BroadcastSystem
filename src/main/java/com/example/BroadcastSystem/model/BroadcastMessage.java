package com.example.BroadcastSystem.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
@Data
@Getter
@Setter
@ToString
public class BroadcastMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 500)
    private String messageText;

    @Column(nullable = false, length = 20)
    private String type;

    @Column(length = 20)
    private String backgroundColor;

    @Column(nullable = false)
    private Boolean isDismissible;

    @Column(nullable = false)
    private LocalDateTime startTimestamp;

    @Column(nullable = false)
    private LocalDateTime endTimestamp;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @PrePersist
    @PreUpdate
    private void onPersistOrUpdate() {
        // Set timestamps
        if (createdAt == null) {
            this.createdAt = LocalDateTime.now();
        }
        this.updatedAt = LocalDateTime.now();

        // Validate message text length
        if (messageText != null && messageText.length() > 500) {
            throw new IllegalArgumentException("Message text must not exceed 500 characters.");
        }

        // Validate type
        if (type == null || (!type.equalsIgnoreCase("banner") && !type.equalsIgnoreCase("notification"))) {
            throw new IllegalArgumentException("Type must be either 'banner' or 'notification'.");
        }
    }

}

