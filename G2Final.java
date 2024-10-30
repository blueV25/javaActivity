import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage; 
import java.io.*;
import java.util.*;
import javax.imageio.ImageIO; 
import javax.swing.*;
import javax.swing.table.*; 


public class G2Final extends JFrame {
    

    private JTextField tf1 = new JTextField("Vehicle Number"); 
    private JTextField tf2 = new JTextField("Vehicle Brand"); 
    private JTextField tf3 = new JTextField("Vehicle Model"); 
    private JTextField tf4 = new JTextField("Vehicle Type"); 
    private JTextField tf5 = new JTextField("Vehicle Rate"); 
    private JTextField tf6 = new JTextField("Vehicle Colour"); 

    private DefaultTableModel tableModel; // Model for table data
    private JTable table; // Table  vehicle data
    private VehicleManager VM = new VehicleManager(); // Vehicle manager to handle vehicle data

public G2Final() {
        setTitle("Vehicle Registration"); // Set the title of the frame
        setLayout(new BorderLayout()); 

//*****************************Top panel with image*********************************************************************

JPanel p1 = new JPanel(new FlowLayout()); // Create a panel with FlowLayout
        p1.setPreferredSize(new Dimension(150, 100)); 


    // add image to the panel
    try {
  //Background Image  sa taas   
        BufferedImage originalImage = ImageIO.read(new File("/C://Users//vigon//Pictures//Screenshots//Screenshot 2024-09-08 230005.png/")); 
            Image scaledImage = originalImage.getScaledInstance(650, 100, Image.SCALE_SMOOTH);
    
 //Balay ni MAYANG *****************************************************************************************
            BufferedImage secondImage = ImageIO.read(new File("C:\\Users\\Admin\\Desktop\\test\\home-page.png")); 
            Image secondscaledImage = secondImage.getScaledInstance(80, 80, Image.SCALE_SMOOTH);

            ImageIcon Houseicon =  new ImageIcon();
            Houseicon.setImage(secondscaledImage);

//PARA SA CAR******************************************************************
            BufferedImage thirdImage = ImageIO.read(new File("C:\\Users\\Admin\\Desktop\\test\\6.png")); 
            Image thirdcaledImage = thirdImage.getScaledInstance(150, 80, Image.SCALE_SMOOTH);

            ImageIcon carIcon =  new ImageIcon();
            carIcon.setImage(thirdcaledImage);

//********************************************************************************************* */

            JLabel label = new JLabel(new ImageIcon(scaledImage));
            
            label.setFont(new Font("Arial", Font.BOLD, 25));

            label.setText("Vehicle Registration");
            
            label.setForeground(Color.WHITE);
            

    // Set ang WARAFACT KING Text sa Center    
            label.setHorizontalTextPosition(JLabel.CENTER);
            label.setVerticalTextPosition(JLabel.CENTER);

//*************************Label sa Balay ni MAYANG ************************************************
            JLabel sublabel = new JLabel(new ImageIcon(secondscaledImage));
            sublabel.setBounds(20,5,100,100);            
//**********************************LABEL sa CAR*******************************************************************
            JLabel Carlabel = new JLabel(new ImageIcon(thirdcaledImage));
            Carlabel.setBounds(480,3,150,100);


            label.add(Carlabel);
            label.add(sublabel);
            p1.add(label); 




            
        } catch (IOException e) {
            e.printStackTrace();
        }

        add(p1, BorderLayout.PAGE_START); // Add the panel to the top of the frame


//******************************Center panel*********************************************************************

JPanel p2 = new JPanel(new BorderLayout()); // Create a panel with BorderLayout
        p2.setBackground(Color.WHITE);
        p2.setBounds(0,100 ,100 ,300 );
    add(p2, BorderLayout.CENTER); 

//*************************New button panel**********************************************************************

JPanel newButtonPanel = new JPanel(new BorderLayout()); 
        newButtonPanel.setBorder(BorderFactory.createEmptyBorder(10, 25, 15, 60));
        newButtonPanel.setBackground(Color.WHITE); 
        
//******************************NEW+ BUTTON********************************************************

JButton newButton = new JButton("NEW+"); 
        newButton.setBackground(Color.decode("#00eeff"));
        newButton.setForeground(Color.WHITE); 
        newButton.setFocusable(false);
        newButton.setPreferredSize(new Dimension(100,40));
        

        newButton.addActionListener(new ActionListener() {
    
        @Override
        public void actionPerformed(ActionEvent e) {
            tf1.setText("Vehicle Number");
            tf2.setText("Vehicle Brand");
            tf3.setText("Vehicle Model");
            tf4.setText("Vehicle Type");
            tf5.setText("Vehicle Rate");
            tf6.setText("Vehicle Colour");

            }
        });
        newButtonPanel.add(newButton, BorderLayout.LINE_END); 
        p2.add(newButtonPanel, BorderLayout.PAGE_START); 

 //***************************Text fields panel************************************************************

JPanel tfPanel = new JPanel(new GridLayout(3, 2, 40, 20)); 
            tfPanel.setBorder(BorderFactory.createEmptyBorder(15, 50, 30, 80)); 
            tfPanel.setBackground(Color.WHITE); 
            tfPanel.add(tf1); 
            tfPanel.add(tf2); 
            tfPanel.add(tf3); 
            tfPanel.add(tf4); 
            tfPanel.add(tf5); 
            tfPanel.add(tf6); 

            tfPanel.setBounds(0,10,100,10);

        p2.add(tfPanel, BorderLayout.CENTER); 
        setupTextFields(); // Set up text fields with custom borders
        

        // Add and Remove panel PARA SA WARAFACT KING button
 JPanel addRemovePanel = new JPanel(new FlowLayout()); // Create a panel with FlowLayout
        addRemovePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 15, 40));
        addRemovePanel.setBackground(Color.WHITE); 
        

        //addRemovePanel.setBounds(20,0,100,100);

// Create an add button with action listener
        JButton addButton = createButton("Add", "#51fcc9", new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            addVehicle(e);
        }
    }); 

 // Create a remove button with action listener
JButton removeButton = createButton("Remove", "#fc8a51", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                removeVehicle(e);
            }

        });

        addRemovePanel.add(addButton); 
        addRemovePanel.add(removeButton); 
        removeButton.setForeground(Color.GRAY);
        addButton.setForeground(Color.GRAY);


    addButton.setPreferredSize(new Dimension(80, 40));
    removeButton.setPreferredSize(new Dimension(100, 40));


      

        p2.add(addRemovePanel, BorderLayout.PAGE_END); 

        
//Frame setup*****************************************************************
        setupTable(); 
        setResizable(false);
        setSize(650, 680); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true); 
        setLocationRelativeTo(null);
    }

      private void setupTextFields() {
        // Loop through each text field to set a custom border
      for (JTextField tf : Arrays.asList(tf1, tf2, tf3, tf4, tf5, tf6)) {
            tf.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode("#00eeff"))); 
      
      
       tf.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (tf.getText().equals(tf.getName())) {
                        tf.setText("");
                  }
                }


                @Override
                public void focusLost(FocusEvent e) {
                    if (tf.getText().isEmpty()) {
                        tf.setText(tf.getName());
                    }
                }
            });
            tf.setName(tf.getText());

        } 
    }  


private JButton createButton(String text, String colorHex, ActionListener actionListener) {
        JButton button = new JButton(text); 

        button.setBackground(Color.decode(colorHex)); 
        button.setForeground(Color.WHITE); 
        button.setBorderPainted(false); // Remove the border painting of the button
        button.setFocusable(false); 
        button.addActionListener(actionListener); 

        return button; 
    }
//********************************************************************************************************* */
    private void setupTable() {
        // table columns and initial data
        String[] columns = {"Vehicle Number", "Type", "Brand", "Model", "Vehicle Rate", "Colour"};
        Object[][] data = {
            {"AB-1234", "Car", "Toyota", "CHR", 3000.0, "Red"},
            {"AB-1254", "Car", "Honda", "Civic", 2500.0, "Black"},
            {"AD-8523", "Car", "Suzuki", "VagonR", 3000.0, "White"},
            {"BC-4561", "Van", "Toyota", "SuperGL", 5000.0, "White"}
        };

        tableModel = new DefaultTableModel(data, columns); // Create a table model with data and columns
        
        table = new JTable(tableModel); // Create a table with the model
        table.setAutoCreateRowSorter(true); //  automatic row sorting

        
//***********************PANEL SA WARAFACT KING TABLE*****************************************

        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setPreferredSize(new Dimension(100, 160)); 
        tablePanel.setBackground(Color.LIGHT_GRAY); 
        tablePanel.add(new JScrollPane(table), BorderLayout.CENTER); 
        add(tablePanel, BorderLayout.SOUTH); 
        
//******************PINAKA BUTTOM PANEL******************************************************* */

    JPanel bPanel = new JPanel(); 

                bPanel.setBackground(Color.WHITE);
                bPanel.setPreferredSize(new Dimension(100,60));
               
                

              
            JLabel btextlabel = new JLabel(BorderLayout.CENTER);
                   btextlabel.setText("By: DORAEMON and FRIENDS");
                   btextlabel.setBounds(50,50,20,50);
                btextlabel.setBackground(Color.WHITE);
                btextlabel.setForeground(Color.GRAY);
                btextlabel.setFont(new Font("Arial", Font.PLAIN, 11));
      
           
tablePanel.add(bPanel, BorderLayout.SOUTH); 
                
       try {

             BufferedImage buttomPic = ImageIO.read(new File("/C:/Users//vigon//Pictures//Screenshots//Screenshot 2024-09-08 230005.png/")); 
             Image buttomscaledImage = buttomPic.getScaledInstance(50, 35, Image.SCALE_SMOOTH);

             ImageIcon Houseicon =  new ImageIcon();
             Houseicon.setImage(buttomscaledImage);


             JLabel bcarlabel = new JLabel();

            bcarlabel.setBounds(-80,-5,50,60);
             bcarlabel.setIcon(Houseicon);
             

             JLabel bcarlabel2 = new JLabel();
              bcarlabel2.setBounds(70,-5,20,60);
             bcarlabel2.setIcon(Houseicon);


             bPanel.add(bcarlabel,BorderLayout.CENTER);
             bPanel.add(btextlabel);
             bPanel.add(bcarlabel2,BorderLayout.CENTER);

          }  catch (IOException e ) {
             e.printStackTrace();

          }

    }

    private void addVehicle(ActionEvent event) {
        try {
             
        
                        String vehicleNumber = tf1.getText();
                        String name = tf2.getText();
                        String model = tf3.getText();
                        String type = tf4.getText();
                        double rate = Double.parseDouble(tf5.getText());
                        String colour = tf6.getText();

                        int maxVehicleNumberLength = 10;
                        int maxNameLength = 10; 
                        int maxModelLength = 10;
                        int maxTypeLength = 10; 
                        int maxColourLength = 10; 
            
            
            if (vehicleNumber.length() > maxVehicleNumberLength || 
                name.length() > maxNameLength || 
                model.length() > maxModelLength || 
                type.length() > maxTypeLength || 
                colour.length() > maxColourLength ) {
                 
                JOptionPane.showMessageDialog(this, "Input exceeds character limit.");
                return; 
            }



           String []color = {"GREEN","PINK","BLACK","GRAY","BLUE","RED","YELLOW","VIOLET","WHITE","ORANGE","GREEN"};
           String []typev = {"SUV","TRUCK","MOTORCYCLE","VAN","MINI-VAN","CAR"};
           String []BrandV = {"TOYOTA","HONDA","NISSAN","FORD","KIA","MITSUBISHI","SUZUKI"};
           String []CharV = {"@","#","$","^","%","&","*","(",")","_","=","!"};
        
            
        if (!Arrays.asList(color).contains(colour.toUpperCase()) || 
                !Arrays.asList(BrandV).contains(name.toUpperCase()) || 
                    !Arrays.asList(typev).contains(type.toUpperCase())
                       ) {

                        JOptionPane.showMessageDialog(this, "Please enter valid color, type, or model.");

            } else if (vehicleNumber.contains("@")||name.contains("@") || model.contains("@") || type.contains("@") || colour.contains("@") 
                 || vehicleNumber.contains("Vehicle Number") || name.contains("Vehicle Name ")|| model.contains("Vehicle Model")|| type.contains("Vehicle Type")|| colour.contains("Vehicle Colour") 
                 || colour.contains("1")|| colour.contains("2")|| colour.contains("3")|| colour.contains("4")|| colour.contains("5")|| colour.contains("6")|| colour.contains("7")|| colour.contains("8")
                 || colour.contains("9")|| colour.contains("0")) {
                   
                    JOptionPane.showMessageDialog(this, "Please Enter Valid Data");
            } else {
   
                // Create a new vehicle
                Vehicle vehicle = new Vehicle(vehicleNumber, type, name, model, rate, colour);
    
                if (VM.save(vehicle)) { // Save the vehicle using vehicle manager
                    
                    tableModel.addRow(new Object[]{vehicleNumber, type , name, model, rate, colour});
                    JOptionPane.showMessageDialog(this,"Saved Successfully");
                    
                } else {
                    JOptionPane.showMessageDialog(this, "Vehicle already exists.");
                } 
            }
        
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid rate. Please enter a number.");
        }
    
    }    

private void removeVehicle(ActionEvent event) {
    int selectedRow = table.getSelectedRow(); 
        if (selectedRow >= 0) {
            String vehicleNumber = (String) tableModel.getValueAt(selectedRow, 0); 

            

            VM.delete(vehicleNumber); 
            tableModel.removeRow(selectedRow); 
            JOptionPane.showMessageDialog(this, "Vehicle has been removed");
        } else {
            JOptionPane.showMessageDialog(this, "Please select a vehicle to remove."); 
        }
    }


public static void main(String[] args) {
        new G2Final(); 
    }
}

class Vehicle {
    private String vehicleNumber; 
    private String type; 
    private String name; 
    private String model; 
    private double vehicleRate;
    private String colour; 


    // Constructor to initialize vehicle details
public Vehicle(String vehicleNumber, String type , String name, String model, double vehicleRate, String colour) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.name = name;
        this.model = model;
        this.vehicleRate = vehicleRate;
        this.colour = colour;
    }

    // Getter methods for vehicle details
public String getVehicleNumber() {
        return vehicleNumber;
    }

public String getType() {
        return type;
    }    

public String getName() {
        return name;
    }

public String getModel() {
        return model;
    }

public double getVehicleRate() {
        return vehicleRate;
    }

public String getColour() {
        return colour;
    }
}

class VehicleManager {
    private Map<String, Vehicle> vehicleMap = new HashMap<>(); // HASHMAP PARA SA MGA WARAFACT

    // Method to save a vehicle
    public boolean save(Vehicle vehicle) {
        
        if (vehicleMap.containsKey(vehicle.getVehicleNumber())) {
            return false; // Return false if vehicle already exists
        }
        vehicleMap.put(vehicle.getVehicleNumber(), vehicle); // Add vehicle to the map. true if vehicle is saved successfully
        return true; 
    }

    // Method to delete a vehicle // Remove vehicle from the map and return true if successful
    public boolean delete(String vehicleNumber) {
        return vehicleMap.remove(vehicleNumber) != null; 
    }
}
