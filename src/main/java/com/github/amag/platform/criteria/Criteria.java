package com.github.amag.platform.criteria;

import com.arangodb.springframework.core.ArangoOperations;
import com.github.amag.platform.domain.BaseObject;

public interface Criteria<T extends BaseObject> {

    public T evaluate(T o, ArangoOperations arangoOperations);

}
