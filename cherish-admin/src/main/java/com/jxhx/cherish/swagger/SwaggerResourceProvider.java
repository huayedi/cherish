package com.jxhx.cherish.swagger;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;

import java.util.ArrayList;
import java.util.List;

/**
 * swagger2 多模块配置
 * @author: 张韶杰
 * @date: 2020/1/7 20:02
 **/
@Component
@Primary
public class SwaggerResourceProviderConfig extends SwaggerResourceProvider{
    @Override
    public List<SwaggerResource> get() {
        List resources = new ArrayList<>();
        resources.add(swaggerResource("管理端接口", "/admin/v2/api-docs", "1.0"));
        resources.add(swaggerResource("web端接口", "/web/v2/api-docs", "1.0"));
        return resources;
    }


    private SwaggerResource swaggerResource(String name, String location, String version) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion(version);
        return swaggerResource;
    }
}
