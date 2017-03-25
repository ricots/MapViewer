package io.github.hugoamvieira.intermediateeval;

import android.widget.ImageView;

import java.io.Serializable;

class GeolocationElement implements Serializable {

    private String placeName;
    private int imageRef;
    private double[] geoCoords;


    GeolocationElement(String _placeName, int _imageRef, double[] _geoCoords) {
        this.placeName = _placeName;
        this.imageRef = _imageRef;
        this.geoCoords = _geoCoords;
    }


    // Getters and Setters
    String getPlaceName() {
        return this.placeName;
    }

    int getImageRef() {
        return this.imageRef;
    }

    double[] getGeoCoords() {
        return this.geoCoords;
    }


    // toString Override for list elements
    @Override
    public String toString() {
        return placeName;
    }
}
