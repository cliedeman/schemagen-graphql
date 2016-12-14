package com.bretpatterson.schemagen.graphql.examples.boot.web.controller;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GraphQLRequest {
	private final String query;
	private final Map<String, Object> variables;
	private final String operationName;

	@JsonCreator
	public GraphQLRequest(
			@JsonProperty("query") String query,
			@JsonProperty("variables") Map<String, Object> variables,
			@JsonProperty("operationName") String operationName) {
		this.query = query;

		if (variables == null) {
			this.variables = new HashMap<>();
		} else {
			this.variables = variables;
		}

		this.operationName = operationName;
	}

	public String getQuery() {
		return query;
	}

	public Map<String, Object> getVariables() {
		return variables;
	}

	public String getOperationName() {
		return operationName;
	}
}
