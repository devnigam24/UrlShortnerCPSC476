package com.fullerton.edu.cpsc.cpsc476.Util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;

import com.fullerton.edu.cpsc.cpsc476.DAO.MongoDAO;
import com.fullerton.edu.cpsc.cpsc476.pojo.NewUserDetails;

public class DAOUtil {
	
	
	public static Boolean storeUserInDB(HttpServletRequest req, HttpServletResponse res, NewUserDetails newUser) {
		
		try {
			Document newUserDocument = new Document();
			newUserDocument.put("userName", newUser.getUsername());
			newUserDocument.put("emailId", newUser.getEmailID());
			newUserDocument.put("password", newUser.getPassword());
			MongoDAO MongoDAOobj =  new MongoDAO();
			String message = MongoDAOobj.storeThisDocumentOnThisCollection(newUserDocument,newUser.getUsername());
			if(null == message){
				return true;
			}
			else if(message.equals(ErrorAndMessages.collectionExists)){
				ShowErrorPageUtil.redirectToErrorPage(req,res,"signUp.jsp",ErrorAndMessages.collectionExists);
				return false;
			}else if(message.equals(ErrorAndMessages.serverDown)){
				ShowErrorPageUtil.redirectToErrorPage(req,res,ErrorAndMessages.serverDown);
				return false;
			}else{
				return true;
			}
		} catch (Exception e) {		
			ShowErrorPageUtil.redirectToErrorPage(req,res,e.getMessage());
			return false;
		}
	}
}
