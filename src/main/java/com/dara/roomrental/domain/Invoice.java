package com.dara.roomrental.domain;


import com.dara.roomrental.common.entity.BaseEntity;
import com.dara.roomrental.common.enums.InvoiceStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(
        name = "invoices",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uq_contract_billing_period",
                        columnNames = {
                                "contract_id",
                                "billing_year",
                                "billing_month"
                        }
                )
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Invoice extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "invoice_number", nullable = false, unique = true)
    private String invoiceNumber;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contract_id", nullable = false)
    private RentalContract contract;
    @Column(name = "billing_year", nullable = false)
    private Integer billingYear;
    @Column(name = "billing_month", nullable = false)
    private Integer billingMonth;
    @Column(name = "issue_date", nullable = false)
    private LocalDate issueDate;
    @Column(name = "due_date", nullable = false)
    private LocalDate dueDate;
    @Column(name = "subtotal_amount", nullable = false, precision = 15, scale = 2)
    private BigDecimal subtotalAmount;
    @Column(name = "discount_amount", nullable = false, precision = 15, scale = 2)
    private BigDecimal discountAmount;
    @Column(name = "total_amount", nullable = false, precision = 15, scale = 2)
    private BigDecimal totalAmount;
    @Column(name = "paid_amount", nullable = false, precision = 15, scale = 2)
    private BigDecimal paidAmount;
    @Column(name = "balance_amount", nullable = false, precision = 15, scale = 2)
    private BigDecimal balanceAmount;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private InvoiceStatus status;

    @Column(columnDefinition = "TEXT")
    private String note;
    @OneToMany( mappedBy = "invoice", cascade = CascadeType.ALL, orphanRemoval = true )
    private List<InvoiceItem> items = new ArrayList<>();

}
