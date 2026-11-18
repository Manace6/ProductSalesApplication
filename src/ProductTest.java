import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    @Test
    public void GetTotalProductSales_WithValidData_ReturnsCorrectValue() {
        Product product = new Product();
        int expected = 153;
        assertEquals(expected, product.GetTotalProductsSold());
    }

    @Test
    public void GetAverageSales_WithValidData_ReturnsCorrectValue() {
        Product product = new Product();
        double expected = 17.0;
        assertEquals(expected, product.GetAverageProductSold(), 0.01);
    }
}
