package top.sob.auth.spring.dao.redis;

public interface LoginCacheDao {

    void setLogin(String address, long id);

    long getLogin(String address);

    boolean removeLogin(String address);

}
