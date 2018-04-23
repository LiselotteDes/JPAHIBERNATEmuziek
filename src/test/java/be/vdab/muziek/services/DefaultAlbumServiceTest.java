package be.vdab.muziek.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import be.vdab.muziek.entities.Album;
import be.vdab.muziek.entities.Artiest;
import be.vdab.muziek.exceptions.AlbumNietGevondenException;
import be.vdab.muziek.repositories.AlbumRepository;

//UNIT TESTS VOOR DE SERVICE CLASS

@RunWith(MockitoJUnitRunner.class)
public class DefaultAlbumServiceTest {
	
	private DefaultAlbumService service;
	@Mock
	private AlbumRepository repository;
	private Album album;
	
	@Before
	public void before() {
		Artiest artiest = new Artiest("test");
		album = new Album(artiest, "test");
		when(repository.read(1)).thenReturn(Optional.of(album));
		when(repository.read(-1)).thenReturn(Optional.empty());
		service = new DefaultAlbumService(repository);
	}

	@Test
	public void getTotaleTijd() {
		service.getTotaleTijd(1);
		verify(repository).read(1);
	}
	@Test(expected = AlbumNietGevondenException.class)
	public void getTotaleTijdVanOnbestaandAlbum() {
		service.getTotaleTijd(-1);
		verify(repository).read(-1);
	}
}
