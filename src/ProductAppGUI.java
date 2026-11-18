import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.PrintWriter;

public class ProductAppGUI extends JFrame {
    private JTextField txtCustomerName;
    private JComboBox<String> cmbProduct;
    private JTextField txtPrice;

    public ProductAppGUI() {
        setTitle("Product App");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("File");
        JMenuItem itemExit = new JMenuItem("Exit");
        itemExit.addActionListener(e -> System.exit(0));
        menuFile.add(itemExit);

        JMenu menuTools = new JMenu("Tools");
        JMenuItem itemProcess = new JMenuItem("Process");
        JMenuItem itemClear = new JMenuItem("Clear");
        menuTools.add(itemProcess);
        menuTools.add(itemClear);

        menuBar.add(menuFile);
        menuBar.add(menuTools);
        setJMenuBar(menuBar);

        JLabel lblCustomer = new JLabel("Customer Name:");
        lblCustomer.setBounds(20, 30, 120, 25);
        add(lblCustomer);

        txtCustomerName = new JTextField();
        txtCustomerName.setBounds(150, 30, 200, 25);
        add(txtCustomerName);

        JLabel lblProduct = new JLabel("Select Product:");
        lblProduct.setBounds(20, 70, 120, 25);
        add(lblProduct);

        String[] products = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
        cmbProduct = new JComboBox<>(products);
        cmbProduct.setBounds(150, 70, 200, 25);
        add(cmbProduct);

        JLabel lblPrice = new JLabel("Enter Price:");
        lblPrice.setBounds(20, 110, 120, 25);
        add(lblPrice);

        txtPrice = new JTextField();
        txtPrice.setBounds(150, 110, 200, 25);
        add(txtPrice);

        JButton btnProcess = new JButton("PROCESS");
        btnProcess.setBounds(150, 160, 200, 30);
        add(btnProcess);

        btnProcess.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processSale();
            }
        });

        itemProcess.addActionListener(e -> processSale());
        itemClear.addActionListener(e -> clearFields());
    }

    private void processSale() {
        try {
            String customer = txtCustomerName.getText();
            String product = (String) cmbProduct.getSelectedItem();
            double price = Double.parseDouble(txtPrice.getText());

            ProductCalculations calc = new ProductCalculations(price);
            double vat = calc.GetVat();
            double commission = calc.GetCommission();
            double total = calc.GetTotal();

            String message = "Customer Name: " + customer + "\n" +
                    "Product: " + product + "\n" +
                    "VAT: R " + vat + "\n" +
                    "COMMISSION: R " + commission + "\n" +
                    "TOTAL: R " + total;

            JOptionPane.showMessageDialog(this, message, "Message", JOptionPane.INFORMATION_MESSAGE);

            PrintWriter writer = new PrintWriter(new FileWriter("data.txt", true));
            writer.println("DATA LOG");
            writer.println("**************************************************");
            writer.println("Customer Name: " + customer);
            writer.println("Product: " + product);
            writer.println("VAT: R " + vat);
            writer.println("COMMISSION: R " + commission);
            writer.println("TOTAL: R " + total);
            writer.println("**************************************************");
            writer.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid price.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        txtCustomerName.setText("");
        cmbProduct.setSelectedIndex(0);
        txtPrice.setText("");
    }

    public static void main(String[] args) {
        new ProductAppGUI().setVisible(true);
    }
}
