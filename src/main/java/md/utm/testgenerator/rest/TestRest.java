package md.utm.testgenerator.rest;

import lombok.AllArgsConstructor;
import md.utm.testgenerator.entity.dto.TestDtoUI;
import md.utm.testgenerator.service.TestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/test")
public class TestRest {

    private final TestService testService;

    @PostMapping("/create")
    public ResponseEntity<?> createTest(@RequestBody TestDtoUI testDto) {
        try {
            testService.addNewTest(testDto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getTest(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(testService.getTest(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
