LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE := calculator
LOCAL_SRC_FILES := CalculatorUtils.cpp

LOCAL_LDLIBS    := -lm -llog

include $(BUILD_SHARED_LIBRARY)