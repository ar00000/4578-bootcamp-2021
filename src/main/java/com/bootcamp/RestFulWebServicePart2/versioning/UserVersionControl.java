package com.bootcamp.RestFulWebServicePart2.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserVersionControl {

    @GetMapping(value = "/user/mime",produces = "application/vnd.company.app-v1+json")
    public UserV1 mimeTypeVersioningV1(){
        return new UserV1("John",26);
    }

    @GetMapping(value = "/user/mime", produces = "application/vnd.company.app-v2+json")
    public UserV2 mimeTypeVersioningV2(){
        return new UserV2("John",26,70.7,5.6);
    }

    @GetMapping(value = "/user/header", headers = "X-API-VERSION=1")
    public UserV1 headerVersioningV1(){
        return new UserV1("John",26);
    }

    @GetMapping(value = "/user/header", headers = "X-API-VERSION=2")
    public UserV2 headerVersioningV2(){
        return new UserV2("John",26,70.7,5.6);
    }

    @GetMapping("/user/v1")
    public UserV1 uriVersioningV1(){
        return new UserV1("John",26);
    }

    @GetMapping("/user/v2")
    public UserV2 uriVersioningV2(){
        return new UserV2("John",26,70.7,5.6);
    }

    @GetMapping(value = "/user/param", params = "version=1")
    public UserV1 paramVersioningV1(){
        return new UserV1("John",26);
    }

    @GetMapping(value = "/user/param", params = "version=2")
    public UserV2 paramVersioningV2(){
        return new UserV2("John",26,70.7,5.6);
    }
}
