package com.example.questionnaire.model;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonClassDescription("${json.classpath}")
public class PostQuestionsDto {

    @JsonProperty("question")
    private List <QuestionDto> questionsList;

    @JsonProperty("answer")
    private List<AnswerDto> answerList;
}
