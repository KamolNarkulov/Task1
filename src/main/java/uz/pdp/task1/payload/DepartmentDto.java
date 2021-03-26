package uz.pdp.task1.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {
    @NotNull(message = "name bo'sh bolmasligi kerak!")
    private String name;

    @NotNull(message = "companyId bo'sh bolmasligi kerak!")
    private Integer companyId;
}
