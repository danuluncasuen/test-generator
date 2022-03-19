package md.utm.testgenerator.rest;

import lombok.AllArgsConstructor;
import md.utm.testgenerator.entity.dto.CandidateCodeSubmissionDto;
import md.utm.testgenerator.entity.dto.CodeTaskDto;
import md.utm.testgenerator.entity.dto.SimpleTaskDto;
import md.utm.testgenerator.service.CodeTaskService;
import md.utm.testgenerator.service.SimpleTaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskRest {

    private final SimpleTaskService simpleTaskService;
    private final CodeTaskService codeTaskService;

    @GetMapping("/get")
    public ResponseEntity<?> getAllTasks() {
        try {
            return new ResponseEntity<>(simpleTaskService.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/add/simple")
    public ResponseEntity<?> addNewSimpleTask(@RequestBody SimpleTaskDto simpleTaskDto) {
        try {
            simpleTaskService.addNewTask(simpleTaskDto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<?> deleteEntity(@PathVariable Long id) {
        try {
            simpleTaskService.deleteTask(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/add/code")
    public ResponseEntity<?> addNewCodeTask(@RequestBody CodeTaskDto codeTaskDto) {
        try {
            codeTaskService.addNew(codeTaskDto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/submit/code")
    public ResponseEntity<?> submitCodeTask(@RequestBody CandidateCodeSubmissionDto candidateCodeSubmissionDto) {
        try {
            codeTaskService.addCandidateSubmission(candidateCodeSubmissionDto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
