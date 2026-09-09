package com.dara.roomrental.domain;

import com.dara.roomrental.common.enums.TenantStatus;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "tenants")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Tenant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;
    @Column(name = "last_name", length = 100)
    private String lastName;
    @Column(nullable = false, unique = true, length = 30)
    private String phone;
    @Column(length = 150)
    private String email;
    @Column(name = "id_card_number", length = 100)
    private String idCardNumber;
    @Column(name = "emergency_contact", length = 150)
    private String emergencyContact;
    @Column(name = "emergency_phone", length = 30)
    private String emergencyPhone;
    @Column(columnDefinition = "TEXT")
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private TenantStatus status;
}
