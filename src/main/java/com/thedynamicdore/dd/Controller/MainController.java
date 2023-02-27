package com.thedynamicdore.dd.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
@RestController

//@RequestMapping(path= "/api")
public class MainController {

    // GET request that returns a HashMap with a "Result" message and a status code of 200
    @GetMapping(path="/api/hm")
    public HashMap<String, String> getRequest() {
        HashMap<String, String> response = new HashMap<String, String>();
        try {
            // simulate some work being done here
            Thread.sleep(1000);
            response.put("Result", "Hello World !");
            response.put("Status", "200");
        } catch (InterruptedException e) {
            // handle any exceptions that may be thrown during execution
            response.put("Error", "An error occurred: " + e.getMessage());
            response.put("Status", "500");
        }
        // return the response
        return response;
    }

    // GET request that returns a simple "Hello World !" message
    @GetMapping(path = "/api/hw")
    public String getRequest4(){
        return "Hello World !";
    }

    // GET request that takes a "name" parameter and returns a HashMap with a "Result" message and a status code of 200
    @GetMapping(path="/api/rn")
    public HashMap<String,String> getRequest3(@RequestParam (value = "name" , defaultValue = "World") String name){
        HashMap<String,String> responses = new HashMap<String,String>();

        responses.put("Result" , "Hello " + name);
        responses.put("Status" , "200");

        return responses;
    }

    // POST request that returns a simple "This is POST request" message
    @PostMapping(path="/api/pr")
    public String getPostRequest(){
        return "This is POST request";
    }

    // DELETE request that returns a simple "This is DELETE request" message
    @DeleteMapping(path="/api/dr")
    public String getDeleteRequest(){
        return "This is DELETE request";
    }
}
