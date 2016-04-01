package com.rvr.lecture.common.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({ "classpath*:webSecurityConfig2.xml" })
@ComponentScan("com.rvr.lecture.security")
public class SecSecurityConfig {

    public SecSecurityConfig() {
        super();
    }

}
