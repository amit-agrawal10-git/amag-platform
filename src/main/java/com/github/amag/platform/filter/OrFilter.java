package com.github.amag.platform.filter;

import com.arangodb.springframework.core.ArangoOperations;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Collection;

@RequiredArgsConstructor
@Data
public class OrFilter<T extends Object> implements Filter<T> {

    private final Filter<T> firstFilter, secondFilter;

    @Override
    public Collection<T> evaluate(Collection<T> o, ArangoOperations arangoOperations) {
        Collection<T> x = firstFilter.evaluate(o, arangoOperations);
        x.addAll(secondFilter.evaluate(o,arangoOperations));
        return x;
    }
}
