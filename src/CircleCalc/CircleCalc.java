package CircleCalc;
import java.util.Random;
public class CircleCalc {
    public static void main(String[] args)
    {
        Random random = new Random();
        int randomRadius = random.nextInt(25);

        double area = Math.PI * Math.pow((double)randomRadius, 2);
        double circumference = 2 * Math.PI * randomRadius;

        System.out.printf("Area = %.2f, Circumferernce = %.2f, Random Radius = %d\n", area, circumference, randomRadius);
    } 
}

