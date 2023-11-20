package com.aiml03.project.model.bean;

public class Timestamp {
    private int tID;
    private String faceTimestamp;
    private String plateTimestamp;

    public Timestamp(int tID, String faceTimestamp, String plateTimestamp) {
        this.tID = tID;
        this.faceTimestamp = faceTimestamp;
        this.plateTimestamp = plateTimestamp;
    }

    public int gettID() {
        return tID;
    }

    public void settID(int tID) {
        this.tID = tID;
    }

    public String getFaceTimestamp() {
        return faceTimestamp;
    }

    public void setFaceTimestamp(String faceTimestamp) {
        this.faceTimestamp = faceTimestamp;
    }

    public String getPlateTimestamp() {
        return plateTimestamp;
    }

    public void setPlateTimestamp(String plateTimestamp) {
        this.plateTimestamp = plateTimestamp;
    }
    
    public Timestamp() {
        
    }
}

