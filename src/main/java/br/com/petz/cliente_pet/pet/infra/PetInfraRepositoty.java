package br.com.petz.cliente_pet.pet.infra;

import br.com.petz.cliente_pet.pet.application.repository.PetRepository;
import br.com.petz.cliente_pet.pet.domain.Pet;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@Repository
@Log4j2
@RequiredArgsConstructor
public class PetInfraRepositoty implements PetRepository {
    private final PetSpringDataJPARepository petSpringDataJPARepository;

    @Override
    public Pet salvaPet(Pet pet) {
        log.info("[Start]PetInfraRepositoty - salvaPet");
        petSpringDataJPARepository.save(pet);
        log.info("[Finish]PetInfraRepositoty - salvaPet");
        return pet;
    }
}
