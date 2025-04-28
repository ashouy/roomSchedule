package com.jsoft.roomschedule.reservations;

public enum ReservationStatus {
    APPROVED( "Approved"),
    DENIED( "Denied"),
    PENDING( "Pending");
    private final String label;
    ReservationStatus(String label){
        this.label = label;
    }
    public String getLabel () {
        return this.label;
    }
}
