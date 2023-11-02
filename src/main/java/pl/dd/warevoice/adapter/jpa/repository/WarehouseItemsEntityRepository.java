package pl.dd.warevoice.adapter.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dd.warevoice.adapter.jpa.entity.WarehouseItemEntity;

import java.util.List;

public interface WarehouseItemsEntityRepository extends JpaRepository<WarehouseItemEntity, Integer> {
}
