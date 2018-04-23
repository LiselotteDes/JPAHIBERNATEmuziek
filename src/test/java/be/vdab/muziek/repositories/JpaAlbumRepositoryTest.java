package be.vdab.muziek.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;

import be.vdab.muziek.entities.Album;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Sql("/insertAlbum.sql")
@Import(JpaAlbumRepository.class)
public class JpaAlbumRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {
	
	@Autowired
	private JpaAlbumRepository repository;
	
	private long idVanTestAlbum() {
		/*
		 * Het resultaat van een select statement met 1 rij en 1 kolom is een scalar value.
		 * Een scalar value lees je met de JdbcTemplate method queryForObject.
		 */
		return super.jdbcTemplate.queryForObject("select id from albums where naam='test'", Long.class);
	}
	
	@Test
	public void read() {
		Album album = repository.read(idVanTestAlbum()).get();
		assertEquals("test", album.getNaam());
	}
	@Test
	public void readOnbestaandeDocent() {
		assertFalse(repository.read(-1).isPresent());
	}
	@Test
	public void findAll() {
		List<Album> albums = repository.findAll();
		assertEquals(super.countRowsInTable("albums"), albums.size());
		String vorigeAlbumNaam = "";
		for(Album album : albums) {
			assertTrue(album.getNaam().compareTo(vorigeAlbumNaam) >= 0);
			vorigeAlbumNaam = album.getNaam();
		}
	}
}
