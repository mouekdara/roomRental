package com.dara.roomrental.domain;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(
        name = "meter_readings",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uq_meter_billing_month",
                        columnNames = {"meter_id", "billing_year", "billing_month"}
                )
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MeterReading {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "meter_id", nullable = false)
    private Meter meter;
    @Column(name = "billing_year", nullable = false)
    private Integer billingYear;
    @Column(name = "billing_month", nullable = false)
    private Integer billingMonth;
    @Column(name = "reading_date", nullable = false)
    private LocalDate readingDate;
    @Column(name = "previous_reading", nullable = false, precision = 15, scale = 3)
    private BigDecimal previousReading;
    @Column(name = "current_reading", nullable = false, precision = 15, scale = 3)
    private BigDecimal currentReading;
    @Column(name = "usage_quantity", nullable = false, precision = 15, scale = 3)
    private BigDecimal usageQuantity;
    @Column(name = "unit_price", nullable = false, precision = 15, scale = 4)
    private BigDecimal unitPrice;
    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal amount;
}
