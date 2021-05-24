package br.com.demo.demo.models.mapper;

import br.com.demo.demo.validations.NullSafe;
import br.com.demo.demo.entities.EmailEntity;
import br.com.demo.demo.models.Email;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class EmailMapper {

    public static Collection<Email> unmarshall(Collection<EmailEntity> entities) {
        return NullSafe.of(entities).getOrDefault(Collections.emptyList()).stream().map(entity -> EmailMapper.unmarshall(entity))
                .collect(Collectors.toList());
    }

    public static Collection<EmailEntity> marshall(Collection<Email> models) {
        return NullSafe.of(models).getOrDefault(Collections.emptyList()).stream().map(EmailMapper::marshall)
                .collect(Collectors.toList());
    }

    public static Email unmarshall(EmailEntity entity){
        return Email.builder().build();
    }

    public static EmailEntity marshall(Email model){
        return EmailEntity.builder().build();
    }
}
