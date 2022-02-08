package com.example.questionnaire.service;

import com.example.questionnaire.model.PostQuestionsDto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;

@Service
public class DefaultQuestionList {

    @Value("${json.classpath}")
    private String folderPass;

    public PostQuestionsDto defaultList = new PostQuestionsDto();

    @PostConstruct
    public void init() throws IOException {
        try {
            ObjectMapper jsonMapper = new ObjectMapper();
            File jsonFile = new File(folderPass);
            PostQuestionsDto questionsDto = jsonMapper.readValue(jsonFile, new TypeReference<PostQuestionsDto>() {
                        @Override
                        public Type getType() {
                            return super.getType();
                        }
                    });
            defaultList.setQuestionsList(questionsDto.getQuestionsList());
            defaultList.setAnswerList(questionsDto.getAnswerList());

        }catch (IOException e){
            e.printStackTrace();
        }


    }
}
