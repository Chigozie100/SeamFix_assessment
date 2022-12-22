package chigozie.nwigwe.seamfix_assessment.controller;

import chigozie.nwigwe.seamfix_assessment.dto.BvnValidationRequest;
import chigozie.nwigwe.seamfix_assessment.responses.BvnValidationResponse;
import chigozie.nwigwe.seamfix_assessment.service.BvnValidationService;
import chigozie.nwigwe.seamfix_assessment.service.RequestResponsePayloadService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("/bv-service")
@RequiredArgsConstructor
public class BvnValidationController {

    private BvnValidationService bvnValidationService;
    private RequestResponsePayloadService requestResponsePayloadService;

    @Autowired
    public BvnValidationController(BvnValidationService bvnValidationService,
                                   RequestResponsePayloadService requestResponsePayloadService) {
        this.bvnValidationService = bvnValidationService;
        this.requestResponsePayloadService = requestResponsePayloadService;
    }

    @PostMapping("/svalidate/wrapper")
    public ResponseEntity<BvnValidationResponse> validateBvn(@Valid @RequestBody BvnValidationRequest request) {
        BvnValidationResponse response = bvnValidationService.getResponse(request);
        requestResponsePayloadService.savePayloadAsync(request, response);
        System.out.println("saved");
        return bvnValidationService.validateBvn(request);
    }
}
