package be.vdab.muziek.valueobjects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class TrackTest {
	private Track track1, nogEensTrack1, track2;
	@Before
	public void before() {
		track1 = new Track("test", BigDecimal.ONE);
		nogEensTrack1 = new Track("test", BigDecimal.ONE);
		track2 = new Track("test2", BigDecimal.ONE);
	}
	
	// *** Equals & HashCode ***
	@Test
	public void tracksZijnGelijkAlsHunNamenGelijkZijn() {
		assertEquals(track1, nogEensTrack1);
	}
	@Test
	public void tracksZijnVerschillendAlsHunNamenVerschillen() {
		assertNotEquals(track1, track2);
	}
	@Test
	public void eenTrackVerschiltVanNull() {
		assertNotEquals(track1, null);
	}
	@Test
	public void eenTrackVerschiltVanEenAnderTypeObject() {
		assertNotEquals(track1, "");
	}
	@Test
	public void gelijkeTracksHebbenDezelfdeHashCode() {
		assertEquals(track1.hashCode(), nogEensTrack1.hashCode());
	}
}
