package com.steven.nagie.bootstrap;

import com.steven.nagie.api.ApiConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
    ApiConfiguration.class
})
public class ITConfig {
}
