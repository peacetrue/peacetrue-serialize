package com.github.peacetrue.serialize;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiayx
 */
@Configuration
public class JavaSerializeAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(SerializeService.class)
    public SerializeService serializeService() {
        return JavaSerializeService.DEFAULT;
    }

}
