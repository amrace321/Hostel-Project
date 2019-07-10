package com.example.demo.modal;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookingInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int bookedBy;
    @OneToOne
    @JoinColumn(name = "hostel_id")
    private HostelInfoModel hostelInfoModel;
    private Date bookingDate;

    public BookingInformation(int bookedBy, HostelInfoModel hostelInfoModel, Date bookingDate) {
        this.bookedBy = bookedBy;
        this.hostelInfoModel = hostelInfoModel;
        this.bookingDate = bookingDate;
    }
}
