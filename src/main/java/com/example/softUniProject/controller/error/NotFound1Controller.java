package com.example.softUniProject.controller.error;

import com.example.softUniProject.exceptions.ObjectNotFoundException1;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class NotFound1Controller {
    @GetMapping("/not-found/{id}")
    public String notFound1(@PathVariable("id") String id) {
        throw new ObjectNotFoundException1( "Object with id: " + id + " was not found!",id);
    }


}
