package pl.dd.warevoice.adapter.jpa.mapper;

import pl.dd.warevoice.adapter.jpa.entity.DeliveryEntity;
import pl.dd.warevoice.adapter.jpa.entity.WarehouseItemEntity;
import pl.dd.warevoice.model.Delivery;
import pl.dd.warevoice.model.WarehouseItem;

public interface ModelMapper {
    WarehouseItemEntity map(WarehouseItem warehouseItem);
    WarehouseItem map(WarehouseItemEntity warehouseItemEntity);

    Delivery map (DeliveryEntity deliveryEntity);
    DeliveryEntity map (Delivery delivery);


}
