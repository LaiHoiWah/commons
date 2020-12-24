package com.wah.commons.domain;

public interface Sortable<T> extends Comparable<T>{

    Integer getSort();

    void setSort(Integer sort);
}
