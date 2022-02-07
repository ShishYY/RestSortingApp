package com.example.sortingdata.servise.serviceimpl;
import com.example.sortingdata.model.ConditionDto;
import com.example.sortingdata.model.ResponseDataDto;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class Sorter {

    Comparator<Object> keyComparator = (o1, o2) -> {
        if (o1 instanceof Comparable && o2 instanceof Comparable) {
            return ((Comparable) o1).compareTo(o2);
        }
        return 0;
    };

    public ResponseDataDto sort(ConditionDto condition, List<Map<String, Object>> data) {
        List<String> sortCondition = condition.getSortBy();


            Comparator<Map<String, Object>> comparator = null;

            for (String sortBy : sortCondition) {
                if (comparator == null) {
                    comparator = Comparator.comparing(map -> map.get(sortBy), keyComparator);
                } else {
                    comparator = comparator.thenComparing(map -> map.get(sortBy), keyComparator);
                }
            }

            if (comparator != null) {
                data.sort(comparator);
            }

        return new ResponseDataDto(data);
    }

}
