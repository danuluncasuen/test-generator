package md.utm.testgenerator.entity.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@Data
public class SimpleTaskDto extends GeneralTaskDto {

    private String question;
    private List<AnswerDto> answers;
    private Long authorID;

}
