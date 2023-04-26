package hellojpa;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class cdcService {


    private final cdcRepository cdcRepository;

    @Transactional
    public void register(dto dto) {
        accounts cdcDomain = new accounts(dto.getAccount_id(), dto.getRole_id(), dto.getUser_name(), dto.getUser_description(), dto.getUpdate_date());
        cdcRepository.save(cdcDomain);
    }

}
