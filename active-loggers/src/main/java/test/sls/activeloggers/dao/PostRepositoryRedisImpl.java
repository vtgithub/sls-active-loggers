package test.sls.activeloggers.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PostRepositoryRedisImpl implements PostRepository{
    @Autowired
    private RedisTemplate redisTemplate;


    @Override
    public boolean addCommentInfo(Long userId, Long postId, int activePostThreshold) {
        if (!redisTemplate.opsForSet().isMember(postId.toString(), userId)){
            redisTemplate.opsForSet().add(postId.toString(), userId);
        }
        if (redisTemplate.opsForSet().size(postId.toString()).intValue() == activePostThreshold){
            redisTemplate.opsForSet().getOperations().delete(postId.toString());
            return true;
        }
        else
            return false;
    }
}
