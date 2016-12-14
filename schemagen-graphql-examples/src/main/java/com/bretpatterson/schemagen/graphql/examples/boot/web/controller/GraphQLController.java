package com.bretpatterson.schemagen.graphql.examples.boot.web.controller;

import graphql.ExecutionResult;
import graphql.GraphQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GraphQLController {

	private GraphQL graphQL;

	@Autowired
	public GraphQLController(GraphQL graphQL) {
		this.graphQL = graphQL;
	}

	@RequestMapping(value = "/graphql", method = RequestMethod.POST)
	public ExecutionResult graphql(
			@RequestBody GraphQLRequest request) {
		return graphQL.execute(
				request.getQuery(),
				request.getOperationName(),
				null,
				request.getVariables());
	}
}
