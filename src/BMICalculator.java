/**
 * @author 24penry
 * @version 11/16/22
 * BMI Calculator Program for AP Compsci that takes in a pounds and height and return a BMI
 */
import java.text.DecimalFormat;
import java.util.Scanner;


public class BMICalculator {
    /** Convert English to metric units, perform the BMI Calculation
     * NOTE: this method must properly handle bad data
     * @param inches user's height in inches
     * @param pounds user's weight in pounds
     * @return user's bmi weight(kg/heigh(m^2) a double
     */
    public static double computeBMI(int inches, int pounds) {  //.method indicated method is static
        double kgs, meters;
        if (inches <= 0 || pounds <= 0)
            return 0.;
        meters = inches * 0.0254;
        kgs = pounds * 0.454;
        return kgs / Math.pow(meters, 2);

    }

    public static void main(String[] args)  {
        Scanner in = new Scanner(System.in);
        String userin = new String();
        int inches, pounds;
        DecimalFormat df = new DecimalFormat("0.00");
        while(true)   {
            // sanitize height and convert to inches to 6'2
            try   {
                System.out.print("Enter your height in feet and inches (Ex 6'1\") or 0 to quit: ");
                userin = in.nextLine();
                if(userin.equals("0"))  {
                    break;   }
                //userin.indexOf("'");
                inches = Integer.parseInt(userin.substring(0, userin.indexOf("'")))*12;
                inches += Integer.parseInt(userin.substring(userin.indexOf("'")+1, userin.length()-1));
                //System.out.println("DEBUG: " + inches);
                System.out.print("Enter your weight in pounds: ");
                userin = in.nextLine();
                pounds = Integer.parseInt(userin);
                System.out.println("Your BMI, expressed as weight(kg)/height(m)^2: " + df.format(computeBMI(inches, pounds)) + " kg/m^2");
            }
            catch(Exception e)   {
                System.out.println("There was an error, see here: " + e.toString());
            }


        }
    }
}
