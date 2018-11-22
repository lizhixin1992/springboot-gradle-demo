package com.example.demo.Jest.core.query;

public abstract class AbstractQueryBuilder<T> implements ConditionBuider<T> {
    @Override
    public abstract QueryChain build(T searchParam);
}
