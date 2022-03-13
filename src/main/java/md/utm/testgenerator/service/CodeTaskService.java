package md.utm.testgenerator.service;

import lombok.AllArgsConstructor;
import lombok.experimental.SuperBuilder;
import md.utm.testgenerator.db.CodeTaskRepository;
import md.utm.testgenerator.db.TestCaseRepository;
import md.utm.testgenerator.entity.CodeTask;
import md.utm.testgenerator.entity.TestCase;
import md.utm.testgenerator.entity.dto.CodeTaskDto;
import md.utm.testgenerator.entity.dto.TestCaseDto;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CodeTaskService {

    private CodeTaskRepository codeTaskRepository;
    private TestCaseRepository testCaseRepository;

    public void addNew(CodeTaskDto codeTaskDto) {
        for (TestCaseDto testCaseDto:codeTaskDto.getTestCases()) {
            testCaseRepository.save(TestCase.builder()
                    .expectedOutput(testCaseDto.getExpectedOutput())
                    .input(testCaseDto.getInput())
                    .build());
        }
        codeTaskRepository.save(
                CodeTask.builder()
                        .description(codeTaskDto.getDescription())
                        .methodSignature(codeTaskDto.getMethodSignature())
                        .language(codeTaskDto.getLanguage())
                        .build());
    }
}
