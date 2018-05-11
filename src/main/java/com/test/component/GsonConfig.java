package com.test.component;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
class GsonConfig {

    @Bean
    public Gson gson() {
        Gson gson = new GsonBuilder().
                setPrettyPrinting().
                disableHtmlEscaping().
                disableInnerClassSerialization().
                create();
        return gson;
    }
}
