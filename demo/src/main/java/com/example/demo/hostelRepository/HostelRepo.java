package com.example.demo.hostelRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.modal.HostelInfoModel;

public interface HostelRepo extends JpaRepository<HostelInfoModel, Integer>{

	List<HostelInfoModel> findByHostelAddressLike(String searchName);

}
