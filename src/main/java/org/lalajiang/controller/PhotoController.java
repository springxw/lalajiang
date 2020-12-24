package org.lalajiang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/photos")
public class PhotoController {

    @RequestMapping("/show")
    public String show(){
        return "user/photoShow";
    }
}
