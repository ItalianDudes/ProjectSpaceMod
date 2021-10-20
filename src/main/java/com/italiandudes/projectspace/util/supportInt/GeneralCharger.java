package com.italiandudes.projectspace.util.supportInt;

public interface GeneralCharger extends EnergyManagement{
    double chargeRate=0.0;

    //Inputs/Outputs (DEFAULT INIZIALIZATION)
    boolean primaryInput=false;         //Cable
    boolean secondaryInput=false;       //Item
    boolean primaryOutput=false;        //Item
    boolean secondaryOutput=false;      //Cable

    //Cables
    void inputCableManagement();        //Input (primary)
    void outputCableManagement();       //Output    (secondary)

    //Items
    void inputItemManagement();         //Input (secondary)
    void outputItemManagement();        //Output    (primary)
}