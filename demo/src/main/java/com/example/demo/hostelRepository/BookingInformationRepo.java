package com.example.demo.hostelRepository;

import com.example.demo.modal.BookingInformation;
import com.example.demo.modal.HostelInfoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Book;
import java.util.List;


public interface BookingInformationRepo extends JpaRepository<BookingInformation,Long> {

    List<BookingInformation> findAllByHostelInfoModel(HostelInfoModel hostelInfoModel);
    BookingInformation findByBookedBy(Integer id);
    List<BookingInformation> findAllByBookedBy(Integer id);
}
