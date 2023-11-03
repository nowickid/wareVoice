package pl.dd.warevoice.adapter.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dd.warevoice.adapter.jpa.entity.DeliveryEntity;

import java.util.List;

public interface DeliveryEntityRepository extends JpaRepository<DeliveryEntity, Integer> {

    List<DeliveryEntity> findAllByWarehouseItemId(Integer warehouseItemId);
}
