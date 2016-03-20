package com.evan.exercise.domain;

public interface Facing<T extends Facing> {
    public T getLeft();
    public T getRight();
}
