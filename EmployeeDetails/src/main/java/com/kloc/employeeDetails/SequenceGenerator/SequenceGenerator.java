package com.kloc.employeeDetails.SequenceGenerator;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.kloc.employeeDetails.Entity.DeptSeq;
import com.kloc.employeeDetails.Entity.EmpAddSeq;
import com.kloc.employeeDetails.Entity.EmpSeq;


@Service
public class SequenceGenerator 
{
	@Autowired
	private MongoOperations mongoOperations;
	
	public int getEmpSequenceNumber(String sequenceName)
	{
		//get sequence number
		Query query=new Query(Criteria.where("id").is(sequenceName));
		// update the sequence number
		Update update=new Update().inc("seq",1); 
		// modify the document
		EmpSeq counter=mongoOperations.findAndModify(query, update,FindAndModifyOptions.options().returnNew(true).upsert(true),EmpSeq.class);
		return !Objects.isNull(counter)?counter.getSeq():1;
	}
	public int getDeptSequenceNumber(String sequenceName)
	{
		//get sequence number
		Query query=new Query(Criteria.where("id").is(sequenceName));
		// update the sequence number
		Update update=new Update().inc("seq",1); 
		// modify the document
		DeptSeq counter=mongoOperations.findAndModify(query, update,FindAndModifyOptions.options().returnNew(true).upsert(true),DeptSeq.class);
		return !Objects.isNull(counter)?counter.getSeq():1;
	}
	public int getAddressSequenceNumber(String sequenceName)
	{
		//get sequence number
		Query query=new Query(Criteria.where("id").is(sequenceName));
		// update the sequence number
		Update update=new Update().inc("seq",1); 
		// modify the document
		EmpAddSeq counter=mongoOperations.findAndModify(query, update,FindAndModifyOptions.options().returnNew(true).upsert(true),EmpAddSeq.class);
		return !Objects.isNull(counter)?counter.getSeq():1;
	}
}
