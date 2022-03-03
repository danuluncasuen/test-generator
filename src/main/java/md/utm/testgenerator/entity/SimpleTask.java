package md.utm.testgenerator.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SimpleTask {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true, nullable = false)
    private String question;

    @Column(nullable = false)
    @OneToMany
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Answer> answers;

    private TaskComplexity complexity;

    @OneToOne
    private Admin author;

}
