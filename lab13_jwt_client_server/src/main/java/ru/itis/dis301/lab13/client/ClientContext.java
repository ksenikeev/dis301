package ru.itis.dis301.lab13.client;

public class ClientContext {

    private MainFrame mainFrame;
    private LoginFrame loginFrame;
    private Connector connector;

    public ClientContext() {
        connector = new Connector(this);
        loginFrame = new LoginFrame(this);
        mainFrame = new MainFrame(this);

        mainFrame.show();
        loginFrame.show();
    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }

    public LoginFrame getLoginFrame() {
        return loginFrame;
    }

    public Connector getConnector() {
        return connector;
    }
}
