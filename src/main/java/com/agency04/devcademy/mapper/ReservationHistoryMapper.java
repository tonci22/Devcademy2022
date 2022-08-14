package com.agency04.devcademy.mapper;

import com.agency04.devcademy.domain.Reservation;
import com.agency04.devcademy.domain.ReservationHistory;
import com.agency04.devcademy.dto.request.ReservationHistoryCreateDto;
import com.agency04.devcademy.dto.request.ReservationUpdateDto;
import com.agency04.devcademy.dto.response.ReservationHistoryDtoResponse;
import org.hibernate.annotations.CreationTimestamp;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ReservationHistoryMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "idReservation", source = "reservation.id")
    @Mapping(target = "fromType", source = "reservation.type")
    @Mapping(target = "toType", source = "reservationUpdateDto.type")
    @Mapping(target = "entryTimestamp", ignore = true)
    ReservationHistory mapToReservationHistory(Reservation reservation, ReservationUpdateDto reservationUpdateDto);

    @BeforeMapping
    default void timestampNow(ReservationHistory reservationHistory) {
        Timestamp timestamp = new Timestamp(new Date().getTime());
        reservationHistory.setEntryTimestamp(timestamp);
    }

    ReservationHistoryDtoResponse mapToDto(ReservationHistory reservationHistory);

    List<ReservationHistoryDtoResponse> mapToDto(List<ReservationHistory> reservationHistories);

    ReservationHistory mapToDto(ReservationHistoryCreateDto reservationHistoryCreateDto);
}
