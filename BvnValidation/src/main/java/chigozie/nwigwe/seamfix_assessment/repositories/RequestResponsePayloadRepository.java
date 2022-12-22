package chigozie.nwigwe.seamfix_assessment.repositories;

import chigozie.nwigwe.seamfix_assessment.entities.RequestAndResponsePayload;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RequestResponsePayloadRepository extends JpaRepository<RequestAndResponsePayload, UUID> {

}
