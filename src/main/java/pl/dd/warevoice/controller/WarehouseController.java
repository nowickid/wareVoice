package pl.dd.warevoice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import pl.dd.warevoice.dto.warehouse.AddDeliveryRequest;
import pl.dd.warevoice.dto.warehouse.CreateItemRequest;
import pl.dd.warevoice.port.WarehouseManagementInputPort;

@RequiredArgsConstructor
@RestController
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
public class WarehouseController {

    final WebApplicationContext appContext;

    @GetMapping("/items")
    public void items(){
        final WarehouseManagementInputPort warehouseManagementUseCase = getUseCase();
        warehouseManagementUseCase.getAllWarehouseItems();
    }

    @PostMapping("/create-item")
    public void createItem(@RequestBody CreateItemRequest createItemRequest){
        final WarehouseManagementInputPort warehouseManagementUseCase = getUseCase();
        warehouseManagementUseCase.insertWarehouseItem(createItemRequest);
    }

    @PostMapping("/add-delivery")
    public void addDelivery(@RequestBody AddDeliveryRequest addDeliveryRequest){
        final WarehouseManagementInputPort warehouseManagementUseCase = getUseCase();
        warehouseManagementUseCase.addDelivery(addDeliveryRequest);
    }

    private WarehouseManagementInputPort getUseCase() {
        return appContext.getBean(WarehouseManagementInputPort.class);
    }

}
