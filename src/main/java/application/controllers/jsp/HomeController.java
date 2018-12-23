package application.controllers.jsp;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.fasterxml.jackson.core.JsonProcessingException;

import application.services.exceptions.InternalServerErrorException;
import application.services.exceptions.NotAcceptableException;
import application.services.exceptions.NotFoundException;

@Controller
public class HomeController {

	private static Logger logger = Logger.getLogger(HomeController.class);

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/test1", method = RequestMethod.GET)
	public RedirectView post()
			throws JsonProcessingException, InternalServerErrorException, NotAcceptableException, NotFoundException {
		logger.trace("GET /");
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl("/web/home.html");
		return redirectView;
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/test2", method = RequestMethod.GET)
	public String test1()
			throws JsonProcessingException, InternalServerErrorException, NotAcceptableException, NotFoundException {
		logger.trace("GET /");

		return "home.html";
	}
}
