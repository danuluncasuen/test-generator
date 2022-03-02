package md.utm.testgenerator.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AnswerDto {
    private Long id;
    private String answer;
    @JsonProperty("isCorrect")
    private boolean isCorrect;
}
