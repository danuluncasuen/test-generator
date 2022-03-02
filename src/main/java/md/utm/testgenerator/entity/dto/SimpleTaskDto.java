package md.utm.testgenerator.entity.dto;

import lombok.Data;

import java.util.List;

@Data
public class SimpleTaskDto {

    private String question;
    private List<AnswerDto> answers;
    private int complexity;
    private Long authorID;

}
