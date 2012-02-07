package ilife.music.dao.impl;

import ilife.common.dao.impl.GenericDaoImpl;
import ilife.common.model.Paging;
import ilife.music.dao.SongDao;
import ilife.music.model.Song;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class SongDaoDBImpl extends GenericDaoImpl<Song, Long> implements SongDao {

	public SongDaoDBImpl() {
		super(Song.class);
	}


}
