package com.example.sortingdata.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RequestIncludeDataDto {
    private List<RequestExcludeDataDto.InData> data = new ArrayList<>();
    private Condition condition;

    @Data
    public static class InData  {
        @JsonProperty("name")
        private String user;

        @JsonProperty("email")

        private String rating;
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private Boolean disabled;


    }
    @Data
    public static class Condition {

        private List<RequestExcludeDataDto.Exclude> exclude = new ArrayList<RequestExcludeDataDto.Exclude>();

        private List<RequestExcludeDataDto.Include> include = new ArrayList<RequestExcludeDataDto.Include>();


        @JsonProperty("sort_by")
        private List<String> sortBy = new ArrayList<>();

    }
    @Data
    public static class Exclude{

        private Boolean disabled;
    }
    @Data
    public static class Include{
        private String parameter;
    }
}
