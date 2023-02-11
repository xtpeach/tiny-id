package com.xtpeach.tiny.id.config;

import com.xtpeach.tiny.id.feign.TinyIdFeign;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class TinyIdConfig implements InitializingBean {

    private static TinyIdConfig instance = null;

    public static TinyIdConfig getInstance() {
        return instance;
    }

    @Override
    public void afterPropertiesSet() {
        instance = this;
    }

    /**
     * 注入 tinyIdFeign
     */
    @Resource
    private TinyIdFeign tinyIdFeign;

    /**
     * 获取配置 token，默认为 tiny-id-token
     */
    @Value("${tiny-id.token:tiny-id-token}")
    private String token;

    /**
     * 获取 tiny-id feign 接口
     *
     * @return
     */
    public TinyIdFeign getTinyIdFeign() {
        return tinyIdFeign;
    }

    /**
     * tiny-id token
     *
     * @return
     */
    public String getToken() {
        return token;
    }
}
