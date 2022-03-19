package md.utm.testgenerator.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import md.utm.testgenerator.entity.TaskComplexity;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class GeneralTaskDto {

    protected int id;
    protected TaskComplexity taskComplexity;
    protected String description;
    private AdminDto author;

}
