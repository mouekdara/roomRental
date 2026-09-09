package com.dara.roomrental.domain;

import com.dara.roomrental.common.enums.ContractStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(
        name = "rental_contracts",
        indexes = {
                @Index(name = "idx_contract_room", columnList = "room_id"),
                @Index(name = "idx_contract_tenant", columnList = "tenant_id")
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RentalContract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "contract_number", nullable = false, unique = true)
    private String contractNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tenant_id", nullable = false)
    private Tenant tenant;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "monthly_rent", nullable = false, precision = 15, scale = 2)
    private BigDecimal monthlyRent;

    @Column(name = "security_deposit", nullable = false, precision = 15, scale = 2)
    private BigDecimal securityDeposit;

    @Column(name = "billing_day", nullable = false)
    private Integer billingDay;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private ContractStatus status;

    @Column(columnDefinition = "TEXT")
    private String note;
}
