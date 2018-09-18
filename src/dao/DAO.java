package dao;

import java.io.InvalidClassException;
import java.util.ArrayList;

public interface DAO {
    boolean create(Object o) throws InvalidClassException;

    int delete(ArrayList<Integer> l);

    boolean deleteById(int id);

    boolean update(Object o) throws InvalidClassException;

    Object findByID(int id);

    ArrayList<Object> findAll();
}
