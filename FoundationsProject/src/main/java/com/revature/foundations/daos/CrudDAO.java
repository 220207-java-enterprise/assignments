package com.revature.foundations.daos;

public interface CrudDAO<T> {

    T[] getAll();

    T getById(String id);

    void save(T newObj);

    void update(T updatedObj);

    void deleteById(String id);
}
