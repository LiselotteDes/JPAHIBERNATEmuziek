package be.vdab.muziek.services;

import java.util.List;
import java.util.Optional;

import be.vdab.muziek.entities.Album;

public interface AlbumService {
	List<Album> findAll();
	Optional<Album> read(long id);
}
