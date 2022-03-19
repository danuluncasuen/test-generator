package md.utm.testgenerator.entity.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TestDtoUI {

    private Long time;

    private List<Long> simpleTasks;

    private List<Long> codeTasks;

}
