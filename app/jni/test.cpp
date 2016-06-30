#include <jni.h>
#include <stdio.h>
#include <android/log.h>

#ifdef __cplusplus
extern "C" {
#endif

    #define LOGI(...) ((void)__android_log_print(ANDROID_LOG_INFO, "test_jni", __VA_ARGS__))

    void callJavaMethod(JNIEnv *env, jobject thiz){
        LOGI("callJavaMethod");
        jclass clazz = env->FindClass("com/baitu/jnitest/MainActivity");
        if(clazz == NULL){
            LOGI("MainActivity is null");
            return;
        }
        LOGI("callJavaMethod2");
        jmethodID id = env->GetStaticMethodID(clazz, "callByJni", "(Ljava/lang/String;)V");
        if(id == NULL){
            LOGI("method id is null");
            return;
        }
        jstring msg = env->NewStringUTF("this msg is send from jni.");
        env->CallStaticVoidMethod(clazz, id, msg);
        LOGI("callJavaMethod end");
    }

    jstring Java_com_baitu_jnitest_MainActivity_get(JNIEnv *env, jobject thiz){
        LOGI("invoke get in c++\n");
        callJavaMethod(env, thiz);
        return env->NewStringUTF("Hello from JNI");
    }

    JNIEXPORT void JNICALL Java_com_baitu_jnitest_MainActivity_set(JNIEnv *env, jobject thiz, jstring string){
        LOGI("invoke get in c++\n");
        char* str = (char*)env->GetStringUTFChars(string, NULL);
        LOGI("%s\n", str);
        env->ReleaseStringUTFChars(string, str);
    }



#ifdef __cplusplus
}
#endif