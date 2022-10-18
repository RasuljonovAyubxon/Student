package uz.pdp.student.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Student {

    public Integer id;
    public String name;
    public Integer age;
    public String surname;

}
