package ilife.music.dao.impl;

import ilife.music.dao.SongDao;
import ilife.music.model.Album;
import ilife.music.model.Artist;
import ilife.music.model.Song;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class SongDaoImpl implements SongDao {

	@PersistenceContext
	private EntityManager entityManager;

	public Song addSong(Song song) {
		Song s = entityManager.merge(song);
		entityManager.flush();
		return s;
	}

	public void removeSong(Long songId) {

	}

	public void updateSong(Song song) {

	}

	public Song getSongById(Long songId) {
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
		return null;
	}

	public void addLyricForSong(Long songId, String lyric) {
		// TODO Auto-generated method stub

	}

	public Album addAlbum(Album album) {
		Album a = entityManager.merge(album);
		entityManager.flush();
		return a;
	}

}
