package ua.baklanov.FirstSecutiryApp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.baklanov.FirstSecutiryApp.models.Person;
import ua.baklanov.FirstSecutiryApp.repositories.PeopleRepository;
import ua.baklanov.FirstSecutiryApp.security.PersonDetails;

import java.util.Optional;

@Service
public class PeopleDetailsService implements UserDetailsService {
    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleDetailsService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> person= peopleRepository.findByUsername(username);

        if (person.isEmpty()) {
            throw  new UsernameNotFoundException("User not found");
        }

        return new PersonDetails(person.get());
    }
}
