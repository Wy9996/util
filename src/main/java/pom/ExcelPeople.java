package pom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExcelPeople {
    private String name;
    private String age;
    private String sex;
    private String area;
}
