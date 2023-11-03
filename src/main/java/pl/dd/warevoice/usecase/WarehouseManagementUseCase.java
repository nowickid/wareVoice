package pl.dd.warevoice.usecase;

import pl.dd.warevoice.dto.warehouse.AddDeliveryRequest;
import pl.dd.warevoice.dto.warehouse.CreateItemRequest;
import pl.dd.warevoice.model.Delivery;
import pl.dd.warevoice.model.WarehouseItem;
import pl.dd.warevoice.port.PersistenceOperationsOutputPort;
import pl.dd.warevoice.port.RestPresenterOutputPort;
import pl.dd.warevoice.port.WarehouseManagementInputPort;

public class WarehouseManagementUseCase implements WarehouseManagementInputPort {
    private final RestPresenterOutputPort restPresenter;
    private final PersistenceOperationsOutputPort persistenceOps;

    public WarehouseManagementUseCase(RestPresenterOutputPort restPresenter, PersistenceOperationsOutputPort persistenceOps) {
        this.restPresenter = restPresenter;
        this.persistenceOps = persistenceOps;
    }

    @Override
    public void insertWarehouseItem(CreateItemRequest createItemRequest) {
        final Integer id = persistenceOps.persist(WarehouseItem.builder()
                .model(createItemRequest.getModel())
                .build());

        restPresenter.presentOk(id);
    }

    @Override
    public void getAllWarehouseItems() {
        restPresenter.presentOk(persistenceOps.getAllItems());
    }

    @Override
    public void addDelivery(AddDeliveryRequest addDeliveryRequest) {
        final Integer id = persistenceOps.persist(Delivery.builder()
                .price(addDeliveryRequest.getPrice())
                .count(addDeliveryRequest.getCount())
                .purchaseDate(addDeliveryRequest.getPurchaseDate())
                .modelId(addDeliveryRequest.getModelId())
                .build());

        restPresenter.presentOk(id);
    }

    @Override
    public void getDeliveriesForModel(Integer modelId) {
        restPresenter.presentOk(persistenceOps.getDeliveriesForModel(modelId));
    }
}
