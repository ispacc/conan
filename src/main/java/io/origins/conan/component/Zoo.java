package io.origins.conan.component;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "zoo")
@Data
public class Zoo {
    private String name;
    private Integer age;

}
