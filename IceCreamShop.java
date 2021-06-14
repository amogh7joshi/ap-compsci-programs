import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;

/**
 * Represents an ice cream store, in which
 * the user can select an ice cream flavor,
 * up to three toppings, and a serving method.
 * They then need to enter delivery and payment
 * information and then the order will be saved
 * to a text file, where it can be `delivered`.
 *
 * Each day, there will be a randomly selected
 * `daily special` ice cream, which will be
 * selected between a set of ice cream flavors.
 */
public class IceCreamShop {
    /* The radio buttons, representing the singular
       ice cream flavor which the customer can select. */
    private JRadioButton vanillaButton;
    private JRadioButton chocolateButton;
    private JRadioButton strawberryButton;
    private JRadioButton cookieDoughButton;
    private JRadioButton pistachioButton;
    private JRadioButton mintChocolateChipButton;
    private JRadioButton coffeeButton;
    private JRadioButton neapolitanButton;
    private JRadioButton dailySpecialButton;
    private ButtonGroup flavorButtonGroup;


    /* The daily special flavors. */
    protected static String[] dailySpecials = new String[] {
        "Birthday Cake", "Butter Pecan",
        "Rocky Road", "Midnight Jersey Shore"
    };
    private String todaySpecial;

    /* The checkboxes for toppings. */
    private JCheckBox fudgeButton;
    private JCheckBox caramelButton;
    private JCheckBox gummyBearButton;
    private JCheckBox sprinklesButton;
    private JCheckBox whippedCreamButton;
    private JCheckBox crushedOreoButton;
    private JCheckBox chocolateChipButton;

    /* The radio buttons for serving method. */
    private JRadioButton cupButton;
    private JRadioButton sugarConeButton;
    private JRadioButton waffleConeButton;
    private ButtonGroup servingMethodButtonGroup;

    /* The text fields for delivery and payment info. */
    private JTextField nameText;
    private JTextField addressText;
    private JTextField cityStateZipText;
    private JTextField creditCardText;

    /* The main GUI components for the window. */
    private JFrame frame;
    private JPanel contentPane;

    /**
     * The main method to execute the application.
     */
    public static void main(String[] args) {
        IceCreamShop shop = new IceCreamShop();
        shop.start();
    }

    /**
     * Configure and start the application.
     */
    public void start() {
        // Configure the frame.
        frame = new JFrame("Ice Cream Shop");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Select the daily special.
        chooseDailySpecial();

        // Build and set up the content pane.
        contentPane = (JPanel)(frame.getContentPane());
        setUpMenuBar();
        setUpContentPane();

        // Make the frame usable.
        frame.setSize(600, 700);
        frame.setVisible(true);
    }

    /**
     * Chooses the daily special ice cream for the day.
     */
    private void chooseDailySpecial() {
        // Select a random number between 1 and
        // the number of daily special choices.
        int specialChoice = (int)(Math.random() * 4);

        // Return the corresponding flavor.
        todaySpecial = dailySpecials[specialChoice];
    }

    /**
     * Configures the content pane when the application
     * is launched, with the buttons, image, and text.
     */
    private void setUpContentPane() {
        // Configure the content pane from the current frame.
        contentPane.setLayout(new BorderLayout(6, 6));

        // Construct and display the image at the top of the screen.
        JLabel image = new JLabel(new ImageIcon("src/ice_cream.jpeg"), JLabel.CENTER);
        contentPane.add(image, BorderLayout.NORTH);

        // Configure each of the option selection panels.
        setUpFlavorSelectionPanel();
        setUpToppingSelectionPanel();
        setUpServingSelectionPanel();
        setUpDeliveryPaymentPanel();
    }

    /**
     * Configures the ice cream flavor selection panel.
     */
    private void setUpFlavorSelectionPanel() {
        // Create the menu for the different ice cream flavors.
        JPanel flavorPanel = new JPanel();
        flavorPanel.setLayout(new BoxLayout(flavorPanel, BoxLayout.Y_AXIS));
        flavorPanel.setBorder(BorderFactory.createTitledBorder("Choose a Flavor:"));

        // Create a button group for the different crusts.
        flavorButtonGroup = new ButtonGroup();

        // Add each of the different choices.
        vanillaButton = new JRadioButton("Vanilla", true);
        flavorButtonGroup.add(vanillaButton);
        flavorPanel.add(vanillaButton);
        chocolateButton = new JRadioButton("Chocolate", false);
        flavorButtonGroup.add(chocolateButton);
        flavorPanel.add(chocolateButton);
        strawberryButton = new JRadioButton("Strawberry", false);
        flavorButtonGroup.add(strawberryButton);
        flavorPanel.add(strawberryButton);
        cookieDoughButton = new JRadioButton("Cookie Dough", false);
        flavorButtonGroup.add(cookieDoughButton);
        flavorPanel.add(cookieDoughButton);
        pistachioButton = new JRadioButton("Pistachio", false);
        flavorButtonGroup.add(pistachioButton);
        flavorPanel.add(pistachioButton);
        mintChocolateChipButton = new JRadioButton("Mint Chocolate Chip", false);
        flavorButtonGroup.add(mintChocolateChipButton);
        flavorPanel.add(mintChocolateChipButton);
        coffeeButton = new JRadioButton("Coffee", false);
        flavorButtonGroup.add(coffeeButton);
        flavorPanel.add(coffeeButton);
        neapolitanButton = new JRadioButton("Neapolitan", false);
        flavorButtonGroup.add(neapolitanButton);
        flavorPanel.add(neapolitanButton);
        dailySpecialButton = new JRadioButton(todaySpecial, false);
        flavorButtonGroup.add(dailySpecialButton);
        flavorPanel.add(dailySpecialButton);

        // Add the panel to the left of the application.
        contentPane.add(flavorPanel, BorderLayout.WEST);
    }

    /**
     * Configures the topping selection panel.
     */
    private void setUpToppingSelectionPanel() {
        // Create the menu for the different ice cream flavors.
        JPanel toppingPanel = new JPanel();
        toppingPanel.setLayout(new BoxLayout(toppingPanel, BoxLayout.Y_AXIS));
        toppingPanel.setBorder(BorderFactory.createTitledBorder("Choose Up To Three Toppings:"));

        // Add each of the different choices.
        fudgeButton = new JCheckBox("Fudge", false);
        toppingPanel.add(fudgeButton);
        caramelButton = new JCheckBox("Caramel", false);
        toppingPanel.add(caramelButton);
        gummyBearButton = new JCheckBox("Gummy Bears", false);
        toppingPanel.add(gummyBearButton);
        sprinklesButton = new JCheckBox("Sprinkles", false);
        toppingPanel.add(sprinklesButton);
        whippedCreamButton = new JCheckBox("Whipped Cream", false);
        toppingPanel.add(whippedCreamButton);
        crushedOreoButton = new JCheckBox("Crushed Oreos", false);
        toppingPanel.add(crushedOreoButton);
        chocolateChipButton = new JCheckBox("Chocolate Chips", false);
        toppingPanel.add(chocolateChipButton);

        // Add the panel to the left of the application.
        contentPane.add(toppingPanel, BorderLayout.CENTER);
    }

    /**
     * Configures the serving selection panel.
     */
    private void setUpServingSelectionPanel() {
        // Create the menu for the different ice cream flavors.
        JPanel servingMethodPanel = new JPanel();
        servingMethodPanel.setLayout(new BoxLayout(servingMethodPanel, BoxLayout.Y_AXIS));
        servingMethodPanel.setBorder(BorderFactory.createTitledBorder("Choose a Serving Method:"));

        // Create a button group for the different crusts.
        servingMethodButtonGroup = new ButtonGroup();

        // Add each of the different choices.
        cupButton = new JRadioButton("Cup", true);
        servingMethodButtonGroup.add(cupButton);
        servingMethodPanel.add(cupButton);
        sugarConeButton = new JRadioButton("Sugar Cone", false);
        servingMethodButtonGroup.add(sugarConeButton);
        servingMethodPanel.add(sugarConeButton);
        waffleConeButton = new JRadioButton("Waffle Cone                   ", false);
        servingMethodButtonGroup.add(waffleConeButton);
        servingMethodPanel.add(waffleConeButton);

        // Add the panel to the left of the application.
        contentPane.add(servingMethodPanel, BorderLayout.EAST);
    }

    /**
     * Configures the delivery and payment information panel.
     */
    private void setUpDeliveryPaymentPanel() {
        // Construct the panel with the delivery and payment information.
        JPanel deliveryPaymentPanel = new JPanel();
        deliveryPaymentPanel.setLayout(new BoxLayout(deliveryPaymentPanel, BoxLayout.X_AXIS));
        deliveryPaymentPanel.setBorder(BorderFactory.createTitledBorder("Delivery and Payment Info:"));

        // Create the left panel, which will hold the text labels.
        JPanel textLabelPanel = new JPanel();
        textLabelPanel.setLayout(new BoxLayout(textLabelPanel, BoxLayout.Y_AXIS));
        textLabelPanel.add(new JLabel("Name:"));
        textLabelPanel.add(Box.createVerticalStrut(10));
        textLabelPanel.add(new JLabel("Address:"));
        textLabelPanel.add(Box.createVerticalStrut(10));
        textLabelPanel.add(new JLabel("City, State, Zip:"));
        textLabelPanel.add(Box.createVerticalStrut(10));
        textLabelPanel.add(new JLabel("Credit Card #:"));
        textLabelPanel.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        deliveryPaymentPanel.add(textLabelPanel);

        // Create the right panel, which will hold the information.
        JPanel informationPanel = new JPanel();
        informationPanel.setLayout(new BoxLayout(informationPanel, BoxLayout.Y_AXIS));
        nameText = new JTextField();
        addressText = new JTextField();
        cityStateZipText = new JTextField();
        creditCardText = new JTextField();
        informationPanel.add(nameText);
        informationPanel.add(addressText);
        informationPanel.add(cityStateZipText);
        informationPanel.add(creditCardText);
        informationPanel.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        deliveryPaymentPanel.add(informationPanel);

        // Add the panel to the main screen.
        contentPane.add(deliveryPaymentPanel, BorderLayout.SOUTH);
    }

    /**
     * Configures the menu bar at the top of the application.
     */
    private void setUpMenuBar() {
        // Create the menu bar.
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        // Construct the `File` menu and each of its different options.
        JMenu menu = new JMenu("File");
        menuBar.add(menu);
        JMenuItem menuItem = new JMenuItem("New Order");
        menuItem.addActionListener(new MenuListener());
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
        menu.add(menuItem);
        menuItem = new JMenuItem("Save Order");
        menuItem.addActionListener(new MenuListener());
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
        menu.add(menuItem);
        menu.addSeparator();
        menuItem = new JMenuItem("Exit");
        menuItem.addActionListener(new MenuListener());
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));
        menu.add(menuItem);

        // Construct the `Help` menu.
        menu = new JMenu("Help");
        menuBar.add(menu);
        menuItem = new JMenuItem("About Ice Cream Shop");
        menuItem.addActionListener(new MenuListener());
        menu.add(menuItem);
        menuItem = new JMenuItem("Instructions");
        menuItem.addActionListener(new MenuListener());
        menu.add(menuItem);
    }

    /**
     * The primary action listener for the menu bar, which
     * controls the actions of the different buttons.
     */
    private class MenuListener implements ActionListener {
        /* A convenience list which stores all of the flavor buttons. */
        private ArrayList<JRadioButton> flavorButtons;

        /* A convenience list which stores all of the topping buttons. */
        private ArrayList<JCheckBox> toppingButtons;

        /* A convenience list which stores all of the serving method buttons. */
        private ArrayList<JRadioButton> servingMethodButtons;

        /* A convenience list which stores the delivery and payment information. */
        private ArrayList<JTextField> deliveryPaymentInformation;

        /**
         * Re-initializes the convenience lists.
         */
        private void reinitializeLists() {
            flavorButtons = new ArrayList<JRadioButton>(Arrays.asList(
                    vanillaButton, chocolateButton, strawberryButton,
                    cookieDoughButton, pistachioButton, mintChocolateChipButton,
                    coffeeButton, neapolitanButton, dailySpecialButton
            ));
            toppingButtons = new ArrayList<JCheckBox>(Arrays.asList(
                    fudgeButton, caramelButton, gummyBearButton,
                    sprinklesButton, whippedCreamButton,
                    crushedOreoButton, chocolateChipButton
            ));
            servingMethodButtons = new ArrayList<JRadioButton>(Arrays.asList(
                    cupButton, sugarConeButton, waffleConeButton
            ));

            deliveryPaymentInformation = new ArrayList<JTextField>(Arrays.asList(
                    nameText, addressText, cityStateZipText, creditCardText
            ));
        }

        /**
         * Controls the functionality of the different buttons
         * in the `File` menu, including creating a new order,
         * and saving the order.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("New Order")) {
                // Control what happens if a new order is received.
                clearOrder();
            } else if (e.getActionCommand().equals("Save Order")) {
                // Control what happens if an order needs to be saved.
                saveOrder();
            } else if (e.getActionCommand().equals("About Ice Cream Shop")) {
                // Display a menu describing the application.
                JOptionPane.showMessageDialog(frame,
                    "Ice Cream Shop\n\nVersion 1.0\n\n" +
                    "(c) Copyright Amogh Joshi\n\nAll Rights Reserved.",
                    "About Ice Cream Shop",
                    JOptionPane.INFORMATION_MESSAGE
                );
            } else if (e.getActionCommand().equals("Instructions")) {
                JOptionPane.showMessageDialog(frame,
                    "Select your ice cream flavor, toppings,\n" +
                            "and serving instructions (cup/waffle cone/sugar cone).\n\n" +
                            "Then, enter your delivery and payment information.\n\n" +
                            "You can save your order at any time.",
                    "Instructions",
                    JOptionPane.INFORMATION_MESSAGE
                );
            }
            else {
                // The exit button has been received, so quit the program.
                System.exit(0);
            }
        }

        /**
         * Validates an order, by checking that the correct number
         * of buttons is selected for each of the flavor/topping/serving
         * method options, and the credit card number is valid.
         */
        private boolean validateOrder() {
            // Initialize the convenience lists.
            reinitializeLists();

            // Check that exactly one flavor button is selected.
            int buttonsClicked = 0;
            for (JRadioButton button: flavorButtons) {
                if (button.isSelected())
                    buttonsClicked++;
            }
            if (buttonsClicked != 1) {
                JOptionPane.showMessageDialog(frame,
                        "You must select an ice cream flavor!",
                        "Flavor Error",
                        JOptionPane.ERROR_MESSAGE
                );
                return false;
            }

            // Check that three or less topping buttons are selected.
            buttonsClicked = 0;
            for (JCheckBox button: toppingButtons) {
                if (button.isSelected()) {
                    buttonsClicked++;
                }
            }
            if (buttonsClicked > 3) {
                JOptionPane.showMessageDialog(frame,
                        "You can only select up to three toppings!",
                        "Maximum Toppings Exceeded",
                        JOptionPane.ERROR_MESSAGE
                );
                return false;
            }

            // Check that exactly one topping button is selected.
            buttonsClicked = 0;
            for (JRadioButton button: servingMethodButtons) {
                if (button.isSelected()) {
                    buttonsClicked++;
                }
            }
            if (buttonsClicked != 1) {
                JOptionPane.showMessageDialog(frame,
                        "You must select an ice cream flavor!",
                        "Serving Method Error",
                        JOptionPane.ERROR_MESSAGE
                );
                return false;
            }

            // Check that the delivery/payment information has been provided.
            for (JTextField field: deliveryPaymentInformation) {
                if (field.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame,
                            "Missing information in one or more delivery/payment fields.",
                            "Delivery/Payment Information Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                    return false;
                }
            }

            // Check that the credit card number is 16 digits.
            if (creditCardText.getText().length() != 16) {
                JOptionPane.showMessageDialog(frame,
                        "Expected a 16-digit credit card number.",
                        "Payment Information Error",
                        JOptionPane.ERROR_MESSAGE
                );
                return false;
            }

            // No errors encountered.
            return true;
        }

        /**
         * Clears the order and creates a new one.
         */
        private void clearOrder() {
            // Initialize the convenience lists.
            reinitializeLists();

            // Clear each of the flavor buttons.
            vanillaButton.setSelected(false);
            chocolateButton.setSelected(false);
            strawberryButton.setSelected(false);
            cookieDoughButton.setSelected(false);
            pistachioButton.setSelected(false);
            mintChocolateChipButton.setSelected(false);
            coffeeButton.setSelected(false);
            neapolitanButton.setSelected(false);
            dailySpecialButton.setSelected(false);

            // Clear each of the topping buttons.
            fudgeButton.setSelected(false);
            caramelButton.setSelected(false);
            gummyBearButton.setSelected(false);
            sprinklesButton.setSelected(false);
            whippedCreamButton.setSelected(false);
            crushedOreoButton.setSelected(false);
            chocolateChipButton.setSelected(false);

            // Clear each of the serving method buttons.
            cupButton.setSelected(false);
            sugarConeButton.setSelected(false);
            waffleConeButton.setSelected(false);

            // Clear the delivery/payment fields.
            nameText.setText("");
            addressText.setText("");
            cityStateZipText.setText("");
            creditCardText.setText("");
        }

        /**
         * Controls the specific functionality of the `save order` option.
         */
        private void saveOrder() {
            // Validate the order.
            if (!validateOrder()) {
                return;
            }

            // Create the header of the order.
            String order = "Ice Cream Order:\n================\n";

            // Add the ice cream flavor to the order.
            for (JRadioButton button: flavorButtons) {
                if (button.isSelected()) {
                    order += "Flavor: " + button.getActionCommand().strip() + "\n";
                    break;
                }
            }

            // Add the toppings to the order.
            order += "Topping: ";
            ArrayList<String> toppings  = new ArrayList<String>();
            for (JCheckBox box: toppingButtons) {
                if (box.isSelected()) {
                    toppings.add(box.getText().strip());
                }
            }
            for (int i = 0; i < toppings.size() - 1; i++) {
                order += toppings.get(i) + " | ";
            }
            order += toppings.get(toppings.size() - 1);
            order += "n";

            // Add the serving selection method to the order.
            for (JRadioButton button: servingMethodButtons) {
                if (button.isSelected()) {
                    order += "Serving Method: " + button.getActionCommand().strip() + "\n";
                    break;
                }
            }

            // Add the delivery and payment information to the order.
            order += "Name: " + nameText.getText().strip() + "\n";
            order += "Address: " + addressText.getText().strip() + "\n";
            order += "City/State/Zip: " + cityStateZipText.getText().strip() + "\n";
            order += "Credit Card #: " + creditCardText.getText().strip() + "\n";

            // Save the order to a file.
            try {
                PrintStream outFile = new PrintStream(nameText.getText().strip() + "_order.txt");
                outFile.print(order);
                outFile.close();
            } catch (IOException ioe) {
                System.out.println("\n*** IO EXCEPTION ***\n" + ioe);
            }

        }
    }
}
