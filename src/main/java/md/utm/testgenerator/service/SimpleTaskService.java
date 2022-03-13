package md.utm.testgenerator.service;

import lombok.AllArgsConstructor;
import md.utm.testgenerator.db.AdminRepository;
import md.utm.testgenerator.db.AnswerRepository;
import md.utm.testgenerator.db.SimpleTaskRepository;
import md.utm.testgenerator.entity.Admin;
import md.utm.testgenerator.entity.Answer;
import md.utm.testgenerator.entity.SimpleTask;
import md.utm.testgenerator.entity.TaskComplexity;
import md.utm.testgenerator.entity.dto.AnswerDto;
import md.utm.testgenerator.entity.dto.SimpleTaskDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class SimpleTaskService {

    private SimpleTaskRepository simpleTaskRepository;
    private AnswerRepository answerRepository;
    private AdminRepository adminRepository;

    public void addNewTask(SimpleTaskDto simpleTaskDto) {
        List<Answer> answers = getAnswerFromDto(simpleTaskDto.getAnswers());
        for (Answer answer: answers) {
            addNewAnswer(answer);
        }
        SimpleTask simpleTask = SimpleTask.builder()
                .author(adminRepository.getById(simpleTaskDto.getAuthorID()))
                .question(simpleTaskDto.getQuestion())
                .description(simpleTaskDto.getDescription())
                .taskComplexity(TaskComplexity.getByLabel(simpleTaskDto.getComplexity()))
                .answers(answers)
                .build();
        simpleTaskRepository.save(simpleTask);
    }

    public void addNewAnswer(Answer answer) {
        answerRepository.save(answer);
    }

    private List<Answer> getAnswerFromDto(List<AnswerDto> answerDTOs) {
        List<Answer> answers = new ArrayList<>();
        for (AnswerDto answerDto: answerDTOs) {
            answers.add(new Answer(answerDto));
        }
        return answers;
     }

    public List<SimpleTask> getAll() {
        return simpleTaskRepository.findAll();
    }

    public void deleteTask(Long id) {
        simpleTaskRepository.deleteById(id);
    }
}
