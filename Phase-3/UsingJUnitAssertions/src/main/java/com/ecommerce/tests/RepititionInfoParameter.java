package com.ecommerce.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.Test;

public class RepititionInfoParameter {
	  
	  @BeforeEach
	    void beforeEach(TestInfo testInfo, RepetitionInfo repetitionInfo) {
	        int currentRepetition = repetitionInfo.getCurrentRepetition();
	        int totalRepetitions = repetitionInfo.getTotalRepetitions();
	        String methodName = testInfo.getTestMethod().get().getName();
	        
	        System.out.println(String.format("About to execute repetition %d of %d for %s", //
	                currentRepetition, totalRepetitions, methodName));
	    }
	  
	  @RepeatedTest(3)
	  void test_Add(RepetitionInfo repetitionInfo) {
	    System.out.println("start test_Add() : "+repetitionInfo.getCurrentRepetition());
	  }
	  
	  @AfterEach
	  void afterEach(TestInfo testInfo, RepetitionInfo repetitionInfo) {
	    int currentRepetition = repetitionInfo.getCurrentRepetition();
	        int totalRepetitions = repetitionInfo.getTotalRepetitions();
	        String methodName = testInfo.getTestMethod().get().getName();
	        
	        System.out.println(String.format("After completed execute repetition %d of %d for %s", //
	                currentRepetition, totalRepetitions, methodName));
	  }
	}
