package com.github.amag.platform.filter;

import com.arangodb.springframework.core.ArangoOperations;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.List;

@Data
@RequiredArgsConstructor
public class AndFilter<T extends Object> implements Filter<T> {

    private final List<Filter<T>> filters;

    @Override
    public Collection<T> evaluate(Collection<T> o, ArangoOperations arangoOperations) {
        Collection<T> result = o;
        for (Filter<T> filter:filters) {
            result = filter.evaluate(result,arangoOperations);
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("("+this.getFilters().get(0).toString());
        for (int i=1;i<this.getFilters().size();i++)
            str.append(" AND " +this.getFilters().get(i).toString());
        str.append(")");
        return str.toString();
    }
}
