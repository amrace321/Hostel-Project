package com.example.demo.hostelrepo;

import java.util.List;

//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.example.demo.modal.HostelInfoModel;


public interface HostelRepository extends CrudRepository<HostelInfoModel, Integer> {
	//@Query ("Select hostelName from hostelInfoMdel where price='10000'")
	 List<HostelInfoModel> findByHostelName(String hostelName);
}
