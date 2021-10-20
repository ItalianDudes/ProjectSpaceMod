package com.italiandudes.projectspace.util.supportInt;

public interface EnergyManagement {
    double volt=0.0;
    double ampere=0.0;
    double watt=0.0;

    double calculateWatt(double volt, double ampere);
}
