package dao.generics;

/**
 * Created by dario on 2015-11-08.
 */
public interface GenericDao<T> {

    T create(T t);
    boolean delete(Object id);
    T find(Object id);
    T update(T t);
}
