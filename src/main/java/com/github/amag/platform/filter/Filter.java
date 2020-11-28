package com.github.amag.platform.filter;

import com.arangodb.springframework.core.ArangoOperations;
import com.github.amag.platform.domain.BaseObject;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface Filter<T extends Object> {

    public Collection<T> evaluate(Collection<T> o, ArangoOperations arangoOperations);

}
