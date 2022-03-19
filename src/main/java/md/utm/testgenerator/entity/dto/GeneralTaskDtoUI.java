package md.utm.testgenerator.entity.dto;

import lombok.Builder;
import lombok.Data;
import md.utm.testgenerator.entity.TaskComplexity;

@Data
@Builder
public class GeneralTaskDtoUI {

    protected TaskComplexity taskComplexity;
    protected String description;
    protected Long authorId;
    protected int complexity;

}
