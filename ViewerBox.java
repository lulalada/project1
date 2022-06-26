package lab1;

import java.io.Serializable;
import java.util.ArrayList;

public class ViewerBox implements Serializable {
    private String operation;
    private Viewer viewer;
    private ArrayList<Viewer> viewers;

    public ViewerBox(String operation, Viewer viewer) {
        this.operation = operation;
        this.viewer = viewer;
    }

    public ViewerBox(String operation) {
        this.operation = operation;
    }

    public ViewerBox(Viewer viewer) {
        this.viewer = viewer;
    }

    public ViewerBox(ArrayList<Viewer> viewers) {
        this.viewers = viewers;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Viewer getViewer() {
        return viewer;
    }

    public void setViewer(Viewer viewer) {
        this.viewer = viewer;
    }

    public ArrayList<Viewer> getViewers() {
        return viewers;
    }

    public void setViewers(ArrayList<Viewer> viewers) {
        this.viewers = viewers;
    }
}
