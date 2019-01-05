package test.sls.activeloggers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.sls.activeloggers.api.model.ActivePostRequest;
import test.sls.activeloggers.api.model.ActivePostResponse;
import test.sls.activeloggers.dao.PostRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public ActivePostResponse findActivePostsByUserId(ActivePostRequest activePostRequest) {
        boolean isActiveComment;
        List<Long> activePostList = new ArrayList<>();

        for (Map.Entry<Long, Long> postEntry : activePostRequest.getUserIdToPostIdMap().entrySet()) {
            isActiveComment = postRepository.addCommentInfo(
                    postEntry.getKey(),
                    postEntry.getValue(),
                    activePostRequest.getActivePostThreshold()
            );
            if (isActiveComment)
                activePostList.add(postEntry.getValue());
        }
        return new ActivePostResponse(activePostList);
    }
}
