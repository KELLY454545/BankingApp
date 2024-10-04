package com.armand.Banking.execption;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class OperationNonPermitedExeption extends RuntimeException{

    private final String errorMsg;

    private final String operationId;

    private final String source;

    private final String dependency;
}
