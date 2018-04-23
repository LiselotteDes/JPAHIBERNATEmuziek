package be.vdab.muziek.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.muziek.services.AlbumService;

@Controller
@RequestMapping("/")
class IndexController {
	
	private AlbumService albumService;
	IndexController(AlbumService albumService) {
		this.albumService = albumService;
	}
	
	private static final String INDEX_VIEW = "index";
	@GetMapping
	ModelAndView albums() {
		ModelAndView modelAndView = new ModelAndView(INDEX_VIEW);
		modelAndView.addObject("albums", albumService.findAll());
		return modelAndView;
	}
}
