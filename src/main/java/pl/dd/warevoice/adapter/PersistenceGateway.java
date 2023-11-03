package pl.dd.warevoice.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Service;
import pl.dd.warevoice.adapter.jpa.entity.DeliveryEntity;
import pl.dd.warevoice.adapter.jpa.entity.WarehouseItemEntity;
import pl.dd.warevoice.adapter.jpa.mapper.ModelMapper;
import pl.dd.warevoice.adapter.jpa.repository.DeliveryEntityRepository;
import pl.dd.warevoice.adapter.jpa.repository.WarehouseItemsEntityRepository;
import pl.dd.warevoice.model.Delivery;
import pl.dd.warevoice.model.WarehouseItem;
import pl.dd.warevoice.port.PersistenceOperationsOutputPort;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersistenceGateway implements PersistenceOperationsOutputPort {

    final WarehouseItemsEntityRepository warehouseRepository;
    final DeliveryEntityRepository deliveryRepository;

    final NamedParameterJdbcOperations jdbcOps;
    final ModelMapper mapper;

    @Override
    public Integer persist(WarehouseItem item) {
        return warehouseRepository.save(mapper.map(item)).getId();
    }

    @Override
    public Integer persist(Delivery item) {
        return deliveryRepository.save(mapper.map(item)).getId();
    }

    @Override
    public List<Delivery> getDeliveriesForModel(Integer modelId) {
        return deliveryRepository.findAllByWarehouseItemId(modelId)
                .stream()
                .map(mapper::map)
                .collect(Collectors.toList());

    }


    @Override
    public WarehouseItem getItemById(Integer id) {
        return mapper.map(warehouseRepository.findById(id).orElse(new WarehouseItemEntity()));
    }

    @Override
    public List<WarehouseItem> getAllItems() {
         return warehouseRepository.findAll()
                 .stream()
                 .map(mapper::map)
                 .collect(Collectors.toList());
    }
}
