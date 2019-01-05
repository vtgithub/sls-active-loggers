package test.sls.activeloggers.api.model;

import java.util.List;

public class ActivePostResponse {
    private List<Long> activePostList;

    public ActivePostResponse(List<Long> activePostList) {
        this.activePostList = activePostList;
    }


    public List<Long> getActivePostList() {
        return activePostList;
    }

    public void setActivePostList(List<Long> activePostList) {
        this.activePostList = activePostList;
    }
}
