package com.test.controller;

import com.test.model.request.SessionRequest;
import com.test.model.response.SessionResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpSession;

@RestController
public class SessionController {

    @RequestMapping(value = "/sessionstart", method = RequestMethod.POST)
    public String sessionStart(@RequestBody SessionRequest sessionRequest, HttpSession session) {
        session.setAttribute("sessionResponse", new SessionResponse(sessionRequest.getName(), sessionRequest.getId()));
        return "New session response created.";
    }

    @RequestMapping(value = "/sessioncontinue", method = RequestMethod.POST)
    public String sessionMid(@RequestBody SessionRequest sessionRequest, HttpSession session) {
        if (session.isNew()) {
            return "New session.";
        } else {
            SessionResponse sessionResponse = (SessionResponse) session.getAttribute("sessionResponse");
            if(sessionResponse==null) {
                return "Session response is null.";
            }
            return sessionResponse.toString();
        }
    }

    @RequestMapping(value = "/sessionend", method = RequestMethod.POST)
    public String deleteSession(@RequestBody SessionRequest sessionRequest, HttpSession session) {
        session.invalidate();
        return "Session is terminated.";
    }

    @RequestMapping(value = "/sessioncontinue2")
    public String sessionMid(HttpSession session) {
        if (session.isNew()) {
            return "New session.";
        } else {
            SessionResponse sessionResponse = (SessionResponse) session.getAttribute("sessionResponse");
            if(sessionResponse==null) {
                return "Session response is null.";
            }
            return sessionResponse.toString();
        }
    }
}
