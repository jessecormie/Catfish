package com.finalyearproject.spring.web.controllers;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.plaf.synth.SynthSpinnerUI;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.finalyearproject.spring.web.entity.Catfish;
import com.finalyearproject.spring.web.entity.FullContactPerson;
import com.finalyearproject.spring.web.entity.PiplPerson;
import com.fullcontact.api.libs.fullcontact4j.FullContact;
import com.fullcontact.api.libs.fullcontact4j.FullContactException;
import com.fullcontact.api.libs.fullcontact4j.http.person.PersonRequest;
import com.fullcontact.api.libs.fullcontact4j.http.person.PersonResponse;
import com.fullcontact.api.libs.fullcontact4j.http.person.model.SocialProfile;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.pipl.api.data.containers.Person;
import com.pipl.api.data.fields.Email;
import com.pipl.api.data.fields.Name;
import com.pipl.api.search.SearchAPIError;
import com.pipl.api.search.SearchAPIRequest;
import com.pipl.api.search.SearchAPIResponse;
import com.pipl.api.search.SearchConfiguration;

import javaxt.io.Image;

/**
 * Handles requests for the application file upload requests
 */
// TODO
// http://docs.oracle.com/javase/7/docs/technotes/guides/scripting/programmer_guide/

@Controller
public class FileUploadController {

	private Catfish suspect = new Catfish();
	private FullContactPerson fullContactPerson = new FullContactPerson();
	private PiplPerson piplPerson = new PiplPerson();
	private double totalProbability;
	private double probability;

	private List<String> imagesToShow = new ArrayList<String>();
	private List<String> websitesToShow = new ArrayList<String>();

	@RequestMapping("/catfishform")
	public String uploadImage() {
		imagesToShow.clear();
		websitesToShow.clear();
		return "catfishimage";
	}

	@RequestMapping("/catfishimage")
	public String reverseGoogleImageSearch(Model model,
			@RequestParam(value = "image", required = false) MultipartFile file)
			throws IllegalStateException, IOException, SearchAPIError, FullContactException {

		// Sets MultipartFile to File
		File tmpFile = new File(System.getProperty("java.io.tmpdir") + System.getProperty("file.separator")
				+ file.getOriginalFilename());
		file.transferTo(tmpFile);

		// takes image and gets reverse google image address
		HttpClient client = new DefaultHttpClient();
		String url = "https://www.google.com/searchbyimage/upload";

		HttpPost post = new HttpPost(url);

		MultipartEntityBuilder entity = MultipartEntityBuilder.create();
		entity.addPart("encoded_image", new FileBody(tmpFile));
		entity.addPart("image_url", new StringBody(""));
		entity.addPart("image_content", new StringBody(""));
		entity.addPart("filename", new StringBody(""));
		entity.addPart("h1", new StringBody("en"));
		entity.addPart("bih", new StringBody("179"));
		entity.addPart("biw", new StringBody("1600"));

		HttpEntity builder = entity.build();

		post.setEntity(builder);
		HttpResponse httpResponse = client.execute(post);
		String pictureLink = null;

		try {
			HttpEntity entity2 = httpResponse.getEntity();
			String responseString = EntityUtils.toString(entity2, "UTF-8");
			entity2.getContent();
			Document document = Jsoup.parse(responseString, "UTF-8");
			Elements links = document.select("a[href]");
			pictureLink = links.attr("abs:href");

		} catch (Exception e) {
			System.out.println("nope" + e);
		}

		List<String> reverseImagePics = reverseGoogleImageScrapePicture(pictureLink);
		List<String> reverseImageWebsites = reverseGoogleImageScrapeWebsite(pictureLink);

		model.addAttribute("reverseImagePics", reverseImagePics);
		model.addAttribute("reverseImageWebsites", reverseImageWebsites);

		extractImgGeoAndDate(tmpFile);

		return "catfishreverseimage";
	}

	private void extractImgGeoAndDate(File tmpFile) {
		try {
			Image image = new Image(tmpFile.getAbsolutePath());

			java.util.HashMap<Integer, Object> exif = image.getExifTags();

			Object date = exif.get(0x0132);
			suspect.setMetadataDate(date);

			double[] coord = image.getGPSCoordinate();
			if (coord != null) {
				double latitude = coord[0];
				double longitude = coord[1];
				suspect.setMetadataLat(latitude);
				suspect.setMetadataLong(longitude);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// TODO Reduce lines of code, paramaters and complexity
	@RequestMapping("/catfishreverseimage")
	public String reverseImageResults(Model model, @RequestParam(value = "image1") String image1,
			@RequestParam(value = "image2") String image2, @RequestParam(value = "image3") String image3,
			@RequestParam(value = "image4") String image4, @RequestParam(value = "image5") String image5,
			@RequestParam(value = "noImage") String noImage,
			@RequestParam(value = "reverseImageWebsites") List<String> reverseImageWebsites) {

		if (!image1.equalsIgnoreCase("no")) {
			imagesToShow.add(image1);
			websitesToShow.add(reverseImageWebsites.get(0).substring(1));
		}

		if (!image2.equalsIgnoreCase("no")) {
			imagesToShow.add(image2);
			websitesToShow.add(reverseImageWebsites.get(1));
		}

		if (!image3.equalsIgnoreCase("no")) {
			imagesToShow.add(image3);
			websitesToShow.add(reverseImageWebsites.get(2));
		}

		if (!image4.equalsIgnoreCase("no")) {
			imagesToShow.add(image4);
			websitesToShow.add(reverseImageWebsites.get(3));
		}

		if (!image5.equalsIgnoreCase("no")) {
			imagesToShow.add(image5);
			websitesToShow.add(reverseImageWebsites.get(4).substring(0, reverseImageWebsites.get(4).length() - 1));
		}

		if (noImage.equals("noImage")) {
			imagesToShow.clear();
			websitesToShow.clear();
		}
		return "catfishform";
	}

	@RequestMapping(value = "/catfishform", method = RequestMethod.POST)
	public String addPersonFromForm(Model model, @RequestParam(value = "catFirstName") String catFirstName,
			@RequestParam(value = "catLastName") String catLastName, @RequestParam(value = "address") String catAddress,
			@RequestParam(value = "catDateOfBirth") String catDateOfBirth,
			@RequestParam(value = "catPhone") String catPhone, @RequestParam(value = "catFacebook") String catFacebook,
			@RequestParam(value = "catGender") String catGender, @RequestParam(value = "catEmail") String catEmail)
			throws IllegalStateException, IOException, SearchAPIError, FullContactException {

		totalProbability = 0;
		probability = 0;

		reverseGoogleImageProb(model);

		suspect = new Catfish(catFirstName, catLastName, catDateOfBirth, catGender, catAddress, catFacebook, catPhone,
				suspect.getMetadataDate(), suspect.getMetadataLat(), suspect.getMetadataLong(),
				suspect.getReverseImagePics(), suspect.getReverseImageWebsites());

		model.addAttribute("suspect", suspect);

		fullContactSearch(catEmail);
		piplSearch(catFirstName, catLastName, catEmail);

		// calculates probability
		double finalProbability = 100 - (probability / totalProbability * 100);
		DecimalFormat df2 = new DecimalFormat(".##");
		String finalProbability2 = df2.format(finalProbability);

		// checks that pipl person url is a facebook link
		String piplPersonFacebook = "unknown";
		if (piplPerson.getPiplUrl().contains("facebook")) {
			piplPersonFacebook = piplPerson.getPiplUrl();
			System.out.println("Url contains fb " + piplPersonFacebook);
		} else {
			piplPersonFacebook = "unknown";
			System.out.println("Url does not contain fb");
		}

		fullContactPerson.setPhone("unknown");
		String resultFirstName = mergeResults(fullContactPerson.getFirstName(), piplPerson.getFirstName());
		model.addAttribute("ResultFirstName", resultFirstName);

		String resultLastName = mergeResults(fullContactPerson.getLastName(), piplPerson.getLastName());
		model.addAttribute("ResultLastName", resultLastName);

		String resultGender = mergeResults(fullContactPerson.getGender(), piplPerson.getGender());
		model.addAttribute("ResultGender", resultGender);

		String resultAge = mergeResults(fullContactPerson.getAge(), piplPerson.getAge());
		model.addAttribute("ResultAge", resultAge);

		String resultPhone = mergeResults(fullContactPerson.getPhone(), piplPerson.getPhone());
		model.addAttribute("ResultPhone", resultPhone);

		System.out.println("FullContact Facebook: " + fullContactPerson.getFacebook());
		System.out.println("Pipl Facebook: " + piplPersonFacebook);

		try {
			if (fullContactPerson.getFacebook().equalsIgnoreCase("unknown")) {
				fullContactPerson.setFacebook(null);
			}
		} catch (Exception e) {

		}
		try {
			if (piplPersonFacebook.equalsIgnoreCase("unknown")) {
				piplPersonFacebook = null;
			}
		} catch (Exception e) {

		}

		model.addAttribute("ResultFullContactFacebook", fullContactPerson.getFacebook());
		model.addAttribute("ResultPiplFacebook", piplPersonFacebook);
		model.addAttribute("percent", finalProbability2);
		model.addAttribute("fullContactPerson", fullContactPerson);
		model.addAttribute("piplPerson", piplPerson);
		model.addAttribute("suspect", suspect);

		return "catfishreport";
	}

	private void piplSearch(String catFirstName, String catLastName, String catEmail) {
		// pipl api
		String apiKey = "br9lj9vn9zpall63w8zevkka";
		SearchConfiguration c1 = new SearchConfiguration();
		c1.setApiKey(apiKey);
		SearchAPIRequest request;

		try {

			Person person = new Person(new Name(null, catFirstName, null, catLastName, null),
					new Email(catEmail, null));
			request = new SearchAPIRequest(person, c1);
			SearchAPIResponse response = request.send();

			System.out.println("**************************** Pipl Api ****************************");
			System.out.println("******* As Strings ************");
			try {
				piplPerson.setFirstName(response.name().first);
				if (piplPerson.getFirstName().equalsIgnoreCase(suspect.getFirstName())) {
					totalProbability = totalProbability + 100;
					probability = probability + 100;
					System.out.println("first names match");
				} else {
					totalProbability = totalProbability + 100;
					System.out.println("first names dont match");
				}
			} catch (Exception e) {
				piplPerson.setFirstName("unknown");
				System.out.println(e);
				System.out.println("No fname info");
			}
			try {
				piplPerson.setLastName(response.name().last);
				if (piplPerson.getLastName().equalsIgnoreCase(suspect.getLastName())) {
					totalProbability = totalProbability + 100;
					probability = probability + 100;
					System.out.println("last names match");
				} else {
					totalProbability = totalProbability + 100;
					System.out.println("last names dont match");
				}
			} catch (Exception e) {
				piplPerson.setLastName("unknown");
				System.out.println(e);
				System.out.println("No lname info");
			}

			try {
				piplPerson.setLocation(response.address().display);
			} catch (Exception e) {
				piplPerson.setLocation(null);
				System.out.println(e);
				System.out.println("No display address info");
			}

			try {
				piplPerson.setAge(response.dob().display);
				int suspectAge = Integer.parseInt(suspect.getAge());
				int apiAgee = piplPerson.getAge().indexOf(" ");
				String apiAgeString = piplPerson.getAge().substring(0, apiAgee);
				int apiAge = Integer.parseInt(apiAgeString);
				int max = apiAge + 5;
				int min = apiAge - 5;
				if (suspectAge >= min && suspectAge <= max) {
					totalProbability = totalProbability + 100;
					probability = probability + 100;
					System.out.println("ages  match");
				} else {
					totalProbability = totalProbability + 100;
					System.out.println("ages dont match");
				}
			} catch (Exception e) {
				piplPerson.setAge("unknown");
				System.out.println(e);
				System.out.println("No age info");
			}
			try {
				piplPerson.setGender(response.gender().content.toString());
				if (piplPerson.getGender().equalsIgnoreCase(suspect.getGender())) {
					totalProbability = totalProbability + 100;
					probability = probability + 100;
					System.out.println("Genders match");
				} else {
					totalProbability = totalProbability + 100;
					System.out.println("Genders match");
				}
			} catch (Exception e) {
				piplPerson.setGender("unknown");
				System.out.println(e);
				System.out.println("No gender info");
			}
			try {
				piplPerson.setPiplImage(response.image().url);
			} catch (Exception e) {
				System.out.println(e);
				System.out.println("No image url info");
			}
			try {
				piplPerson.setPiplRelations(response.relationship());

			} catch (Exception e) {
				System.out.println(e);
				System.out.println("No relationship fname info");
			}
			try {
				piplPerson.setPhone(response.phone().display);
				if (!suspect.getPhone().isEmpty()) {
					if (piplPerson.getPhone().equals(suspect.getPhone())) {
						totalProbability = totalProbability + 100;
						probability = probability + 100;
						System.out.println("phones match");
					} else {
						totalProbability = totalProbability + 100;
						System.out.println("phones dont match");
					}
				}
			} catch (Exception e) {
				piplPerson.setPhone("unknown");
				System.out.println(e);
				System.out.println("No phone info");
			}
			try {
				piplPerson.setPiplJob(response.job().display);
			} catch (Exception e) {
				System.out.println(e);
				System.out.println("No job info");
			}
			try {
				piplPerson.setPiplUrl(response.url().url);
				if (piplPerson.getPiplUrl().contains("facebook")) {
					System.out.println("Contains the word facebook " + piplPerson.getPiplUrl());
					if (piplPerson.getPiplUrl().equalsIgnoreCase(suspect.getFacebook())) {
						totalProbability = totalProbability + 100;
						probability = probability + 100;
						System.out.println("Facebook match");
					}
				} else {
					System.out.println("Doesn't contain the word facebook");
				}

			} catch (Exception e) {
				piplPerson.setPiplUrl("unknown");
				System.out.println(e);
			}
		} catch (Exception e) {
			System.out.println("User not found");
			piplPerson.setFirstName("unknown");
			piplPerson.setLastName("unknown");
			piplPerson.setGender("unknown");
			piplPerson.setAge("unknown");
			piplPerson.setPhone("unknown");
			piplPerson.setPiplUrl("unknown");
		}
	}

	private void fullContactSearch(String catEmail) {
		// FullContact api
		FullContact fullContact = FullContact.withApiKey("be0e983c690750e").build();

		try {
			PersonRequest personRequest = fullContact.buildPersonRequest().email(catEmail).build();
			PersonResponse personResponse = fullContact.sendRequest(personRequest);

			try {
				fullContactPerson.setFirstName(personResponse.getContactInfo().getGivenName());
				if (fullContactPerson.getFirstName().equalsIgnoreCase(suspect.getFirstName())) {
					totalProbability = totalProbability + 100;
					probability = probability + 100;
				} else {
					totalProbability = totalProbability + 100;
				}
			} catch (Exception e) {
				fullContactPerson.setFirstName("unknown");
			}
			try {
				fullContactPerson.setLastName(personResponse.getContactInfo().getFamilyName());
				if (fullContactPerson.getLastName().equalsIgnoreCase(suspect.getLastName())) {
					totalProbability = totalProbability + 100;
					probability = probability + 100;
				} else {
					totalProbability = totalProbability + 100;
				}

			} catch (Exception e) {
				fullContactPerson.setLastName("unknown");
			}
			try {
				fullContactPerson.setGender(personResponse.getDemographics().getGender());
				if (fullContactPerson.getGender().charAt(0) == suspect.getGender().charAt(0)
						&& fullContactPerson.getGender().charAt(1) == suspect.getGender().charAt(1)) {
					totalProbability = totalProbability + 100;
					probability = probability + 100;
				} else {
					totalProbability = totalProbability + 100;
				}
			} catch (Exception e) {
				fullContactPerson.setGender("unknown");
			}
			try {
				fullContactPerson.setLocation(personResponse.getDemographics().getLocationGeneral());
			} catch (Exception e) {
				fullContactPerson.setLocation(null);
			}
			try {
				fullContactPerson.setAge(personResponse.getDemographics().getAge());

				int suspectAge = Integer.parseInt(suspect.getAge());
				int apiAge = fullContactPerson.getAge().charAt(0) + fullContactPerson.getAge().charAt(1);
				int max = apiAge + 5;
				int min = apiAge - 5;
				if (suspectAge >= min && suspectAge <= max) {
					totalProbability = totalProbability + 100;
					probability = probability + 100;
				} else {
					totalProbability = totalProbability + 100;
				}
			} catch (Exception e) {
				fullContactPerson.setAge("unknown");
			}
			try {
				fullContactPerson.setFcPhotos(personResponse.getPhotos());
			} catch (Exception e) {
			}
			try {
				fullContactPerson.setFcJob(personResponse.getOrganizations());
			} catch (Exception e) {
			}
			try {
				fullContactPerson.setFcSocialProfiles(personResponse.getSocialProfiles());
				for (SocialProfile f : fullContactPerson.getFcSocialProfiles()) {
					if (f.getUrl().equals(suspect.getFacebook())) {
						fullContactPerson.setFacebook(f.getUrl());
						totalProbability = totalProbability + 100;
						probability = probability + 100;
					} else {
						fullContactPerson.setFacebook("unknown");
					}
				}
			} catch (Exception e) {
				fullContactPerson.setFacebook("unknown");
			}
			try {
				fullContactPerson.setChildren(personResponse.getDemographics().getChildren());
			} catch (Exception e) {
			}

			try {
				fullContactPerson.setMaritalStatus(personResponse.getDemographics().getMaritalStatus());
			} catch (Exception e) {
			}

			try {
				fullContactPerson.setLikely(personResponse.getLikelihood());
			} catch (Exception e) {
			}
		} catch (Exception e) {
			System.out.println("User not found");
			fullContactPerson.setFirstName("unknown");
			fullContactPerson.setLastName("unknown");
			fullContactPerson.setGender("unknown");
			fullContactPerson.setAge("unknown");
			fullContactPerson.setFacebook("unknown");
		}
	}

	private void reverseGoogleImageProb(Model model) {
		model.addAttribute("imagesToShow", imagesToShow);
		model.addAttribute("websitesToShow", websitesToShow);

		if (imagesToShow.size() == 5) {
			totalProbability = totalProbability + 500;
		} else if (imagesToShow.size() == 4) {
			totalProbability = totalProbability + 400;
		} else if (imagesToShow.size() == 3) {
			totalProbability = totalProbability + 300;
		} else if (imagesToShow.size() == 2) {
			totalProbability = totalProbability + 200;
		} else if (imagesToShow.size() == 1) {
			totalProbability = totalProbability + 100;
		} else if (imagesToShow.isEmpty()) {
			probability = probability + 100;
			totalProbability = totalProbability + 100;
		}
	}

	public String mergeResults(String fullContact, String pipl) {
		String value = "";
		// if fullContact name is not empty
		if (!fullContact.equals("unknown")) {
			// set value to fullContacts value
			value = fullContact;
			// check that pipl name is not empty
			if (!pipl.equals("unknown")) {
				// if the two names are the same
				if (fullContact.equalsIgnoreCase(pipl)) {
					// print one of the name as they're both the same
					value = fullContact;
				} else {
					// print both names
					value = fullContact + "/" + pipl;
				}
			}
		} else if (!pipl.equals("unknown")) {
			// set value to pipl value
			value = pipl;

		} else {
			// both fullContact and Pipl were unknown, set value "unknown"
			value = "Not Found";
		}
		return value;
	}

	public List<String> reverseGoogleImageScrapePicture(String pictureLink)
			throws FailingHttpStatusCodeException, MalformedURLException, IOException {

		WebClient webClient = new WebClient();
		HtmlPage page = webClient.getPage(pictureLink);

		List<?> topics = page.getByXPath("//a[@class='bia uh_rl']//g-img[@class='iuth']//img/@src");
		List<String> pictures = new ArrayList<String>();

		for (int i = 0; i <= 4; i++) {
			// passes through the list and a number to say which images you want
			// and returns the link and add its to the list of pictures
			// picturesWebsite.add(findLink(topicsWebsite, i));
			pictures.add(findLink(topics, i));
		}
		webClient.close();
		return pictures;
	}

	public List<String> reverseGoogleImageScrapeWebsite(String pictureLink)
			throws FailingHttpStatusCodeException, MalformedURLException, IOException {
		WebClient webClient = new WebClient();
		HtmlPage page = webClient.getPage(pictureLink);

		List<?> topicsWebsite = page.getByXPath("//a[@class='bia uh_rl']//g-img[@class='iuth']//img/@title");
		List<String> picturesWebsite = new ArrayList<String>();

		for (int i = 0; i <= 4; i++) {
			picturesWebsite.add(findLink(topicsWebsite, i));
		}
		webClient.close();
		return picturesWebsite;
	}

	private String findLink(List<?> topics, int i) {
		String src = topics.get(i).toString();
		// splits it to get the specific part of the string which is the src
		// value method to get rid of the last char which is a ]
		String[] parts = src.split("value=");
		String link = removeLastChar(parts[1]);

		return link;
	}

	private static String removeLastChar(String str) {
		return str.substring(0, str.length() - 1);
	}

	@RequestMapping("/catfishreport")
	public String postReport(Model model) {
		return "catfishreport";
	}

}