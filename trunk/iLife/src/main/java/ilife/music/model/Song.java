package ilife.music.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * 
 * @author liujijun
 * 
 */
@Entity
public class Song {
	@Id
	@GeneratedValue
	private Long id;

	private String name;
	/* 风格 */
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinTable(joinColumns = @JoinColumn(name = "song_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "genre_id", referencedColumnName = "id"))
	private List<Genre> genres = new ArrayList<Genre>();
	/* 艺术家 */
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinTable(joinColumns = @JoinColumn(name = "song_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "artist_id", referencedColumnName = "id"))
	private Collection<Artist> artists = new ArrayList<Artist>();
	/* 专辑 */
	@ManyToOne
	private Album album;

	private String image;

	private String tags;

	private String url;

	private String lyric;

	private String md5;

	private int time;

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

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	public Collection<Artist> getArtists() {
		return artists;
	}

	public void setArtists(Collection<Artist> artists) {
		this.artists = artists;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getLyric() {
		return lyric;
	}

	public void setLyric(String lyric) {
		this.lyric = lyric;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

}
