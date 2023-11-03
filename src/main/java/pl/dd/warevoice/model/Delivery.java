package pl.dd.warevoice.model;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Builder
@Getter
public class Delivery {
    private Integer modelId;
    private Integer count;
    private Double price;
    private Date purchaseDate;
}
