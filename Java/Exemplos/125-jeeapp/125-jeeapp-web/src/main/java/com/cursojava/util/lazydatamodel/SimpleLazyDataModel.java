package com.cursojava.util.lazydatamodel;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import java.util.List;
import java.util.Map;

public abstract class SimpleLazyDataModel<T> extends LazyDataModel<T> {
    protected Long count;

    public SimpleLazyDataModel() {
    }

    public List<T> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
        if (this.count == null) {
            this.count = this.calcCount();
            this.setRowCount(this.count.intValue());
        }

        return this.doQuery(first, pageSize);
    }

    protected abstract Long calcCount();

    protected abstract List<T> doQuery(int var1, int var2);

    public void forceRefresh() {
        this.count = null;
    }
}
