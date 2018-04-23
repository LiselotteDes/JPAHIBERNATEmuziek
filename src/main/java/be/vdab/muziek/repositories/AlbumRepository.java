package be.vdab.muziek.repositories;

import java.util.List;
import java.util.Optional;

import be.vdab.muziek.entities.Album;

public interface AlbumRepository {
	Optional<Album> read(long id);
	List<Album> findAll();
}
