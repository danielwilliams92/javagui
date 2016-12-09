package assignment2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author Daniel
 * @date   November 24, 2016
 * @name   Assignment 2
 */
public class Assignment2 extends JFrame
{
    // Create Panels
    private JPanel greetPanel, hrPanel = new JPanel(),hrTop,hrBottom,buttonPanel;
    private JPanel inventoryPanel = new JPanel(),inventoryTop,inventoryBottom;
    private JPanel hrSearchPanel = new JPanel(),hrSearchTop;
    private JPanel productSearchPanel = new JPanel(),productSearchTop;
    private JPanel productCreatePanel = new JPanel(),productCreateTop, productCreateBottom;
    private JPanel manufactureSearchPanel = new JPanel(),manufactureSearchTop;
    private JPanel manufactureCreatePanel = new JPanel(),manufactureCreateTop;
    // Create Labels
    private JLabel lblGreeting;
    // Create TextFields
    private JTextField txtFirstName,txtLastName,txtAddress,txtPhoneNumber,txtSin,txtYear,txtMonth,
            txtDay,txtPayRate,txtSalary,txtCommissionRate,txtTotalSales,txtPosition,txtDepartment,
            txtHoursWorked,txtProductDescription,txtProductYear,txtProductSearch,txtProductName, txtProductPrice, 
            txtManufactureName, txtManufactureLocation, txtManufactureId, txtManufactureYears,
            txtManufactureSearch,txtSearch;
    //button
    private JButton btnExitButton,btnCreate, btnManufactureCreate, btnManufactureSearch, btnProductSearch, btnProductCreate, btnHrCreate, btnHrSearch;
    
    private JComboBox<String> employeeType;
    private static final String[] typeOfEmployees = {"Hourly","Salary","Commission"};

    public Assignment2()
    {
        super("Assignment 2 Inc.");
        setLayout(new BorderLayout());

        //Tab Panes
        JTabbedPane tabPane = new JTabbedPane();
        JTabbedPane hrTabPane = new JTabbedPane();
        JTabbedPane inventoryPane = new JTabbedPane();
        JTabbedPane productPane = new JTabbedPane();
        JTabbedPane manufacturePane = new JTabbedPane();

        //Call the Panel Methods
        buildGreetinsPanel("Assignment 2");
        buildButtonPanel();
        hrCreate();
        hrSearch();
        productCreate();
        productSearch();
        manufactureCreate();
        manufactureSearch();

        //Adding the sub-panels to the main panels
        
        // HR>Create>Employee panel
        hrPanel.setLayout(new BorderLayout());
        hrPanel.add(hrTop,BorderLayout.NORTH);
        hrPanel.add(hrBottom,BorderLayout.CENTER);
        // HR>Search>Employee panel
        hrSearchPanel.setLayout(new BorderLayout());
        hrSearchPanel.add(hrSearchTop,BorderLayout.NORTH);
    
        // Inventory>Product>Create panel
        productCreatePanel.setLayout(new BorderLayout());
        productCreatePanel.add(productCreateTop,BorderLayout.NORTH);
        
        // Inventory>Product>Search panel
        productSearchPanel.setLayout(new BorderLayout());
        productSearchPanel.add(productSearchTop,BorderLayout.NORTH);
        
        // Inventroy>Manufacture>Create panel
        manufactureCreatePanel.setLayout(new BorderLayout());
        manufactureCreatePanel.add(manufactureCreateTop,BorderLayout.NORTH);
        
        // Inventory>Manufacture>Search panel
        manufactureSearchPanel.setLayout(new BorderLayout());
        manufactureSearchPanel.add(manufactureSearchTop,BorderLayout.NORTH);
        
        // HR Tab - Inventory Tab
        tabPane.addTab("HR",null,hrTabPane,"HR");
        tabPane.addTab("Inventory",null,inventoryPane,"Inventory");
        
        // HR Tab > Create - Search Tab
        hrTabPane.addTab("Create",null,hrPanel,"HR");
        hrTabPane.addTab("Search",null,hrSearchPanel,"HR");
        
        // Inventory Tab > Product - Manufacture Tab
        inventoryPane.addTab("Product",null,productPane,"Inventory");
        inventoryPane.addTab("Manufacture",null,manufacturePane,"Inventory");
        
        // Inventory Tab > Product > Create - Search Tab
        productPane.addTab("Create",null,productCreatePanel,"Product");
        productPane.addTab("Search",null,productSearchPanel,"Product");

        // Inventory Tab > Manufacture > Create - Search Tab
        manufacturePane.addTab("Create",null,manufactureCreatePanel,"Product");
        manufacturePane.addTab("Search",null,manufactureSearchPanel,"Product");
      
        // JComboBox for type of employees
        employeeType = new JComboBox<String>(typeOfEmployees);
        employeeType.setMaximumRowCount(3);
        
        add(employeeType);
        add(greetPanel,BorderLayout.NORTH);
        add(tabPane,BorderLayout.CENTER);
        add(buttonPanel,BorderLayout.SOUTH);
    }
    
    
    private void buildGreetinsPanel(String labelMessage)
    {
        greetPanel = new JPanel();
        lblGreeting = new JLabel(labelMessage); 
        lblGreeting.setFont(new Font("Serif",Font.BOLD,28));
        greetPanel.add(lblGreeting);
        greetPanel.setBorder(BorderFactory.createRaisedBevelBorder());
    }

    private void manufactureSearch()
    {
        manufactureSearchTop = new JPanel();
        manufactureSearchTop.setLayout(new GridLayout(1,1));
        manufactureSearchTop.setBorder(BorderFactory.createTitledBorder("Search for Manufacture"));
        
        txtManufactureSearch = new JTextField(25);
        btnManufactureSearch = new JButton("Search");
        
        manufactureSearchTop.add(new JLabel("Name:"));
        manufactureSearchTop.add(txtManufactureSearch); 
        manufactureSearchTop.add(new JLabel(""));
        manufactureSearchTop.add(btnManufactureSearch);    
    }
    
    private void manufactureCreate()
    {
        manufactureCreateTop = new JPanel();
        manufactureCreateTop.setLayout(new GridLayout(6,2));
        manufactureCreateTop.setBorder(BorderFactory.createTitledBorder("Product Information"));

        txtManufactureName = new JTextField(15);
        txtManufactureId = new JTextField(15);
        txtManufactureYears = new JTextField(100);
        txtManufactureLocation = new JTextField(4);
        btnManufactureCreate = new JButton("Create");
        
        manufactureCreateTop.add(new JLabel("Name:"));
        manufactureCreateTop.add(txtManufactureName);
        manufactureCreateTop.add(new JLabel("ID:"));
        manufactureCreateTop.add(txtManufactureId);
        manufactureCreateTop.add(new JLabel("Location:"));
        manufactureCreateTop.add(txtManufactureLocation);
        manufactureCreateTop.add(new JLabel("Years in business:"));
        manufactureCreateTop.add(txtManufactureYears);
        manufactureCreateTop.add(new JLabel(""));
        manufactureCreateTop.add(btnManufactureCreate);
        
    }
    
    private void productSearch()
    {
        productSearchTop = new JPanel();
        productSearchTop.setLayout(new GridLayout(3,2));
        hrSearchTop.setBorder(BorderFactory.createTitledBorder("Enter name for product search"));
        
        btnProductSearch = new JButton("Search");
        txtProductSearch = new JTextField(15);
        
        productSearchTop.add(new JLabel("Enter product name:"));
        productSearchTop.add(txtProductSearch);
        productSearchTop.add(new JLabel(""));
        productSearchTop.add(btnProductSearch);
    }

    private void productCreate()
    {
        productCreateTop = new JPanel();
        productCreateTop.setLayout(new GridLayout(5,2));
        productCreateTop.setBorder(BorderFactory.createTitledBorder("Product Information"));
        
        txtProductName = new JTextField(15);
        txtProductPrice = new JTextField(15);
        txtProductDescription = new JTextField(100);
        txtProductYear = new JTextField(4);
        btnProductCreate = new JButton("Create");
        
        productCreateTop.add(new JLabel("Name:"));
        productCreateTop.add(txtProductName);
        productCreateTop.add(new JLabel("Price:"));
        productCreateTop.add(txtProductPrice);
        productCreateTop.add(new JLabel("Description:"));
        productCreateTop.add(txtProductDescription);
        productCreateTop.add(new JLabel("Year Made:"));
        productCreateTop.add(txtProductYear);
        productCreateTop.add(new JLabel(""));
        productCreateTop.add(btnProductCreate);       
        pack();
    }
    
    private void hrSearch()
    {
        hrSearchTop = new JPanel();
        hrSearchTop.setLayout(new GridLayout(2,1));
        hrSearchTop.setBorder(BorderFactory.createTitledBorder("Enter name for employee search:"));
        
        btnHrSearch = new JButton("Search");
        txtSearch = new JTextField(15);
        
        hrSearchTop.add(new JLabel("Enter First Name:"));
        hrSearchTop.add(txtSearch);
        hrSearchTop.add(new JLabel(""));
        hrSearchTop.add(btnHrSearch);
       
    }
    private void hrCreate()
    {
        // Create top JPanel, set grid layout + border
        hrTop = new JPanel();
        hrTop.setLayout(new GridLayout(11,11));
        hrTop.setBorder(
                BorderFactory.createTitledBorder("Employee Information"));
        
        // General Employee TextFields
        txtFirstName = new JTextField(15);
        txtLastName = new JTextField(15); 
        txtSin = new JTextField(9);
        txtAddress = new JTextField(30);
        txtPhoneNumber = new JTextField(10);
        txtDepartment = new JTextField(20);
        txtPosition = new JTextField(20);
        txtYear = new JTextField(4);
        txtMonth = new JTextField(2);
        txtDay = new JTextField(2);
        
        btnHrCreate = new JButton("Create");
        
        // Add Labels / TextFields to the *** TOP Panel ***
        hrTop.add(new JLabel("First Name:"));
        hrTop.add(txtFirstName);
        hrTop.add(new JLabel("Last Name:"));
        hrTop.add(txtLastName);
        hrTop.add(new JLabel("Sin:"));
        hrTop.add(txtSin);
        hrTop.add(new JLabel("Address:"));
        hrTop.add(txtAddress);
        hrTop.add(new JLabel("Phone #:"));
        hrTop.add(txtPhoneNumber);
        hrTop.add(new JLabel("Department:"));
        hrTop.add(txtDepartment);
        hrTop.add(new JLabel("Position"));
        hrTop.add(txtPosition);
        hrTop.add(new JLabel("Year:"));
        hrTop.add(txtYear);
        hrTop.add(new JLabel("Month:"));
        hrTop.add(txtMonth);
        hrTop.add(new JLabel("Day:"));
        hrTop.add(txtDay);
        
        // Create bottom JPanel, set grid layout + border
        hrBottom = new JPanel();
        hrBottom.setLayout(new GridLayout(4,2));
        hrBottom.setBorder(
                BorderFactory.createTitledBorder("Pay Information"));
       
        // Remuneration based on type of employee TextFields
        
        // Hourly Employee
        txtPayRate = new JTextField(20);
        // Salary Employee
        txtSalary = new JTextField(10);
        // Commission Employee
        txtCommissionRate =  new JTextField(6);
        txtTotalSales = new JTextField(10);
        
        // JComboBox for user selection of type of employee
        hrBottom.add(new JLabel("Type of Employee"));
        employeeType = new JComboBox<String>(typeOfEmployees);
        hrBottom.add(employeeType);
        
        // If Hourly Employee
        hrBottom.add(new JLabel("Hourly PayRate:"));
        hrBottom.add(txtPayRate);
        /*                                                    IF 
        // If Salary Employee
        hrBottom.add(new JLabel("Salary:"));
        hrBottom.add(txtSalary);
        // If Commission Employee
        hrBottom.add(new JLabel("Commission Rate:"));
        hrBottom.add(txtCommissionRate);
        */
        hrBottom.add(new JLabel(""));
        hrBottom.add(btnHrCreate);
    }

    // Exit Button
    private void buildButtonPanel()
    {
        //create the panel
        buttonPanel = new JPanel();
        btnExitButton = new JButton("Exit");
        btnExitButton.addActionListener(new ExitButtonHandler());
        buttonPanel.add(btnExitButton);
    }
    private class ExitButtonHandler implements ActionListener
    {
        @Override 
        public void actionPerformed(ActionEvent event)
        {
            // Exits the application
            if(JOptionPane.showConfirmDialog(null,
                    "Are you sure you want to Exit", 
                    "Exit", JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION)
            {
                System.exit(0);
            }  
        } 
    }
    
    public static void main(String[]args)
    {
        Assignment2 gui = new Assignment2();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.pack();
        gui.setVisible(true);
    }
}
