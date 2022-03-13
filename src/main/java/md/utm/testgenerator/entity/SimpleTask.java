package md.utm.testgenerator.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class SimpleTask extends GeneralTask {

    @Column(unique = true, nullable = false)
    private String question;

    @Column(nullable = false)
    @OneToMany
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Answer> answers;

}
