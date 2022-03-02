package md.utm.testgenerator.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private List<Answer> answers;

    private TaskComplexity complexity;

    @OneToOne
    private Admin author;

}
