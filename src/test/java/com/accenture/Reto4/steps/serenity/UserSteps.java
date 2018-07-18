package com.accenture.Reto4.steps.serenity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;

import com.accenture.Reto4.pages.DictionaryFacebookPage;
import com.accenture.Reto4.pages.DictionaryYouTubePage;
import com.accenture.Reto4.steps.util.ReaderBundle;

import net.thucydides.core.annotations.Step;

public class UserSteps {

//	Difinir una referencia de los diccionarios de las paginas a la cuales el actor manejara
	 DictionaryYouTubePage dictionaryYouTubePage;
	 DictionaryFacebookPage dictionaryFacebookPage;
	
	
//	 Añadir las acciones del usuario sobre las paginas, que seria metodos con la anotacion @Step
	
	 @Step
	 public void is_the_home_page() {
		 dictionaryYouTubePage.open();
	 }
	 
	 @Step
	 public void looks_for_and_start_search(String video) {
		 dictionaryYouTubePage.look_for_the_video(video.concat(" \n"));
		 dictionaryYouTubePage.watch_video();
	 }
	 
	 @Step
	 public void share_it() {
		 dictionaryYouTubePage.share_it();
	 }
	 
	 public void change_tab() {
		 WebDriver driver = dictionaryYouTubePage.getDriver();
		 List<String> list = new ArrayList<>(driver.getWindowHandles());		 
		 driver.switchTo().window(list.get(list.size() - 1));
	 }
	 
	 @Step
	 public void log_in_on_facebook() {
		 dictionaryFacebookPage.writeYourEmail(ReaderBundle.getReader().getStringKey("email"));
		 dictionaryFacebookPage.writeYourPassword(ReaderBundle.getReader().getStringKey("pass").concat("\n"));
	 }
	
	 public void post_the_video() {
		
		 try {
			 dictionaryFacebookPage.postOnFacebook();
			 Thread.sleep(3000);
		 }catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
	 }
}
