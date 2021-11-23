package tutorial.redis.example.config.security;

import org.springframework.data.repository.CrudRepository;

public interface CustomUserDetailsRedisRepository extends CrudRepository<CustomUserDetails, String> {
}
