package Validator;
import java.lang.reflect.Field;

public class validator {
    public static String validate (Object obj){
        String errors = "";

        Field [] fields = obj.getClass().getDeclaredFields();

        for(Field field : fields){
            field.setAccessible(true);

            try{
                Object value = field.get(obj);

                if(field.isAnnotationPresent(NotBlank.class)){
                    if(value == null || value.toString().trim().isBlank()){
                        errors = errors + field.getName() + " can't be blank \n";
                    }
                }

                if(field.isAnnotationPresent(MaxLenght.class)){
                    MaxLenght maxLength = field.getAnnotation(MaxLenght.class);
                    if(value != null && value.toString().length() > maxLength.value()){
                        errors += field.getName() + " is too long\n";
                    }
                }
            } catch(Exception e){
                System.out.println("ERROR : "+ e.getMessage());
            }
        }
        return errors;
    }    
}
