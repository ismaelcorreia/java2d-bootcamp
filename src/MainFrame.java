import controllers.Canva;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

    public MainFrame()
    {
        super("Java2D BootCamp");
        initFrame();
    }

    private void initFrame(){
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);

        // add new Draw Component (Canvas) to Frame
        getContentPane().add(new Canva());
    }

    public static void main(String[] args) {
        new MainFrame().setVisible(true);
    }
}
