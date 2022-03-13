package md.utm.testgenerator.entity.dto;

import lombok.Data;
import md.utm.testgenerator.entity.Admin;
import md.utm.testgenerator.entity.TaskComplexity;

@Data
public class GeneralTaskDto {

    protected int id;
    protected TaskComplexity taskComplexity;
    protected String description;
    protected Admin author;
    protected int complexity;

}
