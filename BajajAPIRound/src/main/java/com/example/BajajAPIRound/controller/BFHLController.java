package com.example.BajajAPIRound.controller;


import com.example.BajajAPIRound.dto.BFHLRequestDTO;
import com.example.BajajAPIRound.dto.BFHLResponseDTO;
import com.example.BajajAPIRound.service.BFHLService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/bfhl")
public class BFHLController {
    private final BFHLService bfhlService;

    public BFHLController(BFHLService bfhlService) {
        this.bfhlService = bfhlService;
    }

    @PostMapping
    public ResponseEntity<BFHLResponseDTO> process(
            @RequestBody BFHLRequestDTO request) {

        return ResponseEntity.ok(
                bfhlService.process(request)
        );
    }
}
