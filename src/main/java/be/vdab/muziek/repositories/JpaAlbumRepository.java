package be.vdab.muziek.repositories;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import be.vdab.muziek.entities.Album;

@Repository
class JpaAlbumRepository implements AlbumRepository {
	
	private final EntityManager manager;
	JpaAlbumRepository(EntityManager manager) {
		this.manager = manager;
	}
	
	@Override
	public Optional<Album> read(long id) {
//		throw new UnsupportedOperationException();
		return Optional.ofNullable(manager.find(Album.class, id));
	}
	@Override
	public List<Album> findAll() {
//		throw new UnsupportedOperationException();
		return manager
				.createNamedQuery("Album.findAll", Album.class)
				.setHint("javax.persistence.loadgraph", manager.createEntityGraph(Album.MET_ARTIEST))
				.getResultList();
	}
}
