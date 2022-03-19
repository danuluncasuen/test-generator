package md.utm.testgenerator.rest;

import lombok.AllArgsConstructor;
import md.utm.testgenerator.entity.dto.CandidateDto;
import md.utm.testgenerator.service.CandidateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CandidateRest {

    private final CandidateService candidateService;

    @PostMapping("/add/candidate")
    public ResponseEntity<?> addNewCandidate(@RequestBody CandidateDto candidateDto) {
        try {
            candidateService.addCandidate(candidateDto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
