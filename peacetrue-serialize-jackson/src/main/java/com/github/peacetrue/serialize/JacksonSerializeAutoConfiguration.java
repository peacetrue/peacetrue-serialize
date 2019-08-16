package com.github.peacetrue.serialize;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.peacetrue.jackson.ObjectMapperWrapper;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiayx
 */
@Configuration
@ConditionalOnClass({ObjectMapper.class})
@AutoConfigureAfter(JacksonAutoConfiguration.class)
public class JacksonSerializeAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(ObjectMapper.class)
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    @ConditionalOnMissingBean(ObjectMapperWrapper.class)
    public ObjectMapperWrapper objectMapperWrapper(ObjectMapper objectMapper) {
        return new ObjectMapperWrapper(objectMapper);
    }

    @Bean
    @ConditionalOnMissingBean(SerializeService.class)
    public SerializeService serializeService(ObjectMapperWrapper objectMapperWrapper) {
        return new JacksonSerializeService(objectMapperWrapper);
    }

}
