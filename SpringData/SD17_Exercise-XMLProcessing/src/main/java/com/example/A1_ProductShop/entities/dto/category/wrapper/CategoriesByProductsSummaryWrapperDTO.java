package com.example.A1_ProductShop.entities.dto.category.wrapper;

import com.example.A1_ProductShop.entities.dto.category.CategoryByProductsSummaryDTO;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoriesByProductsSummaryWrapperDTO {

    @XmlElement(name = "category")
    private List<CategoryByProductsSummaryDTO> categories;
}
