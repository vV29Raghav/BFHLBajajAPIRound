package com.example.BajajAPIRound.controller;

import com.example.BajajAPIRound.dto.BFHLRequestDTO;
import com.example.BajajAPIRound.dto.BFHLResponseDTO;
import com.example.BajajAPIRound.service.BFHLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/bfhl")
public class BFHLController {
    
    @Autowired
    private BFHLService bfhlService;

    @PostMapping
    public BFHLResponseDTO process(@RequestBody BFHLRequestDTO request) {
        // call the service
        return bfhlService.process(request);
    }
}
