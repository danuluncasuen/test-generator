package md.utm.testgenerator.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class CodeTask {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    @OneToMany
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<TestCases> testCases;

}
