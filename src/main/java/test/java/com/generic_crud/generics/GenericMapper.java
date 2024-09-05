package test.java.com.generic_crud.generics;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

@Component
public class GenericMapper <T extends GenericEntity, D extends Serializable, ID extends Serializable>{

    public <EN extends T, DTO extends D> D map(T source, Class<D> targetClass) {
        System.out.println(source.toString());
        try {
            D target = targetClass.getDeclaredConstructor().newInstance();

            // Obtener todos los campos de la clase, incluyendo los heredados
            Class<?> sourceClass = source.getClass();
            while (sourceClass != null) {
                Field[] sourceFields = sourceClass.getDeclaredFields();
                for (Field sourceField : sourceFields) {
                    sourceField.setAccessible(true);

                    try {
                        Field targetField = targetClass.getDeclaredField(sourceField.getName());
                        targetField.setAccessible(true);
                        Object value = sourceField.get(source);

                        // Verificar si el campo es de tipo List
                        if (List.class.isAssignableFrom(sourceField.getType())) {
                            // Si el campo es una lista, crear una nueva lista y mapear los elementos
                            ParameterizedType listType = (ParameterizedType) sourceField.getGenericType();
                            Class<?> listClass = (Class<?>) listType.getActualTypeArguments()[0];

                            List<Object> sourceList = (List<Object>) value;
                            List<Object> targetList = new ArrayList<>();

                            for (Object item : sourceList) {
                                // Mapear los elementos de la lista recursivamente si son objetos complejos
                                targetList.add(item);
                            }

                            // Asignar la lista mapeada al campo del target
                            targetField.set(target, targetList);
                        } else {
                            // Si no es una lista, mapear normalmente
                            targetField.set(target, value);
                        }
                    } catch (NoSuchFieldException e) {
                        // Si no se encuentra un campo con el mismo nombre en el targetClass, continuar
                        continue;
                    }
                }
                sourceClass = sourceClass.getSuperclass();  // Moverse a la clase padre
            }
            System.out.println(target.toString());
            return target;
        } catch (Exception e) {
            throw new RuntimeException("Error during mapping", e);
        }
    }
}
