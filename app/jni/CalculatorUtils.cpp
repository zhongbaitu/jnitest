//
// Created by 钟买能 on 16/6/30.
//

#include "CalculatorUtils.hpp"
#include "Calculator.cpp"


JNIEXPORT jint JNICALL Java_com_baitu_jnitest_CalculatorHelper_add
  (JNIEnv *env, jobject thiz, jint a, jint b){
        return add(a, b);
  }


JNIEXPORT jint JNICALL Java_com_baitu_jnitest_CalculatorHelper_sub
  (JNIEnv *env, jobject thiz, jint a, jint b){
        return sub(a, b);
  }
