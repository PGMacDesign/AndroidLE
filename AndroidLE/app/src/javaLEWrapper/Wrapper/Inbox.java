package javaLEWrapper.Wrapper;

import java.io.IOException;

public class Inbox extends LESuperClass {
	String url = "inbox";

	String ViewInbox(String sessionID, String tag ){
		return "{\"jsonrpc\":2,\"id\":1,\"method\":\"view_inbox\",\"params\":[\""+sessionID+"\",{\"tags\":[\""+tag+"\"],\"page_number\":1}]}";
	}
	String ViewInbox(String sessionID, String tag, int pageNumber ){
		return "{\"jsonrpc\":2,\"id\":1,\"method\":\"view_inbox\",\"params\":[\""+sessionID+"\",{\"tags\":[\""+tag+"\"],\"page_number\":"+pageNumber+"}]}";
	}
	/*String ViewInbox(int RequestID, String sessionID, MessageTags tag ){
		StartOfObject(RequestID, "view_inbox");
		String i = "nothing";
		try {
			writer.value(sessionID);
			//writer.beginArray();
			//writer.beginObject();
			//writer.value(tag.toString());
			//writer.value("{\"Correspondence\"}");
			//writer.endObject();
			//writer.endArray();
			writer.endArray();
			writer.endObject();
			writer.close();
			i = gson.toJson(writer);
			System.out.println(i);
			i = CleanJsonObject(i);
			
		} catch (IOException e) {
			System.out.println("Exception in view Inbox");
			// TODO Auto-generated catch block
			i = "request build failed";
			e.printStackTrace();
		}
		return i = "{\"jsonrpc\":2,\"id\":1,\"method\":\"view_inbox\",\"params\":[\""+sessionID+"\",{\"tags\":[\"Correspondence\"],\"page_number\":1}]}";
		//return i;
	} */
	String ReadMessage(int RequestID, String sessionID, String MessageID){
		StartOfObject(RequestID, "read_message");
		String i = "nothing";
		try {
			writer.value(sessionID);
			writer.value(MessageID);
			writer.endArray();
			writer.endObject();
			writer.close();
			i = gson.toJson(writer);
			System.out.println(i);
			i = CleanJsonObject(i);
			
		} catch (IOException e) {
			System.out.println("Exception in read_message");
			i = "request build failed";
			e.printStackTrace();
		}
		return i;
	}
	String SendMessage(String sessionID, String recipients, String subject, String body){
		StartOfObject(1, "send_message");
		String i = "0";
		try{
			writer.value(sessionID);
			writer.value(recipients);
			writer.value(subject);
			writer.value(body);
			writer.endArray();
			writer.endObject();
			writer.close();
			i = gson.toJson(writer);
			i = CleanJsonObject(i);
		}catch(IOException e){
			System.out.println("ioexception");
		}catch(NullPointerException e){
			System.out.println("null pointer exception");
		}finally{
		}
		return i;
	}
/*enum MessageTags{  //will be leaving this as an option to use in the future, but currently just passing a string directly to the methods instead
		Tutorial, Correspondence, Medal, Intelligence, Alert, Attack, Colonization, Complaint, Excavator, Mission, Parliament, Probe, Spies, Trade, Fissure;
	} */

}
/*
Inbox Methods
view_inbox ( session_id, [ options ] )
session_id
options
page_number
tags
view_archived ( session_id, [ options ])
view_trashed ( session_id, [ options ])
view_sent ( session_id, [ options ] )
read_message ( session_id, message_id )
session_id
message_id
archive_messages ( session_id, message_ids )
session_id
message_ids
trash_messages ( session_id, message_ids )
session_id
message_ids
send_message ( session_id, recipients, subject, body, [ options ] )
session_id
recipients
subject
body
options
in_reply_to
forward
*/