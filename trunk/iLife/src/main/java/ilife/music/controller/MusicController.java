package ilife.music.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 */
@Controller
@RequestMapping("/music")
public class MusicController {

//	@Autowired
//	private SongService songService;
	
	@RequestMapping("{songId}")
	public String getSong(@PathVariable Long songId) {
		// songService.getSongById(songId);
		return "";
	}

}
