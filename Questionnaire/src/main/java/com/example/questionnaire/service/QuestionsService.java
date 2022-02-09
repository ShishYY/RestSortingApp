package com.example.questionnaire.service;

import com.example.questionnaire.model.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QuestionsService {

    @Value("${start.value}")
    private String startQuiz;

    private List<QuestionDto> questions;
    private List<AnswerDto> answerList;


    private final DefaultQuestionList defaultQuestionList;
    public QuestionsService(DefaultQuestionList defaultQuestionList) {
        this.defaultQuestionList = defaultQuestionList;
    }


    public void addQuestions(PostQuestionsDto req){
        questions = req.getQuestionsList();
        answerList = req.getAnswerList();
    }

    public AnswerAndQuestionDto quiz(String answer){
        if(questions == null) {
            generateDefaultList();
        }
            for (QuestionDto questions : questions) {
                if (answer.equals("") || answer.equals(startQuiz) ) {
                    List<String> nextAnswer = new ArrayList<>();
                    nextAnswer.add(answerList.get(0).getAnswerText());
                    nextAnswer.add(answerList.get(1).getAnswerText());
                    return putAnswer(questions.getQuestion(), nextAnswer);
                }
                if (questions.getQuestionAnswer().equals(answer)) {
                    List<String> nextAnswer = new ArrayList<>();
                    answerList.forEach(result -> {
                        if (result.getQuestionId() == questions.getId()) {
                            nextAnswer.add(result.getAnswerText());
                        }
                    });
                    return putAnswer(questions.getQuestion(), nextAnswer);
                }
            }
        return null;
    }

    public ResponseDto getAllPath(){
        if(questions == null){generateDefaultList();}
        List<Map<QuestionDto,AnswerDto>> possiblePath = new ArrayList<>();
        Integer counter = 0;



        return null;
    }

    public AnswerAndQuestionDto putAnswer(String question,List<String> answer){

        AnswerAndQuestionDto answerAndQuestionDto = new AnswerAndQuestionDto();
        answerAndQuestionDto.setAnswer(answer);
        answerAndQuestionDto.setQuestion(question);
        return answerAndQuestionDto;
    }

    public void generateDefaultList(){
        questions = defaultQuestionList.defaultList.getQuestionsList();
        answerList = defaultQuestionList.defaultList.getAnswerList();
    }

}
