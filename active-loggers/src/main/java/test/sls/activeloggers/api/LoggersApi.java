package test.sls.activeloggers.api;


import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import test.sls.activeloggers.api.model.ActivePostRequest;
import test.sls.activeloggers.api.model.ActivePostResponse;
import test.sls.activeloggers.service.PostService;

@RestController
@RequestMapping(path = "/loggers")
public class LoggersApi {
    @Autowired
    private PostService postService;

    @ApiOperation(value = "get list of active posts by threshold determined in body (activePostThreshold field)")
    @RequestMapping(method = RequestMethod.POST, path = "/post/active")
    public @ResponseBody
    ActivePostResponse findActivePosts(@RequestBody ActivePostRequest activePostRequest){
       ActivePostResponse activePostResponse = postService.findActivePostsByUserId(activePostRequest);
       return activePostResponse;
    }

}
