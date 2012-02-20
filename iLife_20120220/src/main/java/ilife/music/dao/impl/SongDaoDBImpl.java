package ilife.music.dao.impl;

import ilife.common.dao.impl.GenericDaoImpl;
import ilife.music.dao.SongDao;
import ilife.music.model.Song;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class SongDaoDBImpl extends GenericDaoImpl<Song, Long> implements SongDao {
	@PersistenceContext
	private EntityManager entityManager;

	public SongDaoDBImpl() {
		super(Song.class);
	}

	@Override
	public List<Song> search(String keywords) {
		Query query = entityManager.createNamedQuery("searchSong",Song.class);
		query.setParameter("keyword", "%" + keywords.toUpperCase() + "%");
		@SuppressWarnings("unchecked")
		List<Song> resultList = query.getResultList();
		return resultList;
	}


}
