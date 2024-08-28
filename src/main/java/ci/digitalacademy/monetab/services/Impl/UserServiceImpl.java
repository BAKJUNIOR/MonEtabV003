package ci.digitalacademy.monetab.services.Impl;

import ci.digitalacademy.monetab.models.User;
import ci.digitalacademy.monetab.repositories.UserRepository;
import ci.digitalacademy.monetab.services.UserService;
import jakarta.persistence.EntityNotFoundException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

 private final UserRepository userRepository;

 // Permet de fait la journalisation du code (ou utilise la 2eme methode avec annotation lombook)
 //private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        log.debug("Request to update {}", user);
        /* return findOne(user.getId())// fonction lambda permettant de modifier l''utilisateur
                .map(existngUser -> {//
                    existngUser.setPassword(user.getPassword());
                    existngUser.setPseudo(user.getPseudo());
                    return existngUser;
                }).map(existingUser -> {//Fonction lambda permettant d'enregistrer l'utilisateur dans la première map
                    return save(existingUser);
                }).orElseThrow(() -> new IllegalArgumentException();//Lever une exception existance de l'utilisateur
                */
        Optional<User> optionalUser = findOne(user.getId());// recuperation d'un optional<user>
        if (optionalUser.isPresent()) { // Vérification de l'existance d'un contenu par le optional
            User userToUpdate = optionalUser.get();//Déclaration + affectation d'un user à partir du optional
            userToUpdate.setPassword(user.getPassword());//mise à jour du mot de passe
            userToUpdate.setPseudo(user.getPseudo());//mise à jour du pseudo
            return save(userToUpdate);//Enregistrément de l'utilisateur modifié
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Optional<User> findOne(Long id) {
     log.debug("Request to find on user {}" , id);
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAll() {
        log.debug("Request to find on all user ");
        return userRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete  user {} " , id);
        userRepository.deleteById(id);
    }
}
