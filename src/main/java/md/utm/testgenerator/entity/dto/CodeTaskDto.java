package md.utm.testgenerator.entity.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class CodeTaskDto extends GeneralTaskDto{
    private String methodSignature;
    private Language language;
    private List<TestCaseDto> testCases;
}
