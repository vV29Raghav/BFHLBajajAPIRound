package com.example.BajajAPIRound.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.BajajAPIRound.dto.BFHLRequestDTO;
import com.example.BajajAPIRound.dto.BFHLResponseDTO;
import com.example.BajajAPIRound.service.BFHLService;
import org.springframework.stereotype.Service;

@Service
public class BFHLServiceImpl implements BFHLService {

    // my details
    private String user = "raghav_verma_29012006";
    private String mail = "raghav1185.be23@chitkara.edu.in";
    private String roll = "2310991185";

    @Override
    public BFHLResponseDTO process(BFHLRequestDTO request) {
        BFHLResponseDTO res = new BFHLResponseDTO();
        res.setIs_success(true);
        res.setUser_id(user);
        res.setEmail(mail);
        res.setRoll_number(roll);

        List<String> odds = new ArrayList<>();
        List<String> evens = new ArrayList<>();
        List<String> alphas = new ArrayList<>();
        List<String> spl = new ArrayList<>();
        
        long totalSum = 0;
        String alphaStr = "";

        // check if empty
        List<String> inputData = request.getData();
        if (inputData == null) {
            inputData = new ArrayList<>();
        }

        // process array
        for (int i = 0; i < inputData.size(); i++) {
            String val = inputData.get(i);
            
            try {
                // if it is a number
                long num = Long.parseLong(val);
                totalSum = totalSum + num;
                
                if (num % 2 == 0) {
                    evens.add(val);
                } else {
                    odds.add(val);
                }
            } catch (Exception e) {
                // not a number, check alphabet
                if (val.matches("[a-zA-Z]+")) {
                    alphas.add(val.toUpperCase());
                    alphaStr = alphaStr + val;
                } else {
                    // special chars
                    spl.add(val);
                }
            }
        }

        // reverse the string
        String reversed = "";
        for(int k = alphaStr.length() - 1; k >= 0; k--) {
            reversed += alphaStr.charAt(k);
        }

        // alternating caps
        String finalConcat = "";
        for (int j = 0; j < reversed.length(); j++) {
            char c = reversed.charAt(j);
            if (j % 2 == 0) {
                finalConcat += Character.toUpperCase(c);
            } else {
                finalConcat += Character.toLowerCase(c);
            }
        }

        // set response
        res.setOdd_numbers(odds);
        res.setEven_numbers(evens);
        res.setAlphabets(alphas);
        res.setSpecial_characters(spl);
        res.setSum(String.valueOf(totalSum));
        res.setConcat_string(finalConcat);

        return res;
    }
}
