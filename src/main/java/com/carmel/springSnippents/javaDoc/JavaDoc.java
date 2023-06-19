package com.carmel.springSnippents.javaDoc;

import com.carmel.springSnippents.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The controller for JavaDoc illustration
 * <p>
 *     This class is illustration of JavaDoc basics
 * </p>
 *
 * @author Victor
 */
@Controller
public class JavaDoc {

    /**
     * Handle the / endpoint
     */
    @RequestMapping("/")
    public String index(){ return "index";}


    /**
     * Illustration of @param key work in JavaDoc
     * @param jsonPojo Json representation
     * @return the same thing that receives
     */
    @PostMapping(value = "/post", consumes = "application/json", produces = "application/json")
    public User post(@RequestBody User jsonPojo){
        return jsonPojo;
    }
}
