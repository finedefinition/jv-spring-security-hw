package mate.academy.model.dto;

import java.math.BigDecimal;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProductRequestDto {
    @NotNull
    @Size(min = 4, message = "The product name must be more than three characters.")
    private String name;
    @NotNull(message = "The brand cannot be empty.")
    private String brand;
    @NotNull(message = "The price cannot be empty.")
    @Min(value = 0)
    private BigDecimal price;
    // private Long categoryId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    //    public Long getCategoryId() {
    //        return categoryId;
    //    }
    //
    //    public void setCategoryId(Long categoryId) {
    //        this.categoryId = categoryId;
    //    }
}
