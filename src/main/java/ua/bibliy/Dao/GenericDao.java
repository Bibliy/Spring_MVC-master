package ua.bibliy.Dao;

import java.sql.SQLException;
import java.util.List;

public interface GenericDao<T,ID> {
    public  void add(T t) throws SQLException, ClassNotFoundException;
    public  void update(T t);
    public List<T> list();
    public  T getById(ID id);
    public void  remove(ID id);
}
