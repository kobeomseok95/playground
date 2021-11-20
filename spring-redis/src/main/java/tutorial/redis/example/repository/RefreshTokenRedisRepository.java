package tutorial.redis.example.repository;

import org.springframework.data.repository.CrudRepository;
import tutorial.redis.example.config.redis.RefreshToken;

public interface RefreshTokenRedisRepository extends CrudRepository<RefreshToken, String> {
}
