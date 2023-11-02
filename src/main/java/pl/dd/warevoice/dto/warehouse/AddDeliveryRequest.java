package pl.dd.warevoice.dto.warehouse;

import lombok.Data;

import java.util.Date;

@Data
public class AddDeliveryRequest {
    private Integer modelId;
    private Integer count;
    private Double price;
    private Date purchaseDate;
}
