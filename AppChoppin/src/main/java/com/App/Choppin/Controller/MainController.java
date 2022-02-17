package com.App.Choppin.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MainController {

	// GET Menu inicial
	@RequestMapping("/")
	public ModelAndView abrirIndex() {
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
}
