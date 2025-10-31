package com.AI.GeminiChat.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
public class qnaServiceImpl implements qnaService{

    @Value("${gemini.api.url}")
    private String geminiApiUrl;

    @Value("${gemini.api.key}")
    private String geminiApiKey;

    private final WebClient webClient;

    public qnaServiceImpl(WebClient.Builder webClient) {
        this.webClient = webClient.build();
    }

    @Override
    public String getAnswer(String question) {

        Map<String, Object> requestBody = Map.of(
                "contents",new Object[]{
                        Map.of("parts",new Object[]{
                                Map.of("text",question)
                        })

                }
        );

//                {
//    "contents": [
//      {
//        "parts": [
//          {
//            "text": "Explain how AI works in a few words"
//          }
//        ]
//      }
//    ]
//  }
        // Make API call
        String responce =
                webClient.post()
                .uri(geminiApiUrl+geminiApiKey)
                .header("Content-Type","application/json")
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        return responce;
    }
}
