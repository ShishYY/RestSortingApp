package com.example.sortingdata.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Data
public class RequestExcludeDataDto {
    private List<InData> data = new ArrayList<>();
    private Condition condition;

    @Data
    public static class InData  {
        private String user;
        private String rating;
        private Boolean disabled;


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            InData inData = (InData) o;
            return Objects.equals(user, inData.user) && Objects.equals(rating, inData.rating) && Objects.equals(disabled, inData.disabled);
        }

        @Override
        public int hashCode() {
            return Objects.hash(user, rating, disabled);
        }
    }
    @Data
    public static class Condition {

        private List<Exclude> exclude = new ArrayList<Exclude>();

        private List<Include> include = new ArrayList<Include>();


        @JsonProperty("sort_by")
        private List<String> sortBy = new ArrayList<>();

    }
    @Data
    public static class Exclude{
        /*@JsonProperty("disabled")*/
        private Boolean disabled;
    }
    @Data
    public static class Include{
        private String parameter;
    }
}