package com.ashwath.BankingApp.ExceptionHandling;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ExceptionInfo {
    private String message;
    private int statusCode;
}
