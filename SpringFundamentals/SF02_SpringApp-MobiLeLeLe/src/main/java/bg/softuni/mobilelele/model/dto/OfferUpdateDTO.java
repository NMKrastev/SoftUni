package bg.softuni.mobilelele.model.dto;

import bg.softuni.mobilelele.model.entity.ModelEntity;
import bg.softuni.mobilelele.model.enums.EngineEnum;
import bg.softuni.mobilelele.model.enums.TransmissionEnum;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class OfferUpdateDTO {

    private Long id;

    @NotNull
    @Positive
    private Long modelId;

    private ModelEntity model;

    @NotNull(message = "Price cannot be null.")
    @Positive(message = "Price must be positive number.")
    private BigDecimal price;

    @NotNull
    private EngineEnum engine;

    @NotNull
    private TransmissionEnum transmission;

    @NotNull
    @Min(1900)
    @Max(2024)
    private Integer year;

    @NotNull
    @Min(value = 0, message = "Mileage must be positive number.")
    private Double mileage;

    @NotEmpty(message = "Description cannot be empty.")
    private String description;

    @NotEmpty(message = "Image URL cannot be empty.")
    private String imageUrl;
}
