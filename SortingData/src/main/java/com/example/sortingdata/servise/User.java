package com.example.sortingdata.servise;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

    private String email;

    private String rating;

    private String disabled;
}
