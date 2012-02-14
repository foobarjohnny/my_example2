package ilife.music.service;

import ilife.music.model.Song;

import java.util.List;


public interface SongService {

	public List<Song> search(String keywords);

	
	
}
