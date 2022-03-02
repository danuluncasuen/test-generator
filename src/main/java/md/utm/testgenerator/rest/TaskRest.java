package md.utm.testgenerator.rest;

import lombok.AllArgsConstructor;
import md.utm.testgenerator.entity.dto.SimpleTaskDto;
import md.utm.testgenerator.service.SimpleTaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskRest {

    private SimpleTaskService simpleTaskService;

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
}
