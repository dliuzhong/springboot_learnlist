package readinglist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/readingList")
public class ReadingListController {

	private static final String READER = "dliuzhong";
	
	private ReadingListRepository readinglr;
	
	@Autowired
	public ReadingListController(ReadingListRepository readingListRepository) {
		this.readinglr = readingListRepository;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String readersBooks(Model model) {
		List<Book> readingList = readinglr.findByReader(READER);
		if (readingList != null) {
			model.addAttribute("books", readingList);
		}
		return "readingList";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String addToReadingList(Book book) {
		book.setReader(READER);
		readinglr.save(book);
		return "redirect:/readingList";
	}
}
