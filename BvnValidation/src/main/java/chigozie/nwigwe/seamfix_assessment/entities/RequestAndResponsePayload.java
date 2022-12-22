package chigozie.nwigwe.seamfix_assessment.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "RequestAndResponsePayload")
public class RequestAndResponsePayload {
    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String requestPayload;
    private String message;
    private String code;
    private String bvn;
    private String imageDetail;
    private String basicDetail;
}
