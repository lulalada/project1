package lab1;

import java.io.Serializable;
import java.util.ArrayList;

public class DataBox implements Serializable {
    private String boxType;
    private MovieBox movieBox;
    private RegularMovie movie;
    private VIPMovie vipMovie;
    private VipMovieBox vipMovieBox;
    private ViewerBox viewerBox;
    private Viewer viewer;
    private VipViewerBox vipViewerBox;
    private VIPviewer vipViewer;
    private String operation;
    private Long id;

    public DataBox(String boxType, MovieBox movieBox, VipMovieBox vipMovieBox, String operation, ViewerBox viewerBox, VipViewerBox vipViewerBox, Long id) {
        this.boxType = boxType;
        this.movieBox = movieBox;
        this.vipMovieBox = vipMovieBox;
        this.operation = operation;
        this.viewerBox = viewerBox;
        this.vipViewerBox = vipViewerBox;
        this.id = id;
    }

    public DataBox(String boxType, String operation) {
        this.boxType = boxType;
        this.operation = operation;
    }

    public DataBox(String boxType, Long id) {
        this.boxType = boxType;
        this.id = id;
    }

    public DataBox(String boxType, String operation, Long id) {
        this.boxType = boxType;
        this.operation = operation;
        this.id = id;
    }

    public DataBox(String boxType, String operation, RegularMovie movie) {
        this.boxType = boxType;
        this.movie = movie;
        this.operation = operation;
    }

    public DataBox(String boxType, String operation, RegularMovie movie, Long id) {
        this.boxType = boxType;
        this.movie = movie;
        this.operation = operation;
        this.id = id;
    }

    public DataBox(String boxType, String operation, VIPMovie vipMovie, Long id) {
        this.boxType = boxType;
        this.vipMovie = vipMovie;
        this.operation = operation;
        this.id = id;
    }

    public DataBox(String boxType, String operation, Viewer viewer, Long id) {
        this.boxType = boxType;
        this.viewer = viewer;
        this.operation = operation;
        this.id = id;
    }

    public DataBox(String boxType, String operation, VIPviewer vipViewer, Long id) {
        this.boxType = boxType;
        this.vipViewer = vipViewer;
        this.operation = operation;
        this.id = id;
    }

    public DataBox(String boxType, String operation, ViewerBox viewerBox) {
        this.boxType = boxType;
        this.viewerBox = viewerBox;
        this.operation = operation;
    }

    public DataBox(String boxType, String operation, VIPMovie movie) {
        this.boxType = boxType;
        this.vipMovie = movie;
        this.operation = operation;
    }

    public DataBox(String boxType, String operation, VipViewerBox vipViewerBox) {
        this.boxType = boxType;
        this.vipViewerBox = vipViewerBox;
        this.operation = operation;
    }

    public DataBox(String boxType, String operation, Viewer viewer) {
        this.boxType = boxType;
        this.viewer = viewer;
        this.operation = operation;
    }

    public DataBox(String boxType, String operation, VIPviewer vipViewer) {
        this.boxType = boxType;
        this.vipViewer = vipViewer;
        this.operation = operation;
    }

    public RegularMovie getMovie() {
        return movie;
    }

    public void setMovie(RegularMovie movie) {
        this.movie = movie;
    }

    public VIPMovie getVipMovie() {
        return vipMovie;
    }

    public void setVipMovie(VIPMovie vipMovie) {
        this.vipMovie = vipMovie;
    }

    public String getBoxType() {
        return boxType;
    }

    public void setBoxType(String boxType) {
        this.boxType = boxType;
    }

    public MovieBox getMovieBox() {
        return movieBox;
    }

    public void setMovieBox(MovieBox movieBox) {
        this.movieBox = movieBox;
    }

    public VipMovieBox getVipMovieBox() {
        return vipMovieBox;
    }

    public void setVipMovieBox(VipMovieBox vipMovieBox) {
        this.vipMovieBox = vipMovieBox;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public ViewerBox getViewerBox() {
        return viewerBox;
    }

    public void setViewerBox(ViewerBox viewerBox) {
        this.viewerBox = viewerBox;
    }

    public VipViewerBox getVipViewerBox() {
        return vipViewerBox;
    }

    public void setVipViewerBox(VipViewerBox vipViewerBox) {
        this.vipViewerBox = vipViewerBox;
    }

    public Viewer getViewer() {
        return viewer;
    }

    public VIPviewer getVipViewer() {
        return vipViewer;
    }

    public void setViewer(Viewer viewer) {
        this.viewer = viewer;
    }

    public void setVipViewer(VIPviewer vipViewer) {
        this.vipViewer = vipViewer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
