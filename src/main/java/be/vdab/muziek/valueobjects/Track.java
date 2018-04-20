package be.vdab.muziek.valueobjects;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Embeddable;

import org.springframework.format.annotation.NumberFormat;

@Embeddable
public class Track implements Serializable {
	private static final long serialVersionUID = 1L;
	/*
	 * Deze value object class bevat geen variabele die verwijst naar het bijbehorende Album object:
	 * op die manier is Track herbruikbaar in andere entity classes: playlist, ...
	 */
	private String naam;
	@NumberFormat(pattern = "0.00")
	private BigDecimal tijd;
	
	public Track(String naam, BigDecimal tijd) {
		this.naam = naam;
		this.tijd = tijd;
	}
	protected Track() {
	}
	
	public String getNaam() {
		return naam;
	}
	public BigDecimal getTijd() {
		return tijd;
	}
	
	// equals & hashcode: enkel op naam. Je laadt immers enkel een set Tracks PER album. Dus enkel die moeten onderling verschillen.
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
		if (!(obj instanceof Track))
			return false;
		Track other = (Track) obj;
		if (naam == null) {
			if (other.naam != null)
				return false;
		} else if (!naam.equals(other.naam))
			return false;
		return true;
	}

}
