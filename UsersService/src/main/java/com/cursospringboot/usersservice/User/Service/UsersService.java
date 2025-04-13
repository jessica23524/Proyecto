package com.cursospringboot.usersservice.User.Service;

import com.cursospringboot.usersservice.User.Entity.UsersEntity;
import com.cursospringboot.usersservice.User.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;


import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

@Service
public class UsersService implements IUsersServices {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UsersEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UsersEntity getUserByMail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Optional<UsersEntity> getUserById(long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public UsersEntity createUser(UsersEntity user) {
        return userRepository.save(user);
    }

    public UsersEntity updateUser(Long id, Map<String, Object> camposActualizados) {
        UsersEntity user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Class<?> clazz = user.getClass();
        camposActualizados.forEach((key, value) -> {
            try {
                Field field = clazz.getDeclaredField(key);
                field.setAccessible(true);

                // Si es un enum, validar el valor
                if (field.getType().isEnum() && value instanceof String valorEnumStr) {
                    Object[] enumConstants = field.getType().getEnumConstants();
                    Object enumValue = Arrays.stream(enumConstants)
                            .filter(e -> ((Enum<?>) e).name().equalsIgnoreCase(valorEnumStr))
                            .findFirst()
                            .orElseThrow(() -> new IllegalArgumentException("Valor inválido para el enum " + field.getType().getSimpleName() + ": " + valorEnumStr));
                    field.set(user, enumValue);
                }
                // Si es LocalDateTime y llega como String
                else if (field.getType().equals(LocalDateTime.class) && value instanceof String fechaStr) {
                    LocalDateTime fecha = LocalDateTime.parse(fechaStr);
                    field.set(user, fecha);
                }
                // Otros tipos
                else if (value != null && field.getType().isAssignableFrom(value.getClass())) {
                    field.set(user, value);
                }
                // Caso especial para enteros/largos desde LinkedHashMap (llegan como Integer/Double)
                else if (value instanceof Number) {
                    Object castedValue = convertNumber((Number) value, field.getType());
                    if (castedValue != null) {
                        field.set(user, castedValue);
                    }
                }

            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException("Error actualizando el campo: " + key, e);
            }
        });

        return userRepository.save(user);
    }

    private Object convertNumber(Number value, Class<?> targetType) {
        if (targetType.equals(Integer.class) || targetType.equals(int.class)) {
            return value.intValue();
        } else if (targetType.equals(Long.class) || targetType.equals(long.class)) {
            return value.longValue();
        } else if (targetType.equals(Double.class) || targetType.equals(double.class)) {
            return value.doubleValue();
        } else if (targetType.equals(Float.class) || targetType.equals(float.class)) {
            return value.floatValue();
        }
        return null;
    }

}





