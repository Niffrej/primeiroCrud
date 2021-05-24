package br.com.demo.demo.services;

import br.com.demo.demo.entities.EmailEntity;
import br.com.demo.demo.models.Email;
import br.com.demo.demo.models.mapper.EmailMapper;
import br.com.demo.demo.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmailService {
    @Autowired
    private EmailRepository emailRepository;

    public Email create(Email email) {
        EmailEntity emailEntity = EmailMapper.marshall(email);
        EmailEntity persistenceEntity = emailRepository.save(emailEntity);
        return EmailMapper.unmarshall(persistenceEntity);
    }

    public Email update(Email email) {
        EmailEntity emailEntity = EmailMapper.marshall(email);
        EmailEntity ModifiedEntity = emailRepository.save(emailEntity);
        return EmailMapper.unmarshall(ModifiedEntity);
    }

    public void delete(Long idEmail) { emailRepository.deleteById(idEmail); }

    public Email findById(Long idEmail) {
        EmailEntity emailEntity= emailRepository.findById(idEmail).get();
        Email email = EmailMapper.unmarshall(emailEntity);
        return email;
    }

    public List<Email> findAll() { return new ArrayList<>(EmailMapper.unmarshall(emailRepository.findAll()));}
}
