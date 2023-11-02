package pl.dd.warevoice.port;

import pl.dd.warevoice.dto.warehouse.AddDeliveryRequest;
import pl.dd.warevoice.dto.warehouse.CreateItemRequest;
import pl.dd.warevoice.model.WarehouseItem;

public interface WarehouseManagementInputPort {

    void insertWarehouseItem(CreateItemRequest createItemRequest);
    void getAllWarehouseItems();

    void addDelivery(AddDeliveryRequest addDeliveryRequest);
}
