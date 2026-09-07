package com.dara.roomrental.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "property")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 100)
    private String name;
    @Column(nullable = false,columnDefinition = "TEXT")
    private String address;
    @Column(nullable = false, unique = true, length = 15)
    private String phone;
    @Column(nullable = false)
    private Boolean status;
    @Column(columnDefinition = "TEXT")
    private String description;

    // Join table user
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", nullable = false)
    private Users owner;
}
