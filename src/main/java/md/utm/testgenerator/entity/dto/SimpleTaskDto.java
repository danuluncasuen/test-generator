package md.utm.testgenerator.entity.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class SimpleTaskDto extends GeneralTaskDto{

    private String question;
    private List<AnswerDto> answers;
    private Long authorID;

}
