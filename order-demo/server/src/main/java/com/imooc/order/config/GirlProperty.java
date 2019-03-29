package com.imooc.order.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @author 张进文
 * @ClassName GirlProperty
 * @Description TODO
 * @Date 2019/3/25 15:54
 * @Version 1.0
 */
@Data
@Component
@ConfigurationProperties(prefix = "girl")
@RefreshScope
public class GirlProperty {

    private String name;
    private Integer age;
}
