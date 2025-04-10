package com.app.contoller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
//@PreAuthorize("denyAll()")
public class TestAuthController {

    @GetMapping("/get")
    //@PreAuthorize("hasAuthority('READ')")
    public String helloGet (){
        return "Hello World - GET! \uD83E\uDEE1";
    }

    @PostMapping("/post")
    //@PreAuthorize("hasAuthority('CREATE')")
    public String helloPost(){
        return "Hello World - POST! \uD83E\uDEE1";
    }

    @PutMapping("/put")
    public String helloPut(){
        return "Hello World - PUT! \uD83E\uDEE1";
    }

    @DeleteMapping("/delete")
    public String helloDelete(){
        return "Hello World - DELETE! \uD83E\uDEE1";
    }

    @PatchMapping("/patch")
    //@PreAuthorize("hasAuthority('REFACTOR')")
    public String helloPatch(){
        return "Hello World - PATCH! \uD83E\uDEE1";
    }
}
