package ilife.music.dao.impl;

import ilife.common.dao.GenericDao;
import ilife.common.dao.impl.GenericDaoImpl;
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
public class SongDaoImpl extends GenericDaoImpl<Song, Long> implements GenericDao<Song, Long> {

	public SongDaoImpl() {
		super(Song.class);
	}
	
}
