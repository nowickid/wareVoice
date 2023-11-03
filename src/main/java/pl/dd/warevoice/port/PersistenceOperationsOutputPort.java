package pl.dd.warevoice.port;

import pl.dd.warevoice.model.Delivery;
import pl.dd.warevoice.model.WarehouseItem;

import java.util.List;

public interface PersistenceOperationsOutputPort {

    Integer persist(WarehouseItem item);
    WarehouseItem getItemById(Integer id);
    List<WarehouseItem> getAllItems();
    Integer persist(Delivery item);

    List<Delivery> getDeliveriesForModel(Integer modelId);
}
