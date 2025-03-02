package top.sob.auth.spring.dao.redis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginCacheDaoImpl implements LoginCacheDao {

    StringRedisTemplate redis;

    String loginCacheName;

    @Override
    public void setLogin(String address, long id) {
        redis.opsForHash().put(loginCacheName, address, String.valueOf(id));
    }

    @Override
    public long getLogin(String address) {
        var res = redis.opsForHash().get(loginCacheName, address);
        if (res == null)
            return -1;
        return Long.parseLong(res.toString());
    }

    @Override
    public boolean removeLogin(String address) {
        return redis.opsForHash().delete(loginCacheName, address) == 1;
    }
}
