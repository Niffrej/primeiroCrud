package br.com.demo.demo.validations;


import java.util.Objects;
import java.util.function.Function;

public class NullSafe<T> {

    private T t;

    private NullSafe(T t) {this.t = t;}

    public static <T> NullSafe<T> of(T t) {
        return new NullSafe<>(t);
    }

    public <U> NullSafe<U> call(Function<T, U> methodRef) {
        U nextStep = this.get(methodRef);
        return of(nextStep);
    }

    public <U> U get(Function<T,U> methodRef) {
        Objects.requireNonNull(methodRef);
        return this.t == null ? null : methodRef.apply(this.t);
    }

    public T getOrDefault(T defaultVal) {return this.t == null ? defaultVal : this.t;}

    public T getOrThrow(Throwable throwable) throws Throwable {
        if (this.t == null) {
            throw throwable;
        } else {
            return this.t;
        }
    }
}
