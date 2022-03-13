package md.utm.testgenerator.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import md.utm.testgenerator.entity.dto.Language;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class CodeTask extends GeneralTask {

    private String methodSignature;
    @Enumerated(EnumType.STRING)
    private Language language;
    @OneToMany
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<TestCase> testCases;

}
