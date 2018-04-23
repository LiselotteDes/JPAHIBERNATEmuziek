package be.vdab.muziek.web;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import be.vdab.muziek.entities.Album;
import be.vdab.muziek.services.AlbumService;

@Controller
@RequestMapping("albums")
class AlbumController {
	
	private AlbumService albumService;
	AlbumController(AlbumService albumService) {
		this.albumService = albumService;
	}
	
	private static final String ALBUM_VIEW = "album";
	private static final String REDIRECT_ALBUM_NIET_GEVONDEN = "redirect:/";
	@GetMapping("{id}")
	ModelAndView album(@PathVariable long id, RedirectAttributes redirectAttributes) {
		/*ModelAndView modelAndView = new ModelAndView(ALBUM_VIEW);
		albumService.read(id).ifPresent(album -> modelAndView.addObject(album));
		return modelAndView;*/
		Optional<Album> optionalAlbum = albumService.read(id);
		if (optionalAlbum.isPresent()) {
			return new ModelAndView(ALBUM_VIEW).addObject(optionalAlbum.get());
		}
		redirectAttributes.addAttribute("fout", "album niet gevonden");
		return new ModelAndView(REDIRECT_ALBUM_NIET_GEVONDEN);
	}
}
