package test.sls.activeloggers.api.model;

import java.util.Map;

public class ActivePostRequest {
    private Map<Long, Long> userIdToPostIdMap;
    private int activePostThreshold;

    public int getActivePostThreshold() {
        return activePostThreshold;
    }

    public void setActivePostThreshold(int activePostThreshold) {
        this.activePostThreshold = activePostThreshold;
    }

    public Map<Long, Long> getUserIdToPostIdMap() {
        return userIdToPostIdMap;
    }

    public void setUserIdToPostIdMap(Map<Long, Long> userIdToPostIdMap) {
        this.userIdToPostIdMap = userIdToPostIdMap;
    }
}
