package com.xtpeach.tiny.id.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * feign 接口获取id
 */
@FeignClient(name = "tiny-id-server", path = "/tiny-id/id/")
public interface TinyIdFeign {

    @RequestMapping("nextSegmentIdSimple")
    String nextSegmentIdSimple(@RequestParam("bizType") String bizType
            , @RequestParam("token") String token);

}
