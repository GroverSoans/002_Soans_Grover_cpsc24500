package Flooring;

public class Flooring 
{
    public static void main(String[] args)
    {
        double areaOfLaminateIn = 144;
        double priceOfPack = 24.99;
        double totalAreaFt = 275;

        double totalAreaIn = totalAreaFt * 12;

        double amountOfBoards = totalAreaIn/areaOfLaminateIn*1.25;
        double packsOfFlooring = Math.ceil(amountOfBoards/8);
        double costOfFlooring = packsOfFlooring * priceOfPack;
        
        System.out.printf("Packs of Flooring needed:%.0f, Total Cost of Flooring:$%.2f", packsOfFlooring, costOfFlooring);
    }
    
}
