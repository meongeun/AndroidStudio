package com.example.apiexample2;

public interface RetroCallback<T> {
    void onSuccess(int code, T receivedData);
    void onError(Throwable t);
    void onFailure(int code);
}
