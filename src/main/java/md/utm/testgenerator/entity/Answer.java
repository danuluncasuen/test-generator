package md.utm.testgenerator.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import md.utm.testgenerator.entity.dto.AnswerDto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String answer;
    private boolean isCorrect;

    public Answer(AnswerDto answerDto) {
        this.answer = answerDto.getAnswer();
        this.isCorrect = answerDto.isCorrect();
    }
}
