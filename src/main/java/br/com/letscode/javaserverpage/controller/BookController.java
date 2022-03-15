package br.com.letscode.javaserverpage.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import br.com.letscode.javaserverpage.service.BookService;
import br.com.letscode.javaserverpage.model.Book;
import org.springframework.stereotype.Controller;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;

@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @RequestMapping("/read-book")
    public String showReadBookPage(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "readBook";
    }

    @RequestMapping("/create-book")
    public String showCreateBookPage(Model model) {
        model.addAttribute("command", new Book());
        return "createBook";
    }

    @RequestMapping(value = "/create-book", method = RequestMethod.POST)
    public String createBook(@ModelAttribute("book") Book book) {
        bookService.save(book);
        return "redirect:/read-book";
    }

    @RequestMapping(value = "/update-book/{id}")
    public String showUpdateBookPage(@PathVariable Long id, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("command", bookService.findById(id));
        return "updateBook";
    }

    @RequestMapping(value = "/update-book/{id}", method = RequestMethod.POST)
    public String updateBook(@PathVariable Long id, @ModelAttribute("book") Book book) {
        bookService.update(id, book);
        return "redirect:/read-book";
    }

    @RequestMapping(value = "/delete-book/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteById(id);
        return "redirect:/read-book";
    }
}
