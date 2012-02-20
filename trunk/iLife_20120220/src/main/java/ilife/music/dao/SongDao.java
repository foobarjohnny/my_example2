package ilife.music.dao;

import ilife.common.dao.GenericDao;
import ilife.music.model.Song;

import java.util.List;

public interface SongDao extends GenericDao<Song, Long> {

	public List<Song> search(String keywords);
	
}
