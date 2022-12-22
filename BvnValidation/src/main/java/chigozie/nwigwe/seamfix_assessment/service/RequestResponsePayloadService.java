package chigozie.nwigwe.seamfix_assessment.service;

import chigozie.nwigwe.seamfix_assessment.dto.BvnValidationRequest;
import chigozie.nwigwe.seamfix_assessment.entities.RequestAndResponsePayload;
import chigozie.nwigwe.seamfix_assessment.repositories.RequestResponsePayloadRepository;
import chigozie.nwigwe.seamfix_assessment.responses.BvnValidationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class RequestResponsePayloadService {

    private RequestResponsePayloadRepository requestResponsePayloadRepository;

    @Autowired
    public RequestResponsePayloadService(RequestResponsePayloadRepository requestResponsePayloadRepository) {
        this.requestResponsePayloadRepository = requestResponsePayloadRepository;
    }

    public void savePayloadAsync(BvnValidationRequest requestPayload, BvnValidationResponse responsePayload) {
        CompletableFuture.runAsync(() -> {
            RequestAndResponsePayload entry = new RequestAndResponsePayload();
            entry.setId(UUID.randomUUID());
            entry.setRequestPayload(requestPayload.getBvn());
            entry.setMessage(responsePayload.getMessage());
            entry.setCode(responsePayload.getCode());
            entry.setBvn(responsePayload.getBvn());
            entry.setImageDetail(responsePayload.getImageDetail());
            entry.setBasicDetail(responsePayload.getBasicDetail());

            requestResponsePayloadRepository.save(entry);
        });
    }
}
