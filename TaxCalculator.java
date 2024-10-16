public class TaxCalculator {
    Calculator chooseCalc (String str) throws Exception {
        Calculator calc;
        switch (str)
        {
            case ("Физ") -> calc = new FizCalculator();
            case("Ип") -> calc = new IpCalculator();
            case("Сам") -> calc = new SamCalculator();
            default -> throw new Exception("invalid qalifier");
        }
        return calc;
    }
    public double calculateTax(String str, double num) throws Exception
    {
        return this.chooseCalc(str).calculateTax(num);
    }
}
