/**
 * 
 */
package com.yuyang226.flickr.oauth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.aetrion.flickr.Flickr;
import com.aetrion.flickr.RequestContext;
import com.aetrion.flickr.people.User;
import com.aetrion.flickr.photos.Photo;



/**
 * @author Toby Yu(yuyang226@gmail.com)
 *
 */
public class OAuthTest {

	/**
	 * 
	 */
	public OAuthTest() {
		// TODO Auto-generated constructor stub
	}

	private static String readParamFromCommand(String message) throws IOException {
		//  prompt the user to enter their name
		System.out.print(message);
		//  open up standard input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		return String.valueOf(br.readLine()).trim();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Flickr f = new Flickr("cf133e9bab9b574fa5f8166c9ecf6455", "d9b66ded5812c3a8");
			/*OAuthToken oauthToken = f.getOAuthInterface().getRequestToken("http://localhost");
			System.out.println(oauthToken);
			System.out.println(f.getOAuthInterface().buildAuthenticationUrl(Permission.READ, oauthToken));
			String tokenVerifier = readParamFromCommand("Enter Token Verifier: ");
			f.getOAuthInterface().getAccessToken(oauthToken, tokenVerifier);
			f.getOAuthInterface().testLogin();*/
			
			//oauth_token=72157626911878883-7288bed42b42e288, oauth_token_secret=9b5e1fc9a8d33997
			OAuth auth = new OAuth();
			User user = new User();
			user.setId("id=8308954@N06");
			user.setUsername("Yang and Yun's Album");
			auth.setToken(new OAuthToken("72157626911878883-7288bed42b42e288", "9b5e1fc9a8d33997"));
			RequestContext.getRequestContext().setOAuth(auth);
			f.setOAuth(auth);
			
			System.out.println(f.getOAuthInterface().testLogin());
//			System.out.println(f.getActivityInterface().userComments(0, 0));
//			System.out.println(f.getActivityInterface().userPhotos(1, 1, null));
//			System.out.println(f.getBlogsInterface().getServices());
//			System.out.println(f.getBlogsInterface().getList());
//			System.out.println(f.getCommonsInterface().getInstitutions());
//			System.out.println(f.getContactsInterface().getList());
//			System.out.println(f.getContactsInterface().getPublicList("8308954@N06"));
//			System.out.println(f.getContactsInterface().getListRecentlyUploaded(
//					new Date(System.currentTimeMillis() - 24L * 60L * 60L * 1000L), null));
//			System.out.println(f.getPeopleInterface().findByEmail("wanyun892@yahoo.cn"));
//			System.out.println(f.getPeopleInterface().findByUsername("wanyun(Wandy)"));
//			System.out.println(f.getPeopleInterface().getInfo("8308954@N06"));
//			System.out.println(f.getPeopleInterface().getPublicGroups("8308954@N06"));
//			System.out.println(f.getPeopleInterface().getUploadStatus());
			Photo photo = f.getPeopleInterface().getPublicPhotos("8308954@N06", 0, 0).get(0);
			//photo ID: 6024664723
			//System.out.println(f.getPeopleInterface().getPhotos("8308954@N06", null, 0, 0));
			//f.getFavoritesInterface().add(photo.getId());
//			System.out.println("Favourites List: \n" + f.getFavoritesInterface().getList("8308954@N06", 0, 0, null));
//			System.out.println("Favourites Public List: \n" + f.getFavoritesInterface().getPublicList("8308954@N06", 0, 0, null));
			//group ID: 95014477@N00
//			Group group = f.getGroupsInterface().search("Nikon", 0, 0).iterator().next();
//			System.out.println(f.getGroupsInterface().getInfo(group.getId()));
//			System.out.println(f.getMembersInterface().getList(group.getId(), null, 0, 0));
//			System.out.println(f.getGeoInterface().getLocation("6024664723"));
//			System.out.println(f.getGeoInterface().getPerms("6024664723"));
			System.out.println(f.getLicensesInterface().getInfo());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
