package md.utm.testgenerator.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@SuperBuilder
@MappedSuperclass
@NoArgsConstructor
public class GeneralTask {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected int id;

    @Enumerated(EnumType.STRING)
    protected TaskComplexity taskComplexity;

    protected String description;

    @OneToOne
    private Admin author;

}
