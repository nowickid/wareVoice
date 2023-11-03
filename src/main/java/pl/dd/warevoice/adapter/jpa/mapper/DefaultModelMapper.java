package pl.dd.warevoice.adapter.jpa.mapper;

import org.springframework.stereotype.Service;
import pl.dd.warevoice.adapter.jpa.entity.DeliveryEntity;
import pl.dd.warevoice.adapter.jpa.entity.WarehouseItemEntity;
import pl.dd.warevoice.model.Delivery;
import pl.dd.warevoice.model.WarehouseItem;

@Service
public class DefaultModelMapper implements ModelMapper {
    @Override
    public WarehouseItemEntity map(WarehouseItem warehouseItem) {
        return WarehouseItemEntity.builder()
                .id(warehouseItem.getId())
                .model(warehouseItem.getModel())
                .build();
    }

    @Override
    public WarehouseItem map(WarehouseItemEntity warehouseItemEntity) {
        return WarehouseItem.builder()
                .id(warehouseItemEntity.getId())
                .model(warehouseItemEntity.getModel())
                .count(warehouseItemEntity.getDeliveries()
                        .stream()
                        .mapToInt(DeliveryEntity::getCount)
                        .sum())
                .build();
    }

    @Override
    public Delivery map(DeliveryEntity deliveryEntity) {
        return Delivery.builder()
                .purchaseDate(deliveryEntity.getPurchaseDate())
                .price(deliveryEntity.getPrice())
                .count(deliveryEntity.getCount())
                .build();
    }

    @Override
    public DeliveryEntity map(Delivery delivery) {
        return DeliveryEntity.builder()
                .purchaseDate(delivery.getPurchaseDate())
                .price(delivery.getPrice())
                .count(delivery.getCount())
                .warehouseItemId(delivery.getModelId())
                .build();
    }
}
