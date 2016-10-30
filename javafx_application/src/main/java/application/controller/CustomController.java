package application.controller;

import application.view.ViewLoader;

public interface CustomController {
    void setViewLoader(ViewLoader viewLoader);
    void showView();
}
