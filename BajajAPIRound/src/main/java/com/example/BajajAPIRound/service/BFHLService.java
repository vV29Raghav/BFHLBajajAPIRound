package com.example.BajajAPIRound.service;

import com.example.BajajAPIRound.dto.BFHLRequestDTO;
import com.example.BajajAPIRound.dto.BFHLResponseDTO;

public interface BFHLService {
    BFHLResponseDTO process(BFHLRequestDTO request);
}
