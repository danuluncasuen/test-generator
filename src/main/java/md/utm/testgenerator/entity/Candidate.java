package md.utm.testgenerator.entity;

import lombok.AllArgsConstructor;
import md.utm.testgenerator.entity.dto.CandidateDto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;

@AllArgsConstructor
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    @Email
    private String email;

    public Candidate(CandidateDto candidateDto) {
        this.firstName = candidateDto.getFirstName();
        this.lastName = candidateDto.getLastName();
        this.email = candidateDto.getEmail();
    }

}
