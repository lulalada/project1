package lab1;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ServerThread extends Thread{
    public static Socket socket;
    public static Socket socket1;
    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    public void run(){
        try{
            DBManager manager = new DBManager();
            manager.connect();
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            MovieBox movieBox = null;
            DataBox box = null;
            while((box = (DataBox) inputStream.readObject()) != null){
                if (box.getBoxType().equals("Regular movie")){
                    if (box.getOperation().equals("ADD")){
                        RegularMovie movieFromClient = box.getMovie();
                        manager.addRegularMovie(movieFromClient);
                    }else if (box.getOperation().equals("LIST")){
                        ArrayList<RegularMovie> infoForClient = manager.getRegularMovies();
                        MovieBox toClient = new MovieBox(infoForClient);
                        outputStream.writeObject(toClient);
                    }else if (box.getOperation().equals("DELETE")){
                        Long idFromClient = box.getId();
                        manager.deleteRegularMovie(idFromClient);
                    }else if (box.getOperation().equals("SELECT")){
                        Long idFromClient = box.getId();
                        RegularMovie infoForClient = manager.getRegularMovie(idFromClient);
                        MovieBox toClient = new MovieBox(infoForClient);
                        outputStream.writeObject(toClient);
                    } else if (box.getOperation().equals("UPDATE")){
                        RegularMovie movieFromClient = box.getMovie();
                        Long idFromClient = box.getId();
                        manager.updateRegularMovie(movieFromClient, idFromClient);
                    }
                }else if (box.getBoxType().equals("VIP movie")){
                    if (box.getOperation().equals("ADD")){
                        VIPMovie movieFromClient = box.getVipMovie();
                        manager.addVipMovie(movieFromClient);
                    }else if (box.getOperation().equals("LIST")){
                        ArrayList<VIPMovie> infoForClient = manager.getVipMovies();
                        VipMovieBox toClient = new VipMovieBox(infoForClient);
                        outputStream.writeObject(toClient);
                    }else if (box.getOperation().equals("DELETE")){
                        Long idFromClient = box.getId();
                        manager.deleteVipMovie(idFromClient);
                    }else if (box.getOperation().equals("SELECT")){
                        Long idFromClient = box.getId();
                        VIPMovie infoForClient = manager.getVipMovie(idFromClient);
                        VipMovieBox toClient = new VipMovieBox(infoForClient);
                        outputStream.writeObject(toClient);

                    } else if (box.getOperation().equals("UPDATE")){
                        VIPMovie movieFromClient = box.getVipMovie();
                        Long idFromClient = box.getId();
                        manager.updateVipMovie(movieFromClient, idFromClient);
                    }
                }else if (box.getBoxType().equals("Regular viewer")){
                    if (box.getOperation().equals("ADD")){
                        Viewer viewerFromClient = box.getViewer();
                        manager.addViewer(viewerFromClient);
                    }else if (box.getOperation().equals("LIST")){
                        ArrayList<Viewer> infoForClient = manager.getViewers();
                        ViewerBox toClient = new ViewerBox(infoForClient);
                        outputStream.writeObject(toClient);
                    }else if (box.getOperation().equals("DELETE")){
                        Long idFromClient = box.getId();
                        manager.deleteViewer(idFromClient);
                    }else if (box.getOperation().equals("UPDATE")){
                        Viewer viewerFromClient = box.getViewer();
                        Long idFromClient = box.getId();
                        manager.updateViewer(viewerFromClient, idFromClient);
                    }else if (box.getOperation().equals("UPDATE SETTINGS")){
                        Viewer viewerFromClient = box.getViewer();
                        Long idFromClient = box.getId();
                        manager.updateViewerSettings(viewerFromClient, idFromClient);
                    }
                }else if (box.getBoxType().equals("VIP viewer")){
                    if (box.getOperation().equals("ADD")){
                        VIPviewer movieFromClient = box.getVipViewer();
                        manager.addVipViewer(movieFromClient);
                    }else if (box.getOperation().equals("LIST")){
                        ArrayList<VIPviewer> infoForClient = manager.getVipViewers();
                        VipViewerBox toClient = new VipViewerBox(infoForClient);
                        outputStream.writeObject(toClient);
                    }else if (box.getOperation().equals("DELETE")){
                        Long idFromClient = box.getId();
                        manager.deleteVipViewer(idFromClient);
                    }else if (box.getOperation().equals("UPDATE")){
                        VIPviewer viewerFromClient = box.getVipViewer();
                        Long idFromClient = box.getId();
                        manager.updateVipViewer(viewerFromClient, idFromClient);
                    }
                }
            }
            /*while((movieBox = (MovieBox) inputStream.readObject()) != null){
                if (movieBox.getOperation().equals("ADD")){
                    RegularMovie movieFromClient = movieBox.getMovie();
                    manager.addRegularMovie(movieFromClient);
                }else if (movieBox.getOperation().equals("LIST")){
                    ArrayList<RegularMovie> infoForClient = manager.getRegularMovies();
                    MovieBox toClient = new MovieBox(infoForClient);
                    outputStream.writeObject(toClient);

                }
            }*/

            inputStream.close();
            outputStream.close();
            socket.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
