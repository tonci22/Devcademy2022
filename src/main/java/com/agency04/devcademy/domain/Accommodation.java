package com.agency04.devcademy.domain;

import com.agency04.devcademy.dto.request.AccommodationCreateDto;
import com.agency04.devcademy.dto.request.AccommodationUpdateDto;
import com.agency04.devcademy.dto.request.ReservationCreateDto;
import com.agency04.devcademy.dto.request.ReservationUpdateDto;
import com.agency04.devcademy.enums.AccommodationType;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Accommodation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(max = 100)
    private String title;
    @Size(max = 200)
    private String subtitle;
    private String description;

    @Min(1)
    @Max(5)
    private Integer categorization;
    @Min(1)
    private Integer personCount;
    private String imageUrl;
    private boolean freeCancelation = true;
    private double price;
    private AccommodationType type;

    @OneToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @OneToMany
    @JoinColumn(name = "reservations_id")
    private List<Reservation> reservations = new ArrayList<>();

    public Accommodation() {
    }

    public Accommodation(String title, String subtitle, String description) {
        this.title = title;
        this.subtitle = subtitle;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCategorization() {
        return categorization;
    }

    public void setCategorization(Integer categorization) {
        this.categorization = categorization;
    }

    public Integer getPersonCount() {
        return personCount;
    }

    public void setPersonCount(Integer personCount) {
        this.personCount = personCount;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isFreeCancelation() {
        return freeCancelation;
    }

    public void setFreeCancelation(boolean freeCancelation) {
        this.freeCancelation = freeCancelation;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public AccommodationType getType() {
        return type;
    }

    public void setType(AccommodationType type) {
        this.type = type;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public void mapFrom(AccommodationUpdateDto accommodationUpdateDto) {

        this.setTitle(accommodationUpdateDto.getTitle());
        this.setSubtitle(accommodationUpdateDto.getSubtitle());
        this.setDescription(accommodationUpdateDto.getDescription());
        this.setCategorization(accommodationUpdateDto.getCategorization());
        this.setPersonCount(accommodationUpdateDto.getPersonCount());
        this.setImageUrl(accommodationUpdateDto.getImageUrl());
        this.setFreeCancelation(accommodationUpdateDto.isFreeCancelation());
        this.setPrice(accommodationUpdateDto.getPrice());
        this.setType(accommodationUpdateDto.getType());
        this.setLocation(mapDtoToLocation(accommodationUpdateDto));
        this.setReservations(mapDtoToReservationUpdate(accommodationUpdateDto.getReservation()));

    }

    public void mapFrom(AccommodationCreateDto accommodationCreateDto) {

        this.setTitle(accommodationCreateDto.getTitle());
        this.setSubtitle(accommodationCreateDto.getSubtitle());
        this.setDescription(accommodationCreateDto.getDescription());
        this.setCategorization(accommodationCreateDto.getCategorization());
        this.setPersonCount(accommodationCreateDto.getPersonCount());
        this.setImageUrl(accommodationCreateDto.getImageUrl());
        this.setFreeCancelation(accommodationCreateDto.isFreeCancelation());
        this.setPrice(accommodationCreateDto.getPrice());
        this.setType(accommodationCreateDto.getType());
        this.setLocation(mapDtoToLocation(accommodationCreateDto));
        this.setReservations(mapDtoToReservationCreate(accommodationCreateDto.getReservation()));
    }

    private Location mapDtoToLocation(AccommodationCreateDto accommodationCreateDto) {
        Location location = new Location();
        location.setId(accommodationCreateDto.getLocation().getId());
        location.setTitle(accommodationCreateDto.getLocation().getTitle());
        location.setSubtitle(accommodationCreateDto.getSubtitle());
        location.setPostalCode(accommodationCreateDto.getLocation().getPostalCode());
        return location;
    }
    private Location mapDtoToLocation(AccommodationUpdateDto accommodationUpdateDto) {
        Location location = new Location();
        location.setId(accommodationUpdateDto.getLocation().getId());
        location.setTitle(accommodationUpdateDto.getLocation().getTitle());
        location.setSubtitle(accommodationUpdateDto.getLocation().getSubtitle());
        location.setPostalCode(accommodationUpdateDto.getLocation().getPostalCode());
        return location;
    }

    private Reservation mapDtoToReservationCreate(ReservationCreateDto reservationCreateDto){
        Reservation reservation = new Reservation();

        reservation.setId(reservationCreateDto.getId());
        reservation.setAccommodation(reservationCreateDto.getAccommodation());
        reservation.setReservationType(reservationCreateDto.getReservationType());
        reservation.setSubmitted(reservationCreateDto.isSubmitted());
        reservation.setCheckOut(reservationCreateDto.getCheckOut());
        reservation.setCheckIn(reservationCreateDto.getCheckIn());
        reservation.setPersonCount(reservationCreateDto.getPersonCount());
        return reservation;
    }

    private Reservation mapDtoToReservationUpdate(ReservationUpdateDto reservationUpdateDto){
        Reservation reservation = new Reservation();

        reservation.setId(reservationUpdateDto.getId());
        reservation.setAccommodation(reservationUpdateDto.getAccommodation());
        reservation.setReservationType(reservationUpdateDto.getReservationType());
        reservation.setSubmitted(reservationUpdateDto.isSubmitted());
        reservation.setCheckOut(reservationUpdateDto.getCheckOut());
        reservation.setCheckIn(reservationUpdateDto.getCheckIn());
        reservation.setPersonCount(reservationUpdateDto.getPersonCount());
        return reservation;
    }

    private List<Reservation> mapDtoToReservationUpdate(List<ReservationUpdateDto> reservationUpdateDto){
        List<Reservation> reservation = new ArrayList<>();

        for(ReservationUpdateDto reservationUpdateDto1 : reservationUpdateDto){
            reservation.add(mapDtoToReservationUpdate(reservationUpdateDto1));
        }

        return reservation;
    }

    private List<Reservation> mapDtoToReservationCreate(List<ReservationCreateDto> reservationCreateDtos){
        List<Reservation> reservation = new ArrayList<>();

        for(ReservationCreateDto tempReservation : reservationCreateDtos){
            reservation.add(mapDtoToReservationCreate(tempReservation));
        }

        return reservation;
    }

    @Override
    public String toString() {
        return "Accommodation{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", description='" + description + '\'' +
                ", categorization=" + categorization +
                ", personCount=" + personCount +
                ", imageUrl='" + imageUrl + '\'' +
                ", freeCancelation=" + freeCancelation +
                ", price=" + price +
                ", type=" + type +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Accommodation that = (Accommodation) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
