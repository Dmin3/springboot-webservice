package com.example.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor // 선언된 모든 필드의 final 포함되어있다면 생성자자를 생성
public class HelloResponseDto {

    private final String name;
    private final int amount;


}
