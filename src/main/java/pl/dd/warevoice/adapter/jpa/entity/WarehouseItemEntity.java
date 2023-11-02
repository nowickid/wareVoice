package pl.dd.warevoice.adapter.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "warehouseItem")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WarehouseItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String model;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="ITEM_ID")
    private Set<DeliveryEntity> deliveries;
}
