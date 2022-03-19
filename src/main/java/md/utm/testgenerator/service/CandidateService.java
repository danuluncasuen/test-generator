package md.utm.testgenerator.service;

import lombok.AllArgsConstructor;
import md.utm.testgenerator.db.CandidateRepository;
import md.utm.testgenerator.entity.Candidate;
import md.utm.testgenerator.entity.dto.CandidateDto;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CandidateService {

    private final CandidateRepository candidateRepository;

    public void addCandidate(CandidateDto candidateDto) {
        candidateRepository.save(new Candidate(candidateDto));
    }

}
