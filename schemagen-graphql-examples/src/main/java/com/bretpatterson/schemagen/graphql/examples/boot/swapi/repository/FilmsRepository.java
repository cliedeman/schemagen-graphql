package com.bretpatterson.schemagen.graphql.examples.boot.swapi.repository;

import com.bretpatterson.schemagen.graphql.examples.boot.swapi.model.Film;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class FilmsRepository {

	private static final List<Film> FILMS = Arrays.asList(
			new Film(
					"1",
					"A New Hope",
					"4",
					"It is a period of civil war.\r\nRebel spaceships, striking\r\nfrom a hidden base, have won\r\ntheir first victory against\r\nthe evil Galactic Empire.\r\n\r\nDuring the battle, Rebel\r\nspies managed to steal secret\r\nplans to the Empire's\r\nultimate weapon, the DEATH\r\nSTAR, an armored space\r\nstation with enough power\r\nto destroy an entire planet.\r\n\r\nPursued by the Empire's\r\nsinister agents, Princess\r\nLeia races home aboard her\r\nstarship, custodian of the\r\nstolen plans that can save her\r\npeople and restore\r\nfreedom to the galaxy....",
					"George Lucas",
					Arrays.asList(
							"Gary Kurtz",
							"Rick McCallum"
					),
					new Date(1977, 5, 25),
					"2014-12-10T14:23:31.880Z",
					"2014-12-20T19:49:45.256Z"
			)
	);

	public Film getById(String id) {
		return FILMS.stream().filter(f -> f.getId().equals(id)).findFirst().orElseGet(null);
	}

	public List<Film> getAll() {
		return new ArrayList<>(FILMS);
	}
}
