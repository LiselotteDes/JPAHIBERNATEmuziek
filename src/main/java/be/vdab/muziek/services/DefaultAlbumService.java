package be.vdab.muziek.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.muziek.entities.Album;
import be.vdab.muziek.repositories.AlbumRepository;

@Service
@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
class DefaultAlbumService implements AlbumService {
	
	private final AlbumRepository repository;
	DefaultAlbumService(AlbumRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public List<Album> findAll() {
		return repository.findAll();
	}
	@Override
	public Optional<Album> read(long id) {
		return repository.read(id);
	}
}
