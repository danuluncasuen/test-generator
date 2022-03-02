package md.utm.testgenerator.rest;

import lombok.AllArgsConstructor;
import md.utm.testgenerator.entity.dto.AdminDto;
import md.utm.testgenerator.service.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class AdminRest {

    private AdminService adminService;

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getUserByID(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(adminService.getById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addUser(@RequestBody AdminDto adminDto) {
        try {
            adminService.addNewAdmin(adminDto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
