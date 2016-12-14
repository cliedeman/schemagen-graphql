package com.bretpatterson.schemagen.graphql.examples.boot;

import com.bretpatterson.schemagen.graphql.GraphQLSchemaBuilder;
import com.bretpatterson.schemagen.graphql.examples.boot.swapi.GraphQLFilmController;
import com.bretpatterson.schemagen.graphql.examples.common.JacksonTypeFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public GraphQL graphQL(GraphQLSchema schema) {
		return new GraphQL(schema);
	}

	@Bean
	@Autowired
	public GraphQLSchema graphQLSchema(
			ObjectMapper objectMapper,
			GraphQLFilmController graphQLFilmController) {
		return GraphQLSchemaBuilder.newBuilder()
				.registerTypeFactory(new JacksonTypeFactory(objectMapper))
				.registerGraphQLControllerObjects(ImmutableList.of(
						graphQLFilmController
				))
				.relayEnabled(true)
				.build();
	}

	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}
}
