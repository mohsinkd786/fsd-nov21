package com.mohsinkd786.mapper;

import com.mohsinkd786.dto.UserDto;
import com.mohsinkd786.entity.User;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper extends ConfigurableMapper {
    @Override
    protected void configure(MapperFactory factory) {
        factory.registerClassMap(factory.classMap(User.class, UserDto.class)
                .fieldAToB("userId","id")
                .byDefault());
    }
}
