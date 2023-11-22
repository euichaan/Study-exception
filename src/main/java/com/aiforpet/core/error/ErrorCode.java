package com.aiforpet.core.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    UNDEFINED("미정의 오류"),
    E001("클라이언트 오류"),
    E002("서버 오류"),
    E003("비밀번호 검증 오류"),
    E004("중복 관련 오류"),
    ;

    private final String description;
}
