package main.java;// Java implementation of using
// unfolding maps

// Importing the libraries in eclipse
/*import processing.core.PApplet;
import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding
        .providers.AbstractMapProvider;
import de.fhpotsdam.unfolding
        .providers.Google;
import de.fhpotsdam.unfolding
        .providers.MBTilesMapProvider;
import de.fhpotsdam.unfolding
        .utils.MapUtils;

// Class to make the map
public class Mapa extends PApplet {

    // To keep eclipse from reporting
    // a warning
    private static final long
            serialVersionUID
            = 1L;

    // Initializing the height and
    // width of the map
    //private static int mapWidth = 350;
    //private static int mapHeight = 500;

    // This map is used to display Mumbai
    UnfoldingMap map1;


    // This map is used to display Delhi

    // Function which implements the unfolds
    // library
    public Mapa(float latitud,float longitud, int mapWidth, int mapHeight)
    {
        // Set the Applet window to be
        // 900x600 width and height.
        // The OPENGL argument indicates
        // to use the Processing
        // library's 2D drawing
        size(900, 600, P2D);

        // This sets the background colour
        // for the Applet. Here, colour
        // blue is choosen
        this.background(0, 0, 128);

        // Select a map provider.
        // Here we are using google provider
        AbstractMapProvider provider
                = new Google.GoogleTerrainProvider();

        // Set a zoom level to focus on
        // our specified location
        int zoomLevel = 10;

        // Creating the first map
        map1 = new UnfoldingMap(this, 40, 50, mapWidth, mapHeight, provider);

        // This line zooms in and centers
        // the map at 28.7041 (latitude)
        // and 77.1025° (longitude) for Mumbai.
        map1.zoomAndPanTo(
                zoomLevel,
                new Location(latitud, longitud));

        // This line makes the map interactive
        // as we can zoom in and out. And, here
        // we have zoomed our focus to the
        // Mumbai location by setting the
        // zoom level to 10.
        MapUtils
                .createDefaultEventDispatcher(
                        this, map1);


    }

    // Function to draw the applet window
    public void draw()
    {
        // The draw method is implemented
        // repeatedly by drawing our maps
        // again and again on the canvas
        map1.draw();
    }
}*/

import com.teamdev.jxmaps.*;
import com.teamdev.jxmaps.swing.MapView;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import javax.swing.*;

public class Mapa{//} extends JPanel{//} extends MapView {



    //public Mapa(){
       public static void main(String[] args) throws IOException {
            JFrame test = new JFrame();

            try {
                String imageUrl = "https://www.google.com/maps/place/Escuela+T%C3%A9cnica+Superior+de+Ingenier%C3%ADa+(ICAI)/@40.43004,-3.7149047,17z/data=!3m1!4b1!4m5!3m4!1s0xd4228662ebd8eeb:0xd7c09eaa5e0b0c59!8m2!3d40.43004!4d-3.712716";
                String destinationFile = "image.png";
                String str = destinationFile;
                URL url = new URL(imageUrl);
                InputStream is = url.openStream();
                OutputStream os = new FileOutputStream(destinationFile);

                byte[] b = new byte[2048];
                int length;

                while ((length = is.read(b)) != -1) {
                    os.write(b, 0, length);
                }

                is.close();
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(1);
            }

            test.add(new JLabel(new ImageIcon((new ImageIcon("image.png")).getImage().getScaledInstance(380, 310,
                    java.awt.Image.SCALE_SMOOTH))));

            test.setVisible(true);
            test.pack();

        }
    }

    //private float lat;
    // private float lon;

/*    public Mapa(float lat, float lon) {
         setOnMapReadyHandler (new MapReadyHandler() {
            @Override
            public void onMapReady(MapStatus status) {
                // Check if the map is loaded correctly
                if (status == MapStatus.MAP_STATUS_OK) {
                    // Getting the associated map object
                    final Map map = getMap();
                    // Creating a map options object
                    MapOptions options = new MapOptions();
                    // Creating a map type control options object
                    MapTypeControlOptions controlOptions = new MapTypeControlOptions();
                    // Changing position of the map type control
                    controlOptions.setPosition(ControlPosition.TOP_RIGHT);
                    // Setting map type control options
                    options.setMapTypeControlOptions(controlOptions);
                    // Setting map options
                    map.setOptions(options);
                    // Setting the map center
                    map.setCenter(new LatLng(lat, lon));
                    // Setting initial zoom value
                    map.setZoom(2.0);
                }
            }
        });
    }*/

