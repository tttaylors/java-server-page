package br.com.letscode.javaserverpage.controller.execptionhandler.handler;

import br.com.letscode.javaserverpage.controller.execptionhandler.exception.DuplicateBookException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class HandlerException {

    @ExceptionHandler(value = DuplicateBookException.class)
    ModelAndView duplicateBookException(DuplicateBookException e) {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("reference", e.getBook().getIsbn());
        modelAndView.addObject("object", e.getBook());
        modelAndView.addObject("message", "Cannot add an already existing book");
        modelAndView.setViewName("error/errorBook");
        return modelAndView;
    }
}
