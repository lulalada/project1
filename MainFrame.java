package lab1;

import javax.swing.*;

public class MainFrame extends JFrame {
    public static  MainMenu mainMenu;
    public static Login login;
    public static Registration register;
    public static MovieList movieList;
    public static Search search;
    public static Filter filter;
    public static RegularFilter regularFilter;
    public static AdminMenu adminMenu;
    public static ViewerMenu viewerMenu;
    public static VIPmenu vipMenu;
    public static AddMovie addMovie;
    public static DeleteMovie deleteMovie;
    public static DeleteAccount deleteAccount;
    public static RegularMovieList regularMovieList;
    public static Rate rate;
    public static RegularSearch regularSearch;
    public static Watched watched;
    public static Subscription subscription;
    public static Settings settings;
    public static VipMovieList vipMovieList;
    public static VipSearch vipSearch;
    public static VipFilter vipFilter;
    public static VipWatched vipWatched;
    public static VipRate vipRate;
    public static VipSettings vipSettings;
    public static Recommendations recommendations;
    public static VipSubscription vipSubscription;
    public static UpdateMovie updateMovie;
    public MainFrame(){
        setSize(500, 500);
        setTitle("Movie Site");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setLayout();

        mainMenu = new MainMenu();
        mainMenu.setLocation(0, 0);
        add(mainMenu);

        login = new Login();
        login.setLocation(0, 0);
        login.setVisible(false);
        add(login);

        register = new Registration();
        register.setLocation(0, 0);
        register.setVisible(false);
        add(register);

        movieList = new MovieList();
        movieList.setLocation(0, 0);
        movieList.setVisible(false);
        add(movieList);

        search = new Search();
        search.setLocation(0, 0);
        search.setVisible(false);
        add(search);

        filter = new Filter();
        filter.setLocation(0, 0);
        filter.setVisible(false);
        add(filter);

        regularFilter = new RegularFilter();
        regularFilter.setLocation(0, 0);
        regularFilter.setVisible(false);
        add(regularFilter);

        adminMenu = new AdminMenu();
        adminMenu.setLocation(0, 0);
        adminMenu.setVisible(false);
        add(adminMenu);

        viewerMenu = new ViewerMenu();
        viewerMenu.setLocation(0, 0);
        viewerMenu.setVisible(false);
        add(viewerMenu);

        vipMenu = new VIPmenu();
        vipMenu.setLocation(0, 0);
        vipMenu.setVisible(false);
        add(vipMenu);

        addMovie = new AddMovie();
        addMovie.setLocation(0, 0);
        addMovie.setVisible(false);
        add(addMovie);

        deleteMovie = new DeleteMovie();
        deleteMovie.setLocation(0, 0);
        deleteMovie.setVisible(false);
        add(deleteMovie);

        deleteAccount = new DeleteAccount();
        deleteAccount.setLocation(0, 0);
        deleteAccount.setVisible(false);
        add(deleteAccount);

        regularMovieList = new RegularMovieList();
        regularMovieList.setLocation(0, 0);
        regularMovieList.setVisible(false);
        add(regularMovieList);

        rate = new Rate();
        rate.setLocation(0, 0);
        rate.setVisible(false);
        add(rate);

        regularSearch = new RegularSearch();
        regularSearch.setLocation(0, 0);
        regularSearch.setVisible(false);
        add(regularSearch);

        watched = new Watched();
        watched.setLocation(0, 0);
        watched.setVisible(false);
        add(watched);

        subscription = new Subscription();
        subscription.setLocation(0, 0);
        subscription.setVisible(false);
        add(subscription);

        settings = new Settings();
        settings.setLocation(0, 0);
        settings.setVisible(false);
        add(settings);

        vipMovieList = new VipMovieList();
        vipMovieList.setLocation(0, 0);
        vipMovieList.setVisible(false);
        add(vipMovieList);

        vipSearch = new VipSearch();
        vipSearch.setLocation(0, 0);
        vipSearch.setVisible(false);
        add(vipSearch);

        vipFilter = new VipFilter();
        vipFilter.setLocation(0, 0);
        vipFilter.setVisible(false);
        add(vipFilter);

        vipWatched = new VipWatched();
        vipWatched.setLocation(0, 0);
        vipWatched.setVisible(false);
        add(vipWatched);

        vipRate = new VipRate();
        vipRate.setLocation(0, 0);
        vipRate.setVisible(false);
        add(vipRate);

        vipSettings = new VipSettings();
        vipSettings.setLocation(0, 0);
        vipSettings.setVisible(false);
        add(vipSettings);

        recommendations = new Recommendations();
        recommendations.setLocation(0, 0);
        recommendations.setVisible(false);
        add(recommendations);

        vipSubscription = new VipSubscription();
        vipSubscription.setLocation(0, 0);
        vipSubscription.setVisible(false);
        add(vipSubscription);

        updateMovie = new UpdateMovie();
        updateMovie.setLocation(0, 0);
        updateMovie.setVisible(false);
        add(updateMovie);
    }
}
