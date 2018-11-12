package com.example.demo.Jest.core.query;

public interface ConditionBuider<T> {
    ConditionChain build(T searchParam);
}
