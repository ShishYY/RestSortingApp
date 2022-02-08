package com.example.questionnaire.model;

import lombok.Data;
import java.util.List;


@Data
public class AnswerAndQuestionDto {

    private String question;

    private List<String> answer;


}
