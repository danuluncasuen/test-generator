package md.utm.testgenerator.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnswerDto {
    private Long id;
    private String answer;
    @JsonProperty("isCorrect")
    private boolean isCorrect;
}
