package com.jmm.brsap.countries.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import static com.jmm.brsap.countries.utils.Status.ERROR;
import static com.jmm.brsap.countries.utils.Status.LOADING;
import static com.jmm.brsap.countries.utils.Status.SUCCESS;

public class Response<T> {
    public final Status status;

    @Nullable
    public final T data;

    @Nullable
    public final Throwable error;

    private Response(Status status, @Nullable T data, @Nullable Throwable error) {
        this.status = status;
        this.data = data;
        this.error = error;
    }

    public Response loading() {
        return new Response(LOADING, null, null);
    }

    public Response success(@NonNull T data) {
        return new Response(SUCCESS, data, null);
    }

    public static Response error(@NonNull Throwable error) {
        return new Response(ERROR, null, error);
    }
}
