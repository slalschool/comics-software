import controller.ViewManager;
import view.CartView;
import view.InventoryView;
import view.OrderView;
import view.ProductView;

import java.awt.CardLayout;

import javax.swing.*;

@SuppressWarnings("serial")
public class MidtownComics extends JFrame {
    public static final int InventoryViewIndex = 0;
    public static final int ProductViewIndex = 1;
    public static final int CartViewIndex = 2;
    public static final int OrderViewIndex = 3;

    public static final String InventoryView = "view.InventoryView";
    public static final String ProductView = "view.ProductView";
    public static final String CartView = "view.CartView";
    public static final String OrderView = "view.OrderView";

    /**
     * Initializes the application views and frame.
     */

    public void init() {
        JPanel views = new JPanel(new CardLayout());
        ViewManager manager = ViewManager.getInstance(views);

        // add child views to the parent container

        views.add(new InventoryView(manager), InventoryView);
        views.add(new ProductView(manager), ProductView);
        views.add(new CartView(manager), CartView);
        views.add(new OrderView(manager), OrderView);

        // configure application frame

        this.getContentPane().add(views);
        this.setBounds(0, 0, 750, 750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }

    ////////// MAIN METHOD /////////////////////////////////////////////////////////

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MidtownComics().init();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}