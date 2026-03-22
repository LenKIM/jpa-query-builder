package persistence.study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

class ReflectionTest {

    private static final Logger logger = LoggerFactory.getLogger(ReflectionTest.class);

    @Test
    @DisplayName("Car 객체 정보 가져오기")
    void showClass() throws NoSuchFieldException {
        Class<Car> carClass = Car.class;
        logger.debug(carClass.getName());
        String nameField = "Field: " + carClass.getDeclaredField("name");
        String price = "Field: " + carClass.getDeclaredField("price");
        System.out.println(nameField);
        System.out.println(price);

        System.out.println("Constructor: " + carClass.getConstructors()[0]);
        System.out.println("Constructor: " + carClass.getConstructors()[1]);

        Arrays.stream(carClass.getDeclaredMethods()).forEach(
                m -> System.out.println("Method: " + m.getName() + "->" + m.getReturnType().getName())
        );

        // 여기에 코드 작성
    }

    @Test
    @DisplayName("test 로 시작하는 메서드 실행")
    void testMethodRun() {
        Class<Car> carClass = Car.class;

        Arrays.stream(carClass.getDeclaredMethods())
                .filter(m -> m.getName().startsWith("test"))
                .forEach(m -> {
                    try {
                        System.out.println("methood: " + m.getName() + "-> " + "Result: " + m.invoke(new Car()));
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                });
    }

    @Test
    @DisplayName("@PrintView 애너테이션 메서드 실행")
    void testAnnotationMethodRun() throws InvocationTargetException, IllegalAccessException {
        Class<Car> carClass = Car.class;

        Arrays.stream(carClass.getDeclaredMethods())
                .filter(m -> m.isAnnotationPresent(PrintView.class))
                .findFirst()
                .get()
                .invoke(new Car());
    }

    @Test
    @DisplayName("private 필드에 값 할당")
    void privateFieldAccess() throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Class<Car> carClass = Car.class;
        Car car = carClass.getConstructor().newInstance();
        Field price = carClass.getDeclaredField("price");
        price.setAccessible(true);
        price.setInt(car, 10);

        int anInt = price.getInt(car);
        System.out.println(" anInt" + anInt);
    }

}
