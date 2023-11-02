package pl.dd.warevoice.adapter.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "deliver")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private Integer count;

    @Column
    private Double price;

    @Column
    private Date purchaseDate;

    @Column(name = "ITEM_ID")
    private Integer warehouseItemId;

    @ManyToOne
    @JoinColumn(name = "ITEM_ID", referencedColumnName = "id", insertable = false, updatable = false)
    private WarehouseItemEntity warehouseItem;
}
