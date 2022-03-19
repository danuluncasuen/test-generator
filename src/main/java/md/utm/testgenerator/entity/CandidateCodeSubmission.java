package md.utm.testgenerator.entity;

import lombok.Builder;

import javax.persistence.*;

@Entity
@Builder
public class CandidateCodeSubmission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private CodeTask codeTask;

    private String submission;

    private Float resultScore;

}
