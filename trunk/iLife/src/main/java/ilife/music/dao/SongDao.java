package ilife.music.dao;

import ilife.music.model.Album;
import ilife.music.model.Artist;
import ilife.music.model.Song;

import java.util.List;

public interface SongDao {

	public Song addSong(Song song);

	public void removeSong(Long songId);

	public void updateSong(Song song);

	public Song getSongById(Long songId);

	public List<Song> getSongsByName(String name);

	public List<Song> getSongsByAlbum(Album album);

	public List<Song> getSongsByArtist(Artist artist);

	public List<Song> getSongsByLyric(String searchParam);

	public String getLyricBySong(Long songId);

	public void addLyricForSong(Long songId, String lyric);

	public Album addAlbum(Album album);


}