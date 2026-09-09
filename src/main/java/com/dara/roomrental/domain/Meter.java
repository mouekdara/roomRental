package com.dara.roomrental.domain;

import com.dara.roomrental.common.enums.MeterStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(
        name = "meters",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uq_room_charge_meter",
                        columnNames = {"room_id", "charge_type_id"}
                )
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Meter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "charge_type_id", nullable = false)

    private ChargeType chargeType;
    @Column(name = "meter_number", length = 100)
    private String meterNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private MeterStatus status;
    @Column(name = "installed_date")
    private LocalDate installedDate;
}
