package md.utm.testgenerator.entity.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class TestDto {
    private Long id;
    private Long time;
    private List<GeneralTaskDto> tasks;
}
