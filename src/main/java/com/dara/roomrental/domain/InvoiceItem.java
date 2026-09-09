package com.dara.roomrental.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "invoice_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvoiceItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "invoice_id", nullable = false)
    private Invoice invoice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "charge_type_id")
    private ChargeType chargeType;
    @Column(nullable = false, length = 255)
    private String description;
    @Column(nullable = false, precision = 15, scale = 3)
    private BigDecimal quantity;
    @Column(name = "unit_price", nullable = false, precision = 15, scale = 4)
    private BigDecimal unitPrice; @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal amount;
}
