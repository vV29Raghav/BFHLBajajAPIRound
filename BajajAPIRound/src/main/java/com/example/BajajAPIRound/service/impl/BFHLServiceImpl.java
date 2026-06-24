package com.example.BajajAPIRound.service.impl;
import java.util.*;

import com.example.BajajAPIRound.dto.BFHLRequestDTO;
import com.example.BajajAPIRound.dto.BFHLResponseDTO;
import com.example.BajajAPIRound.service.BFHLService;
import org.springframework.stereotype.Service;

@Service
public class BFHLServiceImpl implements BFHLService{
    private static final String USER_ID =
            "raghav_verma_29012006";

    private static final String EMAIL =
            "raghav1185.be23@chitkara.edu.in";

    private static final String ROLL_NUMBER =
            "2310991185";

    @Override
    public BFHLResponseDTO process(BFHLRequestDTO request) {

        List<String> oddNumbers = new ArrayList<>();
        List<String> evenNumbers = new ArrayList<>();
        List<String> alphabets = new ArrayList<>();
        List<String> specialCharacters = new ArrayList<>();

        long sum = 0;

        StringBuilder alphabetCharacters = new StringBuilder();

        List<String> data = request.getData();
        if (data == null) {
            data = Collections.emptyList();
        }

        for (String value : data) {

            if (value.matches("\\d+")) {

                long number = Long.parseLong(value);

                sum += number;

                if (number % 2 == 0) {
                    evenNumbers.add(value);
                } else {
                    oddNumbers.add(value);
                }

            }
            else if (value.matches("[a-zA-Z]+")) {

                alphabets.add(value.toUpperCase());

                alphabetCharacters.append(value);
            }
            else {
                specialCharacters.add(value);
            }
        }

        String concatString =
                buildAlternatingCaps(
                        alphabetCharacters.reverse().toString()
                );

        BFHLResponseDTO response = new BFHLResponseDTO();

        response.setIs_success(true);
        response.setUser_id(USER_ID);
        response.setEmail(EMAIL);
        response.setRoll_number(ROLL_NUMBER);

        response.setOdd_numbers(oddNumbers);
        response.setEven_numbers(evenNumbers);
        response.setAlphabets(alphabets);
        response.setSpecial_characters(specialCharacters);

        response.setSum(String.valueOf(sum));
        response.setConcat_string(concatString);

        return response;
    }

    private String buildAlternatingCaps(String input) {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {

            char c = input.charAt(i);

            if (i % 2 == 0) {
                result.append(Character.toUpperCase(c));
            } else {
                result.append(Character.toLowerCase(c));
            }
        }

        return result.toString();
    }
}
