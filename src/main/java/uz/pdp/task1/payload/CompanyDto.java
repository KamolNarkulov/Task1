package uz.pdp.task1.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDto {
    @NotNull(message = "corpName bo'sh bolmasligi kerak!")
    private String corpName;

    @NotNull(message = "directorName bo'sh bolmasligi kerak!")
    private String directorName;

    @NotNull(message = "addressId bo'sh bolmasligi kerak!")
    private Integer addressId;

    @NotNull(message = "street bo'sh bolmasligi kerak!")
    private String street;

    @NotNull(message = "homeNumber bo'sh bolmasligi kerak!")
    private String homeNumber;
}
