package ilife.music.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 */
@Controller
@RequestMapping("/")
public class SongController {

//	@Autowired
//	private SongService songService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String index() {
//		Song song = new Song();
//		song.setName("Java");
//		song.setLyric("ddddd");
//		song.setTags("shanqing");
//		Album a = songService.addAlbum(new Album("wu"));
//		song.setAlbum(a);
//		System.out.println(a.getId()+"=====================================");
//		songService.addSong(song);
		return "index";
	}

	@RequestMapping("{songId}")
	public String getSong(@PathVariable Long songId) {
		// songService.getSongById(songId);
		return "";
	}

}
