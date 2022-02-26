package com.revature.foundation.daos;

import java.util.List;

public interface Dao<T> {

    List<T> getByID(String Id);
    List<T> getByStatus(String status);
    List<T> getByRole(String role);

    void add (T obj);
    void addAll();
    void getAll();
    void removeByID(String ID);

}
