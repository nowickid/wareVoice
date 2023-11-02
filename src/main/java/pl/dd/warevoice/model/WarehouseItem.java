package pl.dd.warevoice.model;


import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Builder
@Getter
public class WarehouseItem {
    private Integer id;
    private String model;
    private Integer count;
}
