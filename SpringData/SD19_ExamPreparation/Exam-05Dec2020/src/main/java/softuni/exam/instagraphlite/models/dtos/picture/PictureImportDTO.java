package softuni.exam.instagraphlite.models.dtos.picture;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PictureImportDTO {

    private String path;

    private Double size;
}
