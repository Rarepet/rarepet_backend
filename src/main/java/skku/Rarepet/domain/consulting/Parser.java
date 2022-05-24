package skku.Rarepet.domain.consulting;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class Parser {

    public Optional<Long> parseId(String sid) {
        Long id = null;
        try {
            id = Long.valueOf(sid);
        } catch (Exception e) {
            log.debug("An error occured: {}", e.getMessage());
        }

        return Optional.ofNullable(id);
    }
}
