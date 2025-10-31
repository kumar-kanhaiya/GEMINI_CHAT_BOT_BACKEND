package com.AI.GeminiChat.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class qnaServiceImpl implements qnaService{

    @Value("${gemini.api.url}")
    private String geminiApiUrl;

    @Value("${gemini.api.key}")
    private String geminiApiKey;

    @Override
    public String getAnswer(String question) {
        return "";
    }
}
