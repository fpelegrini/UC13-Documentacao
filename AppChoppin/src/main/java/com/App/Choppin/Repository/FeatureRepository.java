package com.App.Choppin.Repository;

import org.springframework.data.repository.CrudRepository;

import com.App.Choppin.models.Feature;

public interface FeatureRepository extends CrudRepository<Feature, Long>  {

	Feature findById(long id);

}
