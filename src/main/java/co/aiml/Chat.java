package co.aiml;

import bitoflife.chatterbean.AliceBot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class Chat 
{
	public static final String END = "bye";
	
	public static String input()
	{
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(System.in,"utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println("you say>");
		String input = "";
		try 
		{
			input = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return input;
	}
	
	public static void main(String[] args) throws Exception
	{
		 AliceBotMother mother = new AliceBotMother();
	     mother.setUp();
	     AliceBot bot = mother.newInstance();
	     System.err.println("Alice>" + bot.respond("welcome"));

		while(true)
		 {
			 String input = Chat.input();
			 if(Chat.END.equalsIgnoreCase(input))
				 break;
			 
			 System.err.println("Alice>" + bot.respond(input));
		 }
		 
	}
}
