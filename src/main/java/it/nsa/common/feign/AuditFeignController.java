package it.nsa.common.feign;

import it.nsa.common.dto.SaveAuditDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

@Component
@FeignClient(name = "audit", url = "${feign.audit.url}")
public interface AuditFeignController {

    @PostMapping("${endpoint.audit.save}")
    void saveAudit(SaveAuditDto saveAuditDto);

}
