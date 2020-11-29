package com.github.amag.platform.filter;

import com.arangodb.springframework.core.ArangoOperations;

import java.util.Collection;

public interface Filter<T extends Object> {

    public Collection<T> evaluate(Collection<T> o, ArangoOperations arangoOperations);

}
