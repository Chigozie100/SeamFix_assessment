package chigozie.nwigwe.seamfix_assessment.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BvnInfo {

    private long id;

    private String bvn;

    private String imageDetail;

    private String basicDetail;
}
