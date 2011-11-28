package ilife.music.service.impl;

import ilife.music.dao.SongDao;
import ilife.music.model.Album;
import ilife.music.model.Artist;
import ilife.music.model.Song;
import ilife.music.service.SongService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author liujijun
 * 
 */
@Service
public class SongServiceImpl implements SongService {
	@Autowired
	private SongDao songDao;

	public Song addSong(Song song) {
		return songDao.addSong(song);
	}

	public void removeSong(Long songId) {

	}

	public void updateSong(Song song) {

	}

	public Song getSongById(Long songId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Song> getSongsByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Song> getSongsByAlbum(Album album) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Song> getSongsByArtist(Artist artist) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Song> getSongsByLyric(String searchParam) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getLyricBySong(Long songId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addLyricForSong(Long songId, String lyric) {
		// TODO Auto-generated method stub

	}

	public Album addAlbum(Album album) {
		return songDao.addAlbum(album);
	}

}