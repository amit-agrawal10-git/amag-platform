package com.github.amag.platform.filter;

import com.arangodb.springframework.core.ArangoOperations;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
@Data
public class OrFilter<T extends Object> implements Filter<T> {

    private final List<Filter<T>> filters;

    @Override
    public Collection<T> evaluate(Collection<T> o, ArangoOperations arangoOperations) {
        Collection<T> x = filters.get(0).evaluate(o, arangoOperations);
        for (int i=1;i<filters.size();i++){
            x.addAll(filters.get(i).evaluate(o,arangoOperations));
        }
        return x;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("("+this.getFilters().get(0).toString());
        for (int i=1;i<this.getFilters().size();i++)
            str.append(" OR " +this.getFilters().get(i).toString());
        str.append(")");
        return str.toString();
    }
}
