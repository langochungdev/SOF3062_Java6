package web.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyC {

    @GetMapping({"/", "/poly/url0"})
    public String method0(Model model, Authentication auth) {
        model.addAttribute("message", "/poly/url0 => method0()");
        if (auth != null) {
            model.addAttribute("username", auth.getName());
            model.addAttribute("authorities", auth.getAuthorities());
        }
        return "page";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/poly/url1")
    public String method1(Model model, Authentication auth) {
        model.addAttribute("message", "/poly/url1 => method1()");
        if (auth != null) {
            model.addAttribute("username", auth.getName());
            model.addAttribute("authorities", auth.getAuthorities());
        }
        return "page";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/poly/url2")
    public String method2(Model model, Authentication auth) {
        model.addAttribute("message", "/poly/url2 => method2()");
        if (auth != null) {
            model.addAttribute("username", auth.getName());
            model.addAttribute("authorities", auth.getAuthorities());
        }
        return "page";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/poly/url3")
    public String method3(Model model, Authentication auth) {
        model.addAttribute("message", "/poly/url3 => method3()");
        if (auth != null) {
            model.addAttribute("username", auth.getName());
            model.addAttribute("authorities", auth.getAuthorities());
        }
        return "page";
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/poly/url4")
    public String method4(Model model, Authentication auth) {
        model.addAttribute("message", "/poly/url4 => method4()");
        if (auth != null) {
            model.addAttribute("username", auth.getName());
            model.addAttribute("authorities", auth.getAuthorities());
        }
        return "page";
    }
}
