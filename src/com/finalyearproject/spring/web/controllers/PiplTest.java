package com.finalyearproject.spring.web.controllers;

import java.io.IOException;

import com.pipl.api.data.containers.Person;
import com.pipl.api.data.fields.Address;
import com.pipl.api.data.fields.Job;
import com.pipl.api.data.fields.Name;
import com.pipl.api.search.SearchAPIError;
import com.pipl.api.search.SearchAPIRequest;
import com.pipl.api.search.SearchAPIResponse;
import com.pipl.api.search.SearchConfiguration;

public class PiplTest {

	public String apiKey = "br9lj9vn9zpall63w8zevkka";

	SearchConfiguration c1 = new SearchConfiguration();

	public void something() throws SearchAPIError, IOException {

		c1.setApiKey(apiKey);
		Person person = new Person(new Name(null, "Clark", null, "Kent", null),
				new Address("US", "KS", "Smallville", null, null, null, null, null),
				new Address("US", "KS", "Metropolis", null, null, null, null, null),
				new Job("Field Reporter", null, null));
		SearchAPIRequest request = new SearchAPIRequest(person, c1);
		something2(request);

	}

	public void something2(SearchAPIRequest request) throws SearchAPIError, IOException {
		SearchAPIResponse response = request.send();
		System.out.println(response.person.toString() + " test");
	}

	public static void main(String[] args) throws SearchAPIError, IOException {
		PiplTest cat = new PiplTest();
		cat.something();
	}

}


