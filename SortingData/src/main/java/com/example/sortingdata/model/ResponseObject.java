package com.example.sortingdata.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseObject {

        private String user;
        private String rating;
        private Boolean disabled;

}

