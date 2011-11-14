package ilife.song.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * 歌曲风格
 * 例如，rock，说唱
 * @author liujijun
 *
 */
@Entity
public class Genre {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	@ManyToMany(mappedBy="genres")
	private List<Song> songs=new ArrayList<Song>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}
	

}
