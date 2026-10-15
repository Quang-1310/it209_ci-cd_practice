package ra.edu.ptit_cntt2_it211_practice.model.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ra.edu.ptit_cntt2_it211_practice.model.entity.Status;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MedicationDTO {
    @NotBlank(message = "Tên thuốc không được để trống")
    private String name;

    @NotBlank(message = "Nhà sản xuất không được để trống")
    private String manufacturer;

    @NotNull(message = "Giá bán không được để trống")
    @Min(value = 1, message = "Giá tối thiểu trên 1 VNĐ")
    private Double price;

    @NotBlank(message = "Trạng thái không được để trống")
    @Pattern(regexp = "AVAILABLE|OUT_OF_STOCK", message = "Trạng thái không hợp lệ")
    private Status status;
}
