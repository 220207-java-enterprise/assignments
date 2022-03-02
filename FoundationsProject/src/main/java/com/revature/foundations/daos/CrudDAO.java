package com.revature.foundations.daos;

import java.util.List;

public interface CrudDAO<T> {

    void save(T newObject);
    T getById(String id);
    List<T> getAll();
    void update(T updatedObject);
    void deleteById(String id);

}
