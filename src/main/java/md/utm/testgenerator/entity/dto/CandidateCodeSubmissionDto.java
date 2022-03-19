package md.utm.testgenerator.entity.dto;

import lombok.Data;

@Data
public class CandidateCodeSubmissionDto {

    private Long id;

    private Long codeTask;

    private String submission;

    private Float resultScore;

}
