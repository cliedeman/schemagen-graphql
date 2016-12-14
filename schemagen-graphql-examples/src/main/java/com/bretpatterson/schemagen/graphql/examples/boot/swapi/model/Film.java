package com.bretpatterson.schemagen.graphql.examples.boot.swapi.model;

import com.bretpatterson.schemagen.graphql.relay.INode;

import java.util.Date;
import java.util.List;

public class Film implements INode {

	private String id;
	private String title;
	private String episodeId;
	private String openingCrawl;
	private String director;
	private List<String> producers;
	private Date releaseDate;
	private String edited;
	private String created;

	// TODO connections


	public Film() {
	}

	public Film(String id, String title, String episodeId,
				String openingCrawl, String director,
				List<String> producers, Date releaseDate,
				String edited, String created) {
		this.id = id;
		this.title = title;
		this.episodeId = episodeId;
		this.openingCrawl = openingCrawl;
		this.director = director;
		this.producers = producers;
		this.releaseDate = releaseDate;
		this.edited = edited;
		this.created = created;
	}

	@Override
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEpisodeId() {
		return episodeId;
	}

	public void setEpisodeId(String episodeId) {
		this.episodeId = episodeId;
	}

	public String getOpeningCrawl() {
		return openingCrawl;
	}

	public void setOpeningCrawl(String openingCrawl) {
		this.openingCrawl = openingCrawl;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public List<String> getProducers() {
		return producers;
	}

	public void setProducers(List<String> producers) {
		this.producers = producers;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getEdited() {
		return edited;
	}

	public void setEdited(String edited) {
		this.edited = edited;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}
}
