package com.test.controller;

import com.test.model.request.RequestMethodsRequest;
import com.test.model.response.RequestMethodsResponse;
import org.springframework.web.bind.annotation.*;

@RestController
public class OtherController {

    @RequestMapping(value = "/method/example", method = RequestMethod.GET)
    public RequestMethodsResponse getExample(@RequestParam(value="message", required = false) String message){
        System.out.println("Get Method : used for getting information");
        RequestMethodsResponse response=new RequestMethodsResponse();
        response.setRequestMethod(RequestMethod.GET);
        response.setMessage(message);
        response.setName("Get Method : used for getting information");
        return response;
    }

    @RequestMapping(value = "/method/example", method = RequestMethod.HEAD)
    public RequestMethodsResponse headExample(){
        System.out.println("Head Method : used for control");
        RequestMethodsResponse response=new RequestMethodsResponse();
        response.setRequestMethod(RequestMethod.HEAD);
        response.setMessage("");
        response.setName("Head Method : used for control");
        return response;
    }

    @RequestMapping(value = "/method/example", method = RequestMethod.POST)
    public RequestMethodsResponse postExample(@RequestBody RequestMethodsRequest requestMethodsRequest){
        System.out.println("Post Method : used for creating ");
        RequestMethodsResponse response=new RequestMethodsResponse();
        response.setRequestMethod(RequestMethod.POST);
        response.setMessage(requestMethodsRequest.getMessage());
        response.setName("Post Method : used for creating");
        return response;
    }

    @RequestMapping(value = "/method/example", method = RequestMethod.PUT)
    public RequestMethodsResponse putExample(@RequestBody RequestMethodsRequest requestMethodsRequest){
        System.out.println("Put Method : used for updating all component");
        RequestMethodsResponse response=new RequestMethodsResponse();
        response.setRequestMethod(RequestMethod.PUT);
        response.setMessage(requestMethodsRequest.getMessage());
        response.setName("Put Method : used for updating all component");
        return response;
    }

    @RequestMapping(value = "/method/example", method = RequestMethod.DELETE)
    public RequestMethodsResponse deleteExample(@RequestBody RequestMethodsRequest requestMethodsRequest){
        System.out.println("Delete Method : used for deleting");
        RequestMethodsResponse response=new RequestMethodsResponse();
        response.setRequestMethod(RequestMethod.DELETE);
        response.setMessage(requestMethodsRequest.getMessage());
        response.setName("Delete Method : used for deleting");
        return response;
    }

    @RequestMapping(value = "/method/example", method = RequestMethod.OPTIONS)
    public RequestMethodsResponse optionsExample(@RequestBody RequestMethodsRequest requestMethodsRequest){
        System.out.println("Options Method : used for url details");
        RequestMethodsResponse response=new RequestMethodsResponse();
        response.setRequestMethod(RequestMethod.OPTIONS);
        response.setMessage(requestMethodsRequest.getMessage());
        response.setName("Options Method : used for url details");
        return response;
    }

    @RequestMapping(value = "/method/example", method = RequestMethod.PATCH)
    public RequestMethodsResponse patchExample(@RequestBody RequestMethodsRequest requestMethodsRequest){
        System.out.println("Patch Method : used for updating some part of component");
        RequestMethodsResponse response=new RequestMethodsResponse();
        response.setRequestMethod(RequestMethod.PATCH);
        response.setMessage(requestMethodsRequest.getMessage());
        response.setName("Patch Method : used for updating some part of component");
        return response;
    }

    @RequestMapping(value = "/method/example", method = RequestMethod.TRACE)
    public RequestMethodsResponse traceExample(@RequestBody RequestMethodsRequest requestMethodsRequest){
        System.out.println("Trace Method");
        RequestMethodsResponse response=new RequestMethodsResponse();
        response.setRequestMethod(RequestMethod.TRACE);
        response.setMessage(requestMethodsRequest.getMessage());
        response.setName("Trace Method");
        return response;
    }

    @RequestMapping(value = "/method/test", method = RequestMethod.PUT)
    public void test(Integer no){
        System.out.println("start with " + no);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("finish with " + no);
    }

}
