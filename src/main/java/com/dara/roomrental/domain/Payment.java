package com.dara.roomrental.domain;

import com.dara.roomrental.common.entity.BaseEntity;
import com.dara.roomrental.common.enums.PaymentMethod;
import com.dara.roomrental.common.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.*;
import org.apache.catalina.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "payments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "receipt_number", nullable = false, unique = true)
    private String receiptNumber;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tenant_id", nullable = false)
    private Tenant tenant;
    @Column(name = "payment_date", nullable = false)
    private LocalDateTime paymentDate;
    @Column(name = "total_amount", nullable = false, precision = 15, scale = 2)
    private BigDecimal totalAmount;
    @Enumerated(EnumType.STRING)
    @Column(name = "payment_method", nullable = false, length = 30)
    private PaymentMethod paymentMethod;
    @Column(name = "reference_number", length = 150)
    private String referenceNumber;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private PaymentStatus status;
    @Column(columnDefinition = "TEXT")
    private String note;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by")
    private Users createdBy;
    @OneToMany( mappedBy = "payment", cascade = CascadeType.ALL, orphanRemoval = true )
    private List<PaymentAllocation> allocations = new ArrayList<>();
}
