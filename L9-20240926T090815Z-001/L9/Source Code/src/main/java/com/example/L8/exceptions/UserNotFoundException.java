package com.example.L8.exceptions;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class UserNotFoundException extends RuntimeException{

    String message;
}
