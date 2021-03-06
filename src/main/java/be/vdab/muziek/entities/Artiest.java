package be.vdab.muziek.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "artiesten")
public class Artiest implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String naam;
	// FOUT, overbodig (geen BIdirectionele associatie nodig)
	/*@OneToMany(mappedBy = "artiest")
	@OrderBy("naam")
	private Set<Album> albums = new LinkedHashSet<>();*/
	
	public Artiest(String naam) {
		this.naam = naam;
	}
	protected Artiest() {
	}
	
	public long getId() {
		return id;
	}
	public String getNaam() {
		return naam;
	}
	/*public Set<Album> getAlbums() {
		return Collections.unmodifiableSet(albums);
	}*/
	/* OVERBODIG:
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((naam == null) ? 0 : naam.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Artiest))
			return false;
		Artiest other = (Artiest) obj;
		if (naam == null) {
			if (other.naam != null)
				return false;
		} else if (!naam.equals(other.naam))
			return false;
		return true;
	}*/
}
