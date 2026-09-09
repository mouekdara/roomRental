package com.dara.roomrental.domain;


import com.dara.roomrental.common.enums.DepositTransactionType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "deposit_transactions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DepositTransaction {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contract_id", nullable = false)
    private RentalContract contract;
    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_type", nullable = false, length = 30)
    private DepositTransactionType transactionType;
    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal amount;
    @Column(name = "transaction_date", nullable = false)
    private LocalDate transactionDate;
    @Column(name = "reference_number", length = 100)
    private String referenceNumber;
    @Column(columnDefinition = "TEXT")
    private String note;

}
