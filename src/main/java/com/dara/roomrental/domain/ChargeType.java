package com.dara.roomrental.domain;

import com.dara.roomrental.common.enums.BillingMethod;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "charge_types")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChargeType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true, length = 50)
    private String code;
    @Column(nullable = false, length = 100)
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(name = "billing_method", nullable = false, length = 20)
    private BillingMethod billingMethod;
    @Column(name = "default_price", precision = 15, scale = 2)
    private BigDecimal defaultPrice;
    @Column(name = "is_active", nullable = false)
    private Boolean active;
}
