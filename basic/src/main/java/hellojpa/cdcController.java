package hellojpa;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class cdcController {

    private final cdcService cdcService;

    @PostMapping("/test")
    public void registerSurvey(@RequestBody dto request){
        cdcService.register(request);
    }
}
