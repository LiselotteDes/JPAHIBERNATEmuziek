package be.vdab.muziek.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.Table;

import org.springframework.format.annotation.NumberFormat;

import be.vdab.muziek.valueobjects.Track;

@Entity
@Table(name = "albums")
@NamedEntityGraph(name = Album.MET_ARTIEST, attributeNodes = @NamedAttributeNode("artiest"))
public class Album implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final String MET_ARTIEST = "Album.metArtiest";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String naam;
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "artiestid")
	private Artiest artiest;
	@ElementCollection
	@CollectionTable(name = "tracks", joinColumns = @JoinColumn(name = "albumid"))
	/*@OrderBy("naam")*/	// overbodig
	private Set<Track> tracks = new LinkedHashSet<>();
	
	public Album(Artiest artiest, String naam) {
		this.artiest = artiest;
		this.naam = naam;
	}
	protected Album() {
	}
	
	public long getId() {
		return id;
	}
	public Artiest getArtiest() {
		return artiest;
	}
	public String getNaam() {
		return naam;
	}
	public Set<Track> getTracks() {
		return Collections.unmodifiableSet(tracks);
	}
	
	@NumberFormat(pattern = "0.00")
	public BigDecimal getTotaleTijd() {
		return tracks.stream().map(track -> track.getTijd()).reduce(BigDecimal.ZERO, (vorigeSom, tijd) -> vorigeSom.add(tijd));
	}
	
	/* Overbodig:
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artiest == null) ? 0 : artiest.hashCode());
		result = prime * result + ((naam == null) ? 0 : naam.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Album))
			return false;
		Album other = (Album) obj;
		if (artiest == null) {
			if (other.artiest != null)
				return false;
		} else if (!artiest.equals(other.artiest))
			return false;
		if (naam == null) {
			if (other.naam != null)
				return false;
		} else if (!naam.equals(other.naam))
			return false;
		return true;
	}*/
}
