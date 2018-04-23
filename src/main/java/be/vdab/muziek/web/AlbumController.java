package be.vdab.muziek.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.muziek.services.AlbumService;

@Controller
@RequestMapping("albums")
class AlbumController {
	
	private AlbumService albumService;
	AlbumController(AlbumService albumService) {
		this.albumService = albumService;
	}
	
	private static final String ALBUM_VIEW = "album";
	@GetMapping("{id}")
	ModelAndView album(@PathVariable long id) {
		ModelAndView modelAndView = new ModelAndView(ALBUM_VIEW);
		albumService.read(id).ifPresent(album -> modelAndView.addObject(album));
		return modelAndView;
	}
}
