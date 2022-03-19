package md.utm.testgenerator.entity.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TestCaseDto {
    private Long id;
    private String input;
    private String expectedOutput;
}
