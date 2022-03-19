package md.utm.testgenerator.service;

import lombok.AllArgsConstructor;
import md.utm.testgenerator.db.CodeTaskRepository;
import md.utm.testgenerator.db.SimpleTaskRepository;
import md.utm.testgenerator.db.TestRepository;
import md.utm.testgenerator.entity.*;
import md.utm.testgenerator.entity.dto.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TestService {

    private final SimpleTaskRepository simpleTaskRepository;
    private final CodeTaskRepository codeTaskRepository;
    private final TestRepository testRepository;

    public void addNewTest(TestDtoUI testDto) {
        Test test = new Test();
        test.setTime(testDto.getTime());
        List<GeneralTask> generalTaskList = new ArrayList<>();
        for (Long simpleTask : testDto.getSimpleTasks()) {
            generalTaskList.add(simpleTaskRepository.getById(simpleTask));
        }
        for (Long codeTask : testDto.getCodeTasks()) {
            generalTaskList.add(codeTaskRepository.getById(codeTask));
        }
        test.setTasks(generalTaskList);
        testRepository.save(test);
    }

    public TestDto getTest(Long id) {
        Test test = testRepository.getById(id);
        List<GeneralTaskDto> generalTaskDtoList = new ArrayList<>();
        for (GeneralTask generalTask : test.getTasks()) {
            AdminDto author = AdminDto.builder()
                    .id(generalTask.getAuthor().getId())
                    .username(generalTask.getAuthor().getUsername())
                    .build();
            GeneralTaskDto generalTaskDto = GeneralTaskDto.builder()
                    .description(generalTask.getDescription())
                    .id(generalTask.getId())
                    .taskComplexity(generalTask.getTaskComplexity())
                    .author(author)
                    .build();
            if (generalTaskDto instanceof CodeTaskDto) {
                ((CodeTaskDto) generalTaskDto).setLanguage(((CodeTaskDto)generalTaskDto).getLanguage());
                List<TestCaseDto> testCaseDtos = new ArrayList<>();
                for (TestCase testCase : ((CodeTask)generalTask).getTestCases()) {
                    testCaseDtos.add(
                            TestCaseDto.builder()
                                    .input(testCase.getInput())
                                    .expectedOutput(testCase.getExpectedOutput())
                                    .build()
                    );
                }
                ((CodeTaskDto) generalTaskDto).setTestCases(testCaseDtos);
            } else if (generalTask instanceof SimpleTask) {
                List<AnswerDto> answerDtos = new ArrayList<>();
                for (Answer answer : ((SimpleTask)generalTask).getAnswers()) {
                    answerDtos.add(
                            AnswerDto.builder()
                                    .id(answer.getId())
                                    .answer(answer.getAnswer())
                                    .build()
                    );
                }
                ((SimpleTaskDto) generalTaskDto).setAnswers(answerDtos);
            }
            generalTaskDtoList.add(generalTaskDto);
        }
        return TestDto.builder()
                .time(test.getTime())
                .tasks(generalTaskDtoList)
                .build();
    }

}
