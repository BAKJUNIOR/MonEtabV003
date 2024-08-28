package ci.digitalacademy.monetab.services.Impl;

import ci.digitalacademy.monetab.models.Address;
import ci.digitalacademy.monetab.repositories.AdressRepository;
import ci.digitalacademy.monetab.services.AddressService;
import ci.digitalacademy.monetab.services.dto.AddressDTO;
import ci.digitalacademy.monetab.services.mapper.AddressMapper;  // Assurez-vous que vous avez un mapper pour la conversion
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AddressServiceImpl implements AddressService {

    public final AdressRepository adressRepository;

    @Override
    public AddressDTO save(AddressDTO addressDTO) {
        log.debug("request to save : {}", addressDTO);
        Address address = AddressMapper.toEntity(addressDTO);  // Convertir DTO en entité
        address = adressRepository.save(address);  // Sauvegarder l'entité
        return AddressMapper.toDto(address);  // Convertir l'entité sauvegardée en DTO
    }


    @Override
    public Optional<AddressDTO> findOne(Long id) {
        return adressRepository.findById(id)                // Cherche l'entité Address par son ID
                .map(address -> {                         // Si l'entité est trouvée, convertit l'entité en DTO
                    return AddressMapper.toDto(address);  // Utilise le mapper pour convertir l'entité en DTO
                });
    }


    @Override
    public AddressDTO update(AddressDTO addressDTO) {
        // Cherche l'entité Address dans la base de données en utilisant l'ID fourni dans le DTO
        return findOne(addressDTO.getId()) // Appelle la méthode findOne pour obtenir l'entité existante
                .map(existingAddress -> {   // Si l'entité est trouvée, le code dans le bloc map est exécuté
                    // Met à jour les propriétés de l'entité avec les valeurs du DTO
                    existingAddress.setCompagny(addressDTO.getCompagny());  // Met à jour le champ "Compagny" de l'entité
                    existingAddress.setCity(addressDTO.getCity());          // Met à jour le champ "City" de l'entité
                    existingAddress.setStreet(addressDTO.getStreet());      // Met à jour le champ "Street" de l'entité

                    // Sauvegarde l'entité mise à jour dans la base de données
                    return save(existingAddress);  // Appelle la méthode save pour persister les changements
                })
                .orElseThrow(() -> new IllegalArgumentException("Address not found with id: " + addressDTO.getId()));  // Lève une exception si l'entité n'est pas trouvée
    }



    @Override
    public List<AddressDTO> findAll() {
        return adressRepository.findAll().stream()         // Récupère toutes les entités Address de la base de données
                .map(address -> {                        // Transforme chaque entité Address en AddressDTO
                    return AddressMapper.toDto(address); // Utilise le mapper pour convertir l'entité en DTO
                })
                .toList();                               // Collecte les résultats dans une liste et la retourne
    }


    @Override
    public void delete(Long id) {

    }
}
