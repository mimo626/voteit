package com.example.voteit.Repository;

import com.example.voteit.Entity.VoteIt;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteItRepository extends CrudRepository<VoteIt, Long>{

}

