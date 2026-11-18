public class Product implements IProduct {
    private String[] productNames = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
    private int[][] monthlySales = {
            {25, 18, 20},
            {15, 10, 12},
            {18, 15, 20}
    };

    @Override
    public int GetTotalProductsSold() {
        int total = 0;
        for (int i = 0; i < monthlySales.length; i++) {
            for (int j = 0; j < monthlySales[i].length; j++) {
                total += monthlySales[i][j];
            }
        }
        return total;
    }

    @Override
    public double GetAverageProductSold() {
        int total = GetTotalProductsSold();
        int count = 0;
        for (int i = 0; i < monthlySales.length; i++) {
            count += monthlySales[i].length;
        }
        return (double) total / count;
    }

    @Override
    public String GetMostPopularProduct() {
        int maxSales = -1;
        int bestProductIndex = 0;
        for (int i = 0; i < monthlySales.length; i++) {
            int productTotal = 0;
            for (int j = 0; j < monthlySales[i].length; j++) {
                productTotal += monthlySales[i][j];
            }
            if (productTotal > maxSales) {
                maxSales = productTotal;
                bestProductIndex = i;
            }
        }
        return productNames[bestProductIndex] + " (" + maxSales + ")";
    }
}
