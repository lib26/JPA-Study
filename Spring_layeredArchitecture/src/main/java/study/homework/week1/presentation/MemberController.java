package study.homework.week1.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import study.homework.week1.application.MemberService;
import study.homework.week1.application.dto.RegisterMemberResponseDto;
import study.homework.week1.presentation.dto.RegisterMemberRequest;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/members")
    public ResponseEntity registerMember(@RequestBody @Validated  RegisterMemberRequest request){
        RegisterMemberResponseDto response = memberService.registerMember(request.toServiceEntity());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
