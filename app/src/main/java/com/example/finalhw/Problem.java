package com.example.finalhw;

public class Problem {
    private String description;
    private String type;
    private String prbm_id;
    private String usr_id;
    private String date;

    private boolean status;

    public Problem() {
        //for firebase
    }

    /**
     *
     * @param description
     * @param type
     * @param prbm_id
     * @param usr_id
     * @param date
     * @param status
     */
    public Problem(String description, String type, String prbm_id, String usr_id, String date, boolean status) {
        this.description = description;
        this.type = type;
        this.prbm_id = prbm_id;
        this.usr_id = usr_id;
        this.date = date;
        this.status = status;
    }

    public Problem(String description, String type, String prbm_id, String date, boolean status) {
        this.description = description;
        this.type = type;
        this.prbm_id = prbm_id;
        this.date = date;
        this.status = status;
    }


    public String getDescription() {
        return description;
    }

    public String getPrbm_id() {
        return prbm_id;
    }

    public void setPrbm_id(String prbm_id) {
        this.prbm_id = prbm_id;
    }

    public String getUsr_id() {
        return usr_id;
    }

    public void setUsr_id(String usr_id) {
        this.usr_id = usr_id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
