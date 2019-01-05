package test.sls.activeloggers.dao;

public interface PostRepository {
    boolean addCommentInfo(Long userId, Long postId, int activePostThreshold);
}
