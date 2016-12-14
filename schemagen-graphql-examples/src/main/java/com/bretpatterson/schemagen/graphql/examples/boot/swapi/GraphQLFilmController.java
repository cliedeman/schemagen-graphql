package com.bretpatterson.schemagen.graphql.examples.boot.swapi;

import com.bretpatterson.schemagen.graphql.annotations.GraphQLController;
import com.bretpatterson.schemagen.graphql.annotations.GraphQLParam;
import com.bretpatterson.schemagen.graphql.annotations.GraphQLQuery;
import com.bretpatterson.schemagen.graphql.examples.boot.swapi.model.Film;
import com.bretpatterson.schemagen.graphql.examples.boot.swapi.repository.FilmsRepository;
import com.bretpatterson.schemagen.graphql.relay.Edge;
import com.bretpatterson.schemagen.graphql.relay.PageInfo;
import com.bretpatterson.schemagen.graphql.relay.RelayConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@GraphQLController
@Component
public class GraphQLFilmController {

	private final FilmsRepository filmsRepository;

	@Autowired
	public GraphQLFilmController(FilmsRepository filmsRepository) {
		this.filmsRepository = filmsRepository;
	}

	@GraphQLQuery
	public RelayConnection<Film> allFilms(
			@GraphQLParam(name = "after") String after,
			@GraphQLParam(name = "before") String before,
			@GraphQLParam(name = "first") String first,
			@GraphQLParam(name = "last") String last
	) {
		RelayConnection<Film> result = new RelayConnection<>();

		result.setEdges(createEdges());
		result.setPageInfo(createPageInfo(before, after, first, last));

		return result;
	}

	private List<Edge<Film>> createEdges() {
		List<Edge<Film>> edges = new ArrayList<>();

		for (Film film : filmsRepository.getAll()) {
			edges.add(new Edge<>(film, null));
		}

		return edges;
	}

	private PageInfo createPageInfo(String before, String after, String first, String last) {
		PageInfo pageInfo = new PageInfo();

		return pageInfo;
	}
}
