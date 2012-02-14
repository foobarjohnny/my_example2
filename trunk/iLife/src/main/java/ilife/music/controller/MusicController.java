package ilife.music.controller;

import ilife.music.service.SongService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 
 */
@Controller
@RequestMapping("/search")
public class MusicController {

	@Autowired
	private SongService songService;

	@RequestMapping(method = RequestMethod.GET)
	public String search(@RequestParam("keywords") String keywords, ModelMap model) {
		model.addAttribute("songlist", songService.search(keywords));
		return "song/list";
	}
}
