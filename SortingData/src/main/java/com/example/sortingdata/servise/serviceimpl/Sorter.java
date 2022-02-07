package com.example.sortingdata.servise.serviceimpl;
import com.example.sortingdata.model.ConditionDto;
import com.example.sortingdata.model.ResponseDataDto;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class Sorter {


    public ResponseDataDto sort(ConditionDto condition, List<Map<String, Object>> data) {
        List<String> sortCondition = condition.getSortBy();
        try {
            for (String sortBy : sortCondition) {
                if (sortBy.equals("rating")) {
                    data.sort(integerComparator(sortBy));
                }else{
                    data.sort(stringComparator(sortBy));
                }
            }
        } catch (NullPointerException e) {
            throw new RuntimeException("No parameter for sorting");
        }
        return new ResponseDataDto(data);
    }

    public static Comparator<Map<String,Object>> integerComparator(String sortBy) {
        return (a, b) -> {
            Integer aTitle = (Integer) a.get(sortBy);
            Integer bTitle = (Integer) b.get(sortBy);
            return aTitle.compareTo(bTitle);
        };
    }
    public static Comparator<Map<String,Object>> stringComparator(String sortBy){
        return (a, b) -> {
            String aTitle = (String) a.get(sortBy);
            String bTitle = (String)  b.get(sortBy);
            return aTitle.compareTo(bTitle);
        };
    }
}
