package com.jsoft.roomschedule.reservations;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reservation_seq")
    @SequenceGenerator(name = "reservation_seq", sequenceName = "reservation_seq", allocationSize = 1)
    private Long id;

    private ReservationStatus status;
    private LocalDateTime reservationDate;
    private String roomDescription;
    private Long roomId;
    private String roomName;
    private Long amountOfTime;
    private LocalDateTime initialTime;
    private Long userId;
    private String userName;

    public Reservation() {
    }

    public Reservation(Long id, ReservationStatus status, LocalDateTime reservationDate, String roomDescription,
                       Long roomId, String roomName, Long amountOfTime, LocalDateTime initialTime, Long userId, String userName) {        this.id = id;
        this.status = status;
        this.reservationDate = reservationDate;
        this.roomDescription = roomDescription;
        this.roomId = roomId;
        this.roomName = roomName;
        this.amountOfTime = amountOfTime;
        this.initialTime = initialTime;
        this.userId = userId;
        this.userName = userName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }

    public LocalDateTime getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDateTime reservationDate) {
        this.reservationDate = reservationDate;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Long getAmountOfTime() {
        return amountOfTime;
    }

    public void setAmountOfTime(Long amountOfTime) {
        this.amountOfTime = amountOfTime;
    }

    public LocalDateTime getInitialTime() {
        return initialTime;
    }

    public void setInitialTime(LocalDateTime initialTime) {
        this.initialTime = initialTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
