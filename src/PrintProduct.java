public class PrintProduct {
    public void printReport() {
        Product product = new Product();
        System.out.println("PRODUCT SALES REPORT - 2026");
        System.out.println("**************************************************");
        System.out.println("TOTAL PRODUCT SALES: " + product.GetTotalProductsSold());
        System.out.println("AVERAGE PRODUCT SALES: " + (int) product.GetAverageProductSold());
        System.out.println("MOST POPULAR PRODUCT: " + product.GetMostPopularProduct());
    }

    public static void main(String[] args) {
        PrintProduct printer = new PrintProduct();
        printer.printReport();
    }
}
