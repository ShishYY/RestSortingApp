package com.example.questionnaire.service;

import com.example.questionnaire.model.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        ResponseDto response = new ResponseDto();
        for(QuestionDto questionDto : questions ){
            if(response.getResult() == null && response.getPathNumber() == 0){
                String question = questionDto.getQuestion();
                String answer = answerList.stream().findFirst().get().getAnswerText();
                putToResponse(question,answer,response);
            }
            for(Map<String,String> responseList : response.getResult()){
                if(responseList.containsValue(questionDto.getQuestionAnswer())){
                    String question = questionDto.getQuestion();
                }
            }

        }

        return response;
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

    public ResponseDto putToResponse(String question,String answer,ResponseDto response){
        Map<String, String> map = new HashMap<>();
        if(response.getResult()!=null) {
            map.put(question, answer);
            response.getResult().add(map);
            response.setPathNumber(response.getPathNumber() + 1);
            return response;
        }
        List<Map<String, String>> answerQuestion = new ArrayList<>();
        map.put(question,answer);
        answerQuestion.add(map);
        response.setResult(answerQuestion);
        response.setPathNumber(response.getPathNumber() + 1);
        return response;
    }
}
