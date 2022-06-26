package lab1;

import java.io.Serializable;
import java.util.ArrayList;

public class VipViewerBox implements Serializable {
    private String operation;
    private VIPviewer vipViewer;
    private ArrayList<VIPviewer> vipViewers;

    public VipViewerBox(String operation, VIPviewer viewer) {
        this.operation = operation;
        this.vipViewer = viewer;
    }

    public VipViewerBox(String operation) {
        this.operation = operation;
    }

    public VipViewerBox(VIPviewer viewer) {
        this.vipViewer = viewer;
    }

    public VipViewerBox(ArrayList<VIPviewer> viewers) {
        this.vipViewers = viewers;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public VIPviewer getVipViewer() {
        return vipViewer;
    }

    public void setVipViewer(VIPviewer viewer) {
        this.vipViewer = viewer;
    }

    public ArrayList<VIPviewer> getVipViewers() {
        return vipViewers;
    }

    public void setVipViewers(ArrayList<VIPviewer> viewers) {
        this.vipViewers = viewers;
    }

}
