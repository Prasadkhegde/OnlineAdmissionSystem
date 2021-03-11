package com.OnlineAdmissionSystemDemo.App.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OnlineAdmissionSystemDemo.App.entities.Application;

@Repository
public interface IApplicationRepository extends JpaRepository<Application, Integer>{

	public List<Application> findByApplicationId(int applicationId);

}
