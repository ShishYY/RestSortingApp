package com.example.questionnaire.controller;

import com.example.questionnaire.model.AnswerAndQuestionDto;
import com.example.questionnaire.model.PostQuestionsDto;
import com.example.questionnaire.model.ResponseDto;
import com.example.questionnaire.service.QuestionsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/questionnaire")
public class QuestionnaireRestController {


    private final QuestionsService questionsService;

    public QuestionnaireRestController(QuestionsService questionsService) {
        this.questionsService = questionsService;
    }

    @PostMapping
    public void addQuestion(@RequestBody PostQuestionsDto req){
        questionsService.addQuestions(req);
    }

    @PutMapping("/answer/{answer}")
    public AnswerAndQuestionDto allArgsQuestions(@PathVariable String answer){
        return questionsService.quiz(answer);
    }

    @GetMapping()
    public ResponseDto getAllPath(){
        return questionsService.getAllPath();
    }
}
