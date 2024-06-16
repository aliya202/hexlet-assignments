package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
public class Validator {
    public static List<String> validate(Object obj) {
        List<String> invalidFields = new ArrayList<>();

        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(NotNull.class)) {
                try {
                    field.setAccessible(true);
                    if (field.get(obj) == null) {
                        invalidFields.add(field.getName());
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        return invalidFields;
    }

    public static Map<String, List<String>> advancedValidate(Object obj) {
        Map<String, List<String>> validationErrors = new HashMap<>();

        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field : fields) {
            List<String> errors = new ArrayList<>();

            if (field.isAnnotationPresent(NotNull.class)) {
                try {
                    field.setAccessible(true);
                    if (field.get(obj) == null) {
                        errors.add("must not be null");
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

            if (field.isAnnotationPresent(MinLength.class)) {
                try {
                    field.setAccessible(true);
                    Object value = field.get(obj);
                    if (value instanceof String) {
                        MinLength minLengthAnnotation = field.getAnnotation(MinLength.class);
                        int minLength = minLengthAnnotation.minLength();
                        if (((String) value).length() < minLength) {
                            errors.add("length must be at least " + minLength);
                        }
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

            if (!errors.isEmpty()) {
                validationErrors.put(field.getName(), errors);
            }
        }

        return validationErrors;
    }
}
// END
