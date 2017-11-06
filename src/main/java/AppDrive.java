import java.util.function.BiFunction;

public class AppDrive {

    public static void main(String[] args) {

        BiFunction<String, String, String> biFunction = null;

        biFunction = AppDrive::printNam;
        System.out.println(biFunction.apply("Amir", "Khadiv"));
    }

    public static String printNam(String name, String family) {

        return name + family;
    }
}
