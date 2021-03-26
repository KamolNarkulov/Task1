package uz.pdp.task1.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkerDto {
    @NotNull(message = "name bo'sh bolmasligi kerak!")
    private String name;

    @NotNull(message = "phoneNumber bo'sh bolmasligi kerak!")
    private String phoneNumber;

    @NotNull(message = "street bo'sh bolmasligi kerak!")
    private String street;

    @NotNull(message = "homeNumber bo'sh bolmasligi kerak!")
    private String homeNumber;

    @NotNull(message = "addressId bo'sh bolmasligi kerak!")
    private Integer addressId;

    @NotNull(message = "departmentId bo'sh bolmasligi kerak!")
    private Integer departmentId;
}
