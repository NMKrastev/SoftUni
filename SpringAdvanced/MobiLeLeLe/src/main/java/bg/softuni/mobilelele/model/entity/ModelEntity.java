package bg.softuni.mobilelele.model.entity;

import bg.softuni.mobilelele.model.enums.CategoryEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "models")
public class ModelEntity extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CategoryEnum category;

    //By requirement should be VARCHAR(512). Could be BLOB if needed.
    @Column(name = "image_url", columnDefinition = "TEXT")
    @Size(min = 8, max = 512)
    private String imageUrl;

    @Column(name = "star_year")
    private Integer startYear;

    @Column(name = "end_year")
    private Integer endYear;

    @Column
    private LocalDateTime created;

    @Column
    private LocalDateTime modified;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private BrandEntity brand;

    @OneToMany(mappedBy = "model")
    private List<OfferEntity> offer;

/*    @Override
    public String toString() {
        return "ModelEntity{" +
                "name='" + name + '\'' +
                ", category=" + category +
                ", imageUrl='" + imageUrl + '\'' +
                ", startYear=" + startYear +
                ", endYear=" + endYear +
                ", created=" + created +
                ", modified=" + modified +
                ", brand=" + (brand != null ? brand.getName() : null) +
                ", offer=" + offer +
                '}';
    }*/
}
