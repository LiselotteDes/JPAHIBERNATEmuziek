package be.vdab.muziek.services;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.muziek.entities.Album;
import be.vdab.muziek.exceptions.AlbumNietGevondenException;
import be.vdab.muziek.repositories.AlbumRepository;

@Service
@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
class DefaultAlbumService implements AlbumService {
	
	private final AlbumRepository repository;
	DefaultAlbumService(AlbumRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public BigDecimal getTotaleTijd(long id) {
		Optional<Album> optionalAlbum = repository.read(id);
		if (optionalAlbum.isPresent()) {
			return optionalAlbum.get().getTotaleTijd();
		}
		else {
			throw new AlbumNietGevondenException();
		}
	}
}
