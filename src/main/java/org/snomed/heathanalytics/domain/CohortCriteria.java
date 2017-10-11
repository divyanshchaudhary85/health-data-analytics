package org.snomed.heathanalytics.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldIndex;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Document(indexName = "cohort")
public class CohortCriteria {

	@Id
	private String id;

	@Field(index = FieldIndex.not_analyzed)
	private String name;

	@Field(index = FieldIndex.not_analyzed)
	private String description;

	@Field(type = FieldType.String)
	private Gender gender;

	@Field(type = FieldType.Integer)
	private Integer minAge;

	@Field(type = FieldType.Integer)
	private Integer maxAge;

	@Field(type = FieldType.Object)
	private Criterion primaryExposure;

	@Field(type = FieldType.Object)
	private List<RelativeCriterion> inclusionCriteria;

	public CohortCriteria() {
	}

	public CohortCriteria(Criterion primaryExposure) {
		this.primaryExposure = primaryExposure;
	}

	public void addInclusionCriterion(RelativeCriterion criterion) {
		if (inclusionCriteria == null) {
			inclusionCriteria = new ArrayList<>();
		}
		inclusionCriteria.add(criterion);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Integer getMinAge() {
		return minAge;
	}

	public void setMinAge(Integer minAge) {
		this.minAge = minAge;
	}

	public Integer getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(Integer maxAge) {
		this.maxAge = maxAge;
	}

	public Criterion getPrimaryExposure() {
		return primaryExposure;
	}

	public void setPrimaryExposure(Criterion primaryExposure) {
		this.primaryExposure = primaryExposure;
	}

	public List<RelativeCriterion> getInclusionCriteria() {
		return inclusionCriteria != null ? inclusionCriteria : Collections.emptyList();
	}

	public void setInclusionCriteria(List<RelativeCriterion> inclusionCriteria) {
		this.inclusionCriteria = inclusionCriteria;
	}
}
