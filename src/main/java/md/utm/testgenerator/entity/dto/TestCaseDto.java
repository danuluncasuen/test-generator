package md.utm.testgenerator.entity.dto;

import lombok.Data;

@Data
public class TestCaseDto {
    private Long id;
    private String input;
    private String expectedOutput;
}
