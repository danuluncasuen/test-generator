package md.utm.testgenerator.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CandidateDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;

}
