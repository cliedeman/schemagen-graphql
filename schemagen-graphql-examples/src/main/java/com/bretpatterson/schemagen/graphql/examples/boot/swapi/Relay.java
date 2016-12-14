package com.bretpatterson.schemagen.graphql.examples.boot.swapi;


public class Relay {

	private static final graphql.relay.Relay RELAY = new graphql.relay.Relay();

	private Relay() {
	}

	public static graphql.relay.Relay.ResolvedGlobalId fromGloblId(String globalId) {
		return RELAY.fromGlobalId(globalId);
	}

	public static String toGlobalId(String type, String id) {
		return RELAY.toGlobalId(type, id);
	}
}
