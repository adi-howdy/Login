package com.mvc.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.mvc.bean.LoginBean;
import com.mvc.dao.ApplicationDAO;

/**
 * Servlet implementation class FileUploadServlet
 */
@WebServlet("/FileUploadServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50)
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 public static final String UPLOAD_DIR = "image";
	    public String dbFileName = "";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileUploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
        
		Part part = request.getPart("file");
		System.out.print("filenam is " +  request.getPart("file"));
		String fileName = extractFileName(part);
		
		String applicationPath = request.getServletContext().getRealPath("");
		String uploadPath = applicationPath + File.separator + UPLOAD_DIR;
		
		System.out.println("applicationPath:" + applicationPath);
		System.out.println("uploadPath:" + uploadPath);
		
		File fileUploadDirectory = new File(uploadPath);
        if (!fileUploadDirectory.exists()) {
            fileUploadDirectory.mkdirs();
        }
        
        
        String savePath = uploadPath + File.separator + fileName;
        System.out.println("savePath: " + savePath);
        String sRootPath = new File(savePath).getAbsolutePath();
        System.out.println("sRootPath: " + sRootPath);
        part.write(savePath + File.separator);
        //File fileSaveDir1 = new File(savePath);
        
        
        
        
        dbFileName = UPLOAD_DIR + File.separator + fileName;
        part.write(savePath + File.separator);
        
        /**
        for (Part part : request.getParts()) {
            String fileName = extractFileName(part);
            // refines the fileName in case it is an absolute path
            fileName = new File(fileName).getName();
            part.write(uploadPath + File.separator + fileName);
        }
        **/
        //String savePath = uploadPath + File.separator + fileName;
        
        HttpSession session = request.getSession();
        String userName1 = (String) session.getAttribute("userName");
        
        ApplicationDAO dao = new ApplicationDAO();
        String status = dao.uploadPhoto(userName1, savePath);
        
        LoginBean photo = dao.getPhoto(userName1);
        System.out.print("photo path" + photo.getPath());
        
        //request.setAttribute("photo", photo);
        //request.getRequestDispatcher("Info.jsp").forward(request, response);
        
        if(status.equals("good"))
        {
        	request.setAttribute("message", "Photo has been successfully uploaded");
			request.getRequestDispatcher("Home.jsp").forward(request, response);
        	//request.setAttribute("photo", photo);
            //request.getRequestDispatcher("Info.jsp").forward(request, response);
        }
        else
        {
        	request.setAttribute("message", "Sorry Photo could not be uploaded");
			request.getRequestDispatcher("Home.jsp").forward(request, response);
        }
	
	}

	private String extractFileName(Part part) {//This method will print the file name.
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }
}
