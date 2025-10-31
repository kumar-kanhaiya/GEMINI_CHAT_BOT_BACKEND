package com.AI.GeminiChat.controller;

import com.AI.GeminiChat.service.qnaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/api/qna")
public class AIController {

    @Autowired
    private qnaService qnaService;


    @GetMapping("/question")
    public ResponseEntity<String> askQuestion(@RequestBody Map<String , String> payload){
        String question = payload.get("question");
        String answer = qnaService.getAnswer(question);
        return ResponseEntity.ok(answer);
    }

}
